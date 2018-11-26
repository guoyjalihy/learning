package com.xiao.socket.service.impl;

import com.xiao.socket.dao.AlarmDataDao;
import com.xiao.socket.domain.AlarmData;
import com.xiao.socket.domain.AlarmDataVO;
import com.xiao.socket.service.AlarmDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 告警
 * @author: guoyanjun
 * @date: 2018/10/29 19:22
 */
@Service
public class AlarmDataServiceImpl implements AlarmDataService {
    @Autowired
    private AlarmDataDao alarmDataDao;

    @Override
    public List<AlarmDataVO> findByTimeArea(LocalDateTime beginTime) {
        List<AlarmData> list = alarmDataDao.findByTimeArea(beginTime);
        List<AlarmDataVO> result = new ArrayList<>();
        list.forEach(alarmData -> {
//            System.out.println(alarmData.toString());
            AlarmDataVO alarmDataVO = convertToVO(alarmData);
            result.add(alarmDataVO);
        });
        return result;
    }

    private AlarmDataVO convertToVO(AlarmData alarmData) {
        AlarmDataVO alarmDataVO = new AlarmDataVO();
        alarmDataVO.setId(alarmData.getId());
        alarmDataVO.setAddInfo("NoResult!");
        alarmDataVO.setAlarmId(alarmData.getId());
        alarmDataVO.setAlarmSeq(alarmData.getId());
//        alarmDataVO.setAlarmSeq(Integer.valueOf(alarmData.getAlarmSeq()));
        alarmDataVO.setAlarmStatus(1);
        if (alarmData.isClear()){
            alarmDataVO.setAlarmStatus(0);
        }
        alarmDataVO.setAlarmTitle(alarmData.getAlarmName());
        alarmDataVO.setAlarmType(alarmData.getAlarmType());
        String eventTime = alarmData.getCreateTime().toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime().toString();
        alarmDataVO.setEventTime(eventTime);
        alarmDataVO.setLocationInfo(alarmData.getAlarmOrigin());
        alarmDataVO.setNeName(alarmData.getDeviceType());
        alarmDataVO.setNeType(alarmData.getDeviceType());
        alarmDataVO.setNeUID(alarmData.getNetId());
        alarmDataVO.setObjectName(alarmData.getAlarmObject());
        alarmDataVO.setObjectType(alarmData.getAlarmObject());
        alarmDataVO.setObjectUID(alarmData.getAlarmObject());
        alarmDataVO.setOrigSeverity(getAlarmLevelByName(alarmData.getAlarmLevel()));
        alarmDataVO.setRNeName(alarmData.getDeviceType());
        alarmDataVO.setRNeType(alarmData.getDeviceType());
        alarmDataVO.setRNeUID(alarmData.getNetId());
        alarmDataVO.setSpecificProblem("CPU ALARM");
        alarmDataVO.setSpecificProblemID("10001");
        return alarmDataVO;
    }

    @Override
    public List<AlarmDataVO> findByAlarmSeq(int alarmSeq) {
        List<AlarmData> list = alarmDataDao.findByAlarmSeq(alarmSeq);
        List<AlarmDataVO> result = new ArrayList<>();
        list.forEach(alarmData -> {
            AlarmDataVO alarmDataVO = convertToVO(alarmData);
            result.add(alarmDataVO);
        });
        return result;
    }

    @Override
    public List<AlarmDataVO> findAll() {
        List<AlarmData> list = alarmDataDao.findAll();
        List<AlarmDataVO> result = new ArrayList<>();
        list.forEach(alarmData -> {
//            System.out.println(alarmData.toString());
            AlarmDataVO alarmDataVO = convertToVO(alarmData);
            result.add(alarmDataVO);
        });
        return result;
    }

    @Override
    public List<AlarmDataVO> findGreaterThanAreaById(long id) {
        List<AlarmData> list = alarmDataDao.findGreaterThanAreaById(id);
        List<AlarmDataVO> result = new ArrayList<>();
        list.forEach(alarmData -> {
            AlarmDataVO alarmDataVO = convertToVO(alarmData);
            result.add(alarmDataVO);
        });
        return result;
    }

    @Override
    public boolean hasNewAlarmData(long id) {
        Long maxId = alarmDataDao.getMaxId();
        if (maxId == null){
            return false;
        }
        if (maxId <= id){
            return false;
        }
        return true;
    }

    @Override
    public Long getMaxId() {
        Long maxId = alarmDataDao.getMaxId();
        if (maxId == null){
            maxId = 0L;
        }
        return maxId;
    }

    private int getAlarmLevelByName(String name){
        int result = 0;
        if ("Critical".equals(name)){
            result = 1;
        }else if("Major".equals(name)){
            result = 2;
        }else if("Minor".equals(name)){
            result = 3;
        }else if("Warning".equals(name)){
            result = 4;
        }
        return result;
    }


    public static void main(String[] args) {
        short startSign = (short)0xFFFF;
        byte  msgType = 1;
        int timeStamp = Integer.valueOf(System.currentTimeMillis()/1000+"");;
        short lenOfBody = 300;
        String result = startSign + msgType + timeStamp + lenOfBody + "";
        byte[]  buff = result.getBytes();
        int i = buff.length;
        System.out.println((startSign+"").length());
        System.out.println((msgType+"").length());
        System.out.println(timeStamp + "length" + (timeStamp+"").length());
        System.out.println((lenOfBody+"").length());
        System.out.println(i + "=" + result.length());
        System.out.println(buff.length+"Byte="+buff.length/1024+"KB" );
    }
}
