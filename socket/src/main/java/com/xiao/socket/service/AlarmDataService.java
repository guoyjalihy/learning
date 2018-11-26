package com.xiao.socket.service;


import com.xiao.socket.domain.AlarmDataVO;

import java.time.LocalDateTime;
import java.util.List;

public interface AlarmDataService {
    List<AlarmDataVO> findByTimeArea(LocalDateTime beginTime);

    List<AlarmDataVO> findByAlarmSeq(int alarmSeq);

    List<AlarmDataVO> findAll();

    List<AlarmDataVO> findGreaterThanAreaById(long id);

    boolean hasNewAlarmData(long max_id);

    Long getMaxId();

}
