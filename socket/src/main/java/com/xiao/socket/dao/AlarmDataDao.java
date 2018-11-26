package com.xiao.socket.dao;

import com.xiao.socket.domain.AlarmData;
import com.xiao.socket.domain.AlarmDataVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface AlarmDataDao {
    List<AlarmData> findByTimeArea(@Param("createTime") LocalDateTime createTime);

    List<AlarmData> findAll();

    List<AlarmData> findByAlarmSeq(@Param("alarmSeq") int alarmSeq);

    List<AlarmData> findGreaterThanAreaById(long id);

    Long getMaxId();

}
