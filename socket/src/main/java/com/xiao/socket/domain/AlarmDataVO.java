package com.xiao.socket.domain;

import java.util.Date;

/**
 * @description: 告警信息
 * @author: guoyanjun
 * @date: 2018/10/29 19:18
 */
public class AlarmDataVO {
    private Long id;
    private String addInfo;
    private Long alarmId;
    private Long alarmSeq;
    private int alarmStatus;
    private String alarmTitle;
    private String alarmType;
    private String eventTime;
    private String locationInfo;
    private String neName;
    private String neType;
    private String neUID;
    private String objectName;
    private String objectType;
    private String objectUID;
    private int origSeverity;
    private String rNeName;
    private String rNeType;
    private String rNeUID;
    private String specificProblem;
    private String specificProblemID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }
    public String getAddInfo() {
        return addInfo;
    }

    public Long getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Long alarmId) {
        this.alarmId = alarmId;
    }

    public String getrNeName() {
        return rNeName;
    }

    public void setrNeName(String rNeName) {
        this.rNeName = rNeName;
    }

    public String getrNeType() {
        return rNeType;
    }

    public void setrNeType(String rNeType) {
        this.rNeType = rNeType;
    }

    public String getrNeUID() {
        return rNeUID;
    }

    public void setrNeUID(String rNeUID) {
        this.rNeUID = rNeUID;
    }

    public Long getAlarmSeq() {
        return alarmSeq;
    }

    public void setAlarmSeq(Long alarmSeq) {
        this.alarmSeq = alarmSeq;
    }

    public void setAlarmStatus(int alarmStatus) {
        this.alarmStatus = alarmStatus;
    }
    public int getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmTitle(String alarmTitle) {
        this.alarmTitle = alarmTitle;
    }
    public String getAlarmTitle() {
        return alarmTitle;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }
    public String getAlarmType() {
        return alarmType;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public void setLocationInfo(String locationInfo) {
        this.locationInfo = locationInfo;
    }
    public String getLocationInfo() {
        return locationInfo;
    }

    public void setNeName(String neName) {
        this.neName = neName;
    }
    public String getNeName() {
        return neName;
    }

    public void setNeType(String neType) {
        this.neType = neType;
    }
    public String getNeType() {
        return neType;
    }

    public void setNeUID(String neUID) {
        this.neUID = neUID;
    }
    public String getNeUID() {
        return neUID;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
    public String getObjectName() {
        return objectName;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
    public String getObjectType() {
        return objectType;
    }

    public void setObjectUID(String objectUID) {
        this.objectUID = objectUID;
    }
    public String getObjectUID() {
        return objectUID;
    }

    public void setOrigSeverity(int origSeverity) {
        this.origSeverity = origSeverity;
    }
    public int getOrigSeverity() {
        return origSeverity;
    }

    public void setRNeName(String rNeName) {
        this.rNeName = rNeName;
    }
    public String getRNeName() {
        return rNeName;
    }

    public void setRNeType(String rNeType) {
        this.rNeType = rNeType;
    }
    public String getRNeType() {
        return rNeType;
    }

    public void setRNeUID(String rNeUID) {
        this.rNeUID = rNeUID;
    }
    public String getRNeUID() {
        return rNeUID;
    }

    public void setSpecificProblem(String specificProblem) {
        this.specificProblem = specificProblem;
    }
    public String getSpecificProblem() {
        return specificProblem;
    }

    public void setSpecificProblemID(String specificProblemID) {
        this.specificProblemID = specificProblemID;
    }
    public String getSpecificProblemID() {
        return specificProblemID;
    }
}
