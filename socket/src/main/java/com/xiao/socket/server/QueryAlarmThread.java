package com.xiao.socket.server;

import com.alibaba.fastjson.JSON;
import com.xiao.socket.common.OperationLog;
import com.xiao.socket.common.SpringUtil;
import com.xiao.socket.domain.AlarmDataVO;
import com.xiao.socket.service.AlarmDataService;
import com.xiao.socket.service.GenerateAlarmDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: guoyanjun
 * @date: 2018/11/17 18:27
 */
public class QueryAlarmThread extends Thread {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private short startSign = (short)0xFFFF;
    private int timeStamp = (int)System.currentTimeMillis()/1000;
    private byte alarmType = 0;
    Socket socket ;
    DataOutputStream dos ;
    BufferedInputStream bis ;
    @Autowired
    private static AlarmDataService alarmDataService;
    @Autowired
    private static GenerateAlarmDataService generateAlarmDataService;
    static{
        alarmDataService = SpringUtil.getBean(AlarmDataService.class);
        generateAlarmDataService = SpringUtil.getBean(GenerateAlarmDataService.class);
    }

    public QueryAlarmThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        init();
        String inputStr;
        String outputStr;
        DataInputStream dis = null;
        Thread loopThread = null;
        try {
            while (true) {
                byte[] bytes = new byte[9];
                ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
                dis = new DataInputStream(bis);
                dis.readFully(bytes);
                DataInputStream ois = new DataInputStream(bais);
                short s1 = ois.readShort();
                byte s2 = ois.readByte();
                int s3 = ois.readInt();
                short length = ois.readShort();
                byte[] body = new byte[length];
                dis.readFully(body);
                inputStr = new String(body, "UTF-8");
                logger.info("socket client input info:{}", inputStr);
                if (inputStr.contains("closeConnAlarm")) {
                    logger.info("==============msg contains closeConnAlarm");
                    OperationLog.closeTime = LocalDateTime.now();
                    OperationLog.writeLog("close socket ");
                    socket.close();
                    break;
                }

                //4、获取输出流，响应客户端的请求
                outputStr = buildMessage(inputStr, dos);
                logger.info("socket client output info:{}", outputStr);
                if (StringUtils.isEmpty(outputStr)) {
                    continue;
                }
                dos.writeShort(startSign);
                dos.writeByte(alarmType);
                dos.writeInt(timeStamp);
                dos.writeShort(outputStr.getBytes("UTF-8").length);
                dos.write(outputStr.getBytes("UTF-8"));
                OperationLog.writeLog("output msg: " + outputStr);
                if (inputStr.contains("reqLoginAlarm")
                        || inputStr.contains("reqSyncAlarmFile")){
                    continue;
                }
                if (loopThread == null){
                    loopThread = new LoopAlarmThread(socket);
                    loopThread.start();
                }
            }
        }catch (Exception e){
            logger.error("QueryAlarmThread run error.", e);
        }
    }

    private void batchSendAlarm(DataOutputStream dos, List<AlarmDataVO> alarmDataVOList) {
        alarmDataVOList.forEach(alarmDataVO -> {
            String alarmDataJson = JSON.toJSONString(alarmDataVO);
            try {
                dos.writeShort(startSign);
                dos.writeByte(0);
                dos.writeInt(timeStamp);
                dos.writeShort(alarmDataJson.getBytes("UTF-8").length);
                dos.write(alarmDataJson.getBytes("UTF-8"));
                logger.info("QueryAlarmThread batchSendAlarm alarmDataJson:id:{},origin:{}.",alarmDataVO.getAlarmId(),alarmDataVO.getLocationInfo());
                OperationLog.writeLog("QueryAlarmThread " + alarmDataJson);
            } catch (IOException e) {
                logger.error("batchSendAlarm error.",e);
            }
        });
        logger.info("batchSendAlarm list size:{}.",alarmDataVOList.size());
        AlarmSocketServer.syncSwitch = false;
    }

    private String buildMessage(String msg,DataOutputStream dos) {
        String body = "";
        if( msg.contains("reqLoginAlarm")){
            logger.info("==============msg contains reqLoginAlarm");
            alarmType = 2;
            body = "ackLoginAlarm;result=succ;resDesc=null";
        }else if( msg.contains("reqSyncAlarmMsg")){
            AlarmSocketServer.syncSwitch = true;
            logger.info("==============msg contains reqSyncAlarmMsg");
            String[] msgs = msg.split(";");
            alarmType = 4;
            String alarmSeq = null;
            for (int i = 0; i< msgs.length; i++){
                if (msgs[i].contains("alarmSeq")){
                    alarmSeq = msgs[i].split("=")[1];
                }
            }
            if (alarmSeq == null){
                logger.error("AlarmServerHandler buildMessage error.alramSeq is null");
                body = "ackSyncAlarmMsg;reqId=33;result=fail;resDesc=alarmSeq is null";
            }else{
                body = queryBySeqAndSendAlarmMsg(alarmSeq,dos);
            }

        }else if(msg.contains("reqSyncAlarmFile")){
            logger.info("==============msg contains reqSyncAlarmFile");
            alarmType = 6;
            body = "ackSyncAlarmFile;reqId=33;result=succ;resDesc=null";
            try {
                dos.writeShort(startSign);
                dos.writeByte(alarmType);
                dos.writeInt(timeStamp);
                dos.writeShort(body.getBytes("UTF-8").length);
                dos.write(body.getBytes("UTF-8"));
                OperationLog.writeLog("output msg: " + body);
            } catch (IOException e) {
                logger.error("reqSyncAlarmFile error.",e);
            }
            String fileName = generateAlarmDataService.generateFile();
            alarmType = 7;
            body = "ackSyncAlarmFileResult;reqId=33;result=succ;filename=" + fileName + ";resDesc=null";
        }else if(msg.contains("reqHeartBeat")){
            logger.info("==============msg contains reqHeartBeat");
            alarmType = 9;
            body = "ackHeartBeat;reqId=33";
        }else{
            logger.info("==============msg is {}",msg);
//            sendAlarm(dos);
        }
        return body;
    }

    private String queryBySeqAndSendAlarmMsg(String alarmSeq,DataOutputStream dos) {
        String result = "ackSyncAlarmMsg;reqId=33;result=succ;resDesc=null";
        List<AlarmDataVO> alarmDataVOList = alarmDataService.findByAlarmSeq(Integer.valueOf(alarmSeq));
        if (CollectionUtils.isEmpty(alarmDataVOList)){
            logger.error("AlarmServerHandler buildMessage error.alarmData is null");
            result = "ackSyncAlarmMsg;reqId=33;result=fail;resDesc=alarmData is null";
            return result;
        }
        new Thread(new Runnable(){
            @Override
            public void run() {
                batchSendAlarm(dos,alarmDataVOList);
            }
        }).start();
        return result;
    }


    private void init() {
        try {
            bis = new BufferedInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            logger.error("QueryAlarmThread init error.",e);
        }
    }


}
