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
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @description:
 * @author: guoyanjun
 * @date: 2018/11/17 18:27
 */
public class LoopAlarmThread extends Thread {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private short startSign = (short)0xFFFF;
    private int timeStamp = (int)System.currentTimeMillis()/1000;
    private byte alarmType = 0;
    Socket socket ;
    DataOutputStream dos ;
    BufferedInputStream bis ;
    long max_id = 0;
    @Autowired
    private static AlarmDataService alarmDataService;
    static{
        alarmDataService = SpringUtil.getBean(AlarmDataService.class);
    }

    public LoopAlarmThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        init();
        max_id = alarmDataService.getMaxId();
        logger.info("LoopAlarmThread first connect.max_id:{}",max_id);
        try {
            while (true) {
                Thread.sleep(5000);
                if (AlarmSocketServer.syncSwitch){
                    continue;
                }
                if(alarmDataService.hasNewAlarmData(max_id)){
                    queryByDateAndSendAlarmMsg(max_id,dos);
                }
            }
        }catch (Exception e){
            logger.error("LoopAlarmThread run error.",e);
        }
    }

    private LocalDateTime getCurrentTime(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("getCurrentTime error.",e);
        }
        // 5秒钟之前的时间
        LocalDateTime result = LocalDateTime.now();
        result = result.plusSeconds(-5);
        return result;
    }
    private void queryByDateAndSendAlarmMsg(long id,DataOutputStream dos) {
//        LocalDateTime beginTime = getCurrentTime();
//        List<AlarmDataVO> alarmDataVOList = alarmDataService.findByTimeArea(beginTime);
        List<AlarmDataVO> alarmDataVOList = alarmDataService.findGreaterThanAreaById(id);
        if (CollectionUtils.isEmpty(alarmDataVOList)){
            return;
        }
        batchSendAlarm(dos, alarmDataVOList);
        max_id = alarmDataVOList.get(alarmDataVOList.size()-1).getId();
        logger.info("LoopAlarmThread queryByDateAndSendAlarmMsg max_id:{}",max_id);
    }

    private void batchSendAlarm(DataOutputStream dos, List<AlarmDataVO> alarmDataVOList) {
        alarmDataVOList.forEach(alarmDataVO -> {
            String alarmDataJson = JSON.toJSONString(alarmDataVO);
            try {
                dos.writeShort(startSign);
                dos.writeByte(alarmType);
                dos.writeInt(timeStamp);
                dos.writeShort(alarmDataJson.getBytes().length);
                dos.write(alarmDataJson.getBytes());
                logger.info("LoopAlarmThread batchSendAlarm alarmData-id:{},origin:{}.",alarmDataVO.getAlarmSeq(),alarmDataVO.getLocationInfo());
                OperationLog.writeLog("LoopAlarmThread " + alarmDataJson);
            } catch (IOException e) {
                logger.error("batchSendAlarm error.",e);
            }
        });
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
