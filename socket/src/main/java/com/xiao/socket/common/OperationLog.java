package com.xiao.socket.common;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @description: 记录操作日志
 * @author: guoyanjun
 * @date: 2018/11/22 22:10
 */
public class OperationLog {
    public static String clientIP = "2409:8028:5a01:202b::2000:ca";
    public static String userName = "yiy";
    public static LocalDateTime connectionTime = LocalDateTime.now();
    public static LocalDateTime closeTime = null;
    public static void writeLog(String content){
        StringBuilder all = new StringBuilder();
        all.append(buildHeader());
        all.append(" [content]:");
        all.append(content);
        all.append("\r\n");
        String fileDirectory = "/home/omc/log/";
        String fileName = "alarm.log";
        File file = new File(fileDirectory);
        if (!file.exists()){
            file.mkdirs();
        }
        try {
            Writer writer = new FileWriter(fileDirectory + fileName,true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(all.toString());
            bw.close();
            writer.close();
        } catch (IOException e) {
        }
    }
    public static String buildHeader(){
        StringBuilder result = new StringBuilder();
        result.append(LocalDateTime.now());
        result.append(" ");
        result.append("[clientIP]:");
        result.append(clientIP);
        result.append(" [userName]:");
        result.append(userName);
        result.append(" [connectionTime]:");
        result.append(connectionTime);
        result.append(" [closeTime]:");
        result.append(closeTime);
        return result.toString();
    }

    public static void main(String[] args) {
        OperationLog.writeLog("");
    }
}
