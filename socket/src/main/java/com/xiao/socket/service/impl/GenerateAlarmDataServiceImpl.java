package com.xiao.socket.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiao.socket.domain.AlarmDataVO;
import com.xiao.socket.service.AlarmDataService;
import com.xiao.socket.service.GenerateAlarmDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/**
 * @description: 生成告警文件的实现类
 * @author: guoyanjun
 * @date: 2018/7/9 16:17
 */
@Service
public class GenerateAlarmDataServiceImpl implements GenerateAlarmDataService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String FILE_ROOT_PATH = "/omc";

    @Autowired
    private AlarmDataService alarmDataService;

    public String writeTxtToDisk(String content) {
        String fileDirectory = "/ZJ/HZ/HX/HY/HY_OMC/FM/" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "/";
        String fileName = "FM-AAC-A1-V1.0.0-"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".txt";
        File file = new File(FILE_ROOT_PATH + fileDirectory);
        if (!file.exists()){
            file.mkdirs();
        }
        String fullPath = FILE_ROOT_PATH + fileDirectory + fileName;
        try {
            Writer writer = new FileWriter(fullPath);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(content);
            bw.close();
            writer.close();
            logger.info("GenerateAlarmDataServiceImpl writeTxtToDisk success.");
            return compressFile( fileDirectory + fileName);
        } catch (IOException e) {
            logger.error("GeneratePerformanceDataServiceImpl writeCSVToDisk error.",e);
        }
        return fileDirectory+fileName;
    }

    public String compressFile(String inFileName) {
        String outFileName = inFileName + ".gz";
        FileInputStream in = null;
        File inFile = new File(FILE_ROOT_PATH + inFileName);
        try {
            in = new FileInputStream(inFile);
        }catch (FileNotFoundException e) {
            System.out.println("Could not find the inFile..." + inFileName);
        }

        GZIPOutputStream out = null;
        try {
            out = new GZIPOutputStream(new FileOutputStream(FILE_ROOT_PATH + outFileName));
        }catch (IOException e) {
            System.out.println("Could not find the outFile..."+outFileName);

        }
        byte[] buf = new byte[10240];
        int len = 0;
        try {
            while (((in.available()>10240)&& (in.read(buf)) > 0)) {
                out.write(buf);
            }
            len = in.available();
            in.read(buf, 0, len);
            out.write(buf, 0, len);
            in.close();
            out.flush();
            out.close();
            if(inFile.exists()&&inFile.isFile()){
                inFile.delete();
            }
        }catch (IOException e) {

        }
        return outFileName;
    }

    @Override
    public String generateFile() {
        List<AlarmDataVO> all =  alarmDataService.findAll();
        StringBuffer content = new StringBuffer();
        all.forEach(alarmDataVO -> {
            String alarmDataJson = JSON.toJSONString(alarmDataVO);
            content.append(alarmDataJson);
            content.append("\r\n");
        });
        return writeTxtToDisk(content.toString());
    }
}
