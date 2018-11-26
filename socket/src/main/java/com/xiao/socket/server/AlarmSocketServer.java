package com.xiao.socket.server;

import com.alibaba.fastjson.JSON;
import com.xiao.socket.common.OperationLog;
import com.xiao.socket.domain.AlarmDataVO;
import com.xiao.socket.service.AlarmDataService;
import com.xiao.socket.service.GenerateAlarmDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 告警服务端
 * @author: guoyanjun
 * @date: 2018/11/16 10:20
 */
@Component
public class AlarmSocketServer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static boolean syncSwitch = false;

    public void startServer(int[] portArr){
        /**
         * 基于TCP协议的Socket通信，实现用户登录，服务端
         */
        //1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        ServerSocket serverSocket = null;//1024-65535的某个端口
        DataOutputStream dos = null;
        Socket socket = null;
        try {
            for (int i=0; i<portArr.length; i++){
                serverSocket = new ServerSocket(portArr[i]);
                logger.info("socket start listen.port:{}" , portArr[i]);
            }

            //2、调用accept()方法开始监听，等待客户端的连接
            while(true){
                socket = serverSocket.accept();
                logger.info("socket client:{}" , socket.getRemoteSocketAddress());
                OperationLog.connectionTime = LocalDateTime.now();
                OperationLog.writeLog("client connect.");
                new QueryAlarmThread(socket).start();
//                new LoopAlarmThread(socket).start();
            }
        } catch (IOException e) {
            logger.error("startServer error.",e);
        }finally {
            try {
                socket.close();
                serverSocket.close();
                dos.close();
            } catch (IOException e) {
                logger.error("startServer error.",e);
            }
        }
    }
}
