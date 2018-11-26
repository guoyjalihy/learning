package com.xiao.socket.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class AlarmData {
    //该条告警ID
    Long id;
    //该条告警唯一标识
    String alarmNo;
    //告警产生时间
    Date createTime;
    //设备类型
    String deviceType = "AAC";
    //设备标识符
    String deviceId;
    //告警清除时间
    LocalDateTime clearTime;
    //清除类型
    String clearType;
    //是否清除
    boolean isClear;
    //定位信息或者故障源
    String alarmOrigin;
    //告警对象
    String alarmObject;
    //网元虚拟化标识 or 网元识别名,如果该网元为虚拟化网元，则该字段取值为1；如果该网元为传统物理网元，则取值为0
    Boolean netVirtualId;
    //告警编号
    String alarmSeq;
    //告警名称
    String alarmName;
    // 告警类型
    String alarmType;
    //告警原始级别
    String alarmLevel;
    //确认时间
    LocalDateTime confirmTime;
    //是否确认
    boolean isConfirm;
    //告警确认用户标识
    String confirmUserId;
    //告警机器IP地址
    String ip;
    //触发值
    Integer value;
    //网元Id
    String netId;
    //清除用户Id;
    String clearUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlarmNo() {
        return alarmNo;
    }

    public void setAlarmNo(String alarmNo) {
        this.alarmNo = alarmNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getClearTime() {
        return clearTime;
    }

    public void setClearTime(LocalDateTime clearTime) {
        this.clearTime = clearTime;
    }

    public String getClearType() {
        return clearType;
    }

    public void setClearType(String clearType) {
        this.clearType = clearType;
    }

    public boolean isClear() {
        return isClear;
    }

    public void setClear(boolean clear) {
        isClear = clear;
    }

    public String getAlarmOrigin() {
        return alarmOrigin;
    }

    public void setAlarmOrigin(String alarmOrigin) {
        this.alarmOrigin = alarmOrigin;
    }

    public String getAlarmObject() {
        return alarmObject;
    }

    public void setAlarmObject(String alarmObject) {
        this.alarmObject = alarmObject;
    }

    public Boolean getNetVirtualId() {
        return netVirtualId;
    }

    public void setNetVirtualId(Boolean netVirtualId) {
        this.netVirtualId = netVirtualId;
    }

    public String getAlarmSeq() {
        return alarmSeq;
    }

    public void setAlarmSeq(String alarmSeq) {
        this.alarmSeq = alarmSeq;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public LocalDateTime getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(LocalDateTime confirmTime) {
        this.confirmTime = confirmTime;
    }

    public boolean isConfirm() {
        return isConfirm;
    }

    public void setConfirm(boolean confirm) {
        isConfirm = confirm;
    }

    public String getConfirmUserId() {
        return confirmUserId;
    }

    public void setConfirmUserId(String confirmUserId) {
        this.confirmUserId = confirmUserId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId;
    }

    public String getClearUserId() {
        return clearUserId;
    }

    public void setClearUserId(String clearUserId) {
        this.clearUserId = clearUserId;
    }

    @Override
    public String toString() {
        return "AlarmData{" +
                "id=" + id +
                ", alarmNo='" + alarmNo + '\'' +
                ", createTime=" + createTime +
                ", deviceType='" + deviceType + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", clearTime=" + clearTime +
                ", clearType='" + clearType + '\'' +
                ", isClear=" + isClear +
                ", alarmOrigin='" + alarmOrigin + '\'' +
                ", alarmObject='" + alarmObject + '\'' +
                ", netVirtualId=" + netVirtualId +
                ", alarmSeq='" + alarmSeq + '\'' +
                ", alarmName='" + alarmName + '\'' +
                ", alarmType='" + alarmType + '\'' +
                ", alarmLevel='" + alarmLevel + '\'' +
                ", confirmTime=" + confirmTime +
                ", isConfirm=" + isConfirm +
                ", confirmUserId='" + confirmUserId + '\'' +
                ", ip='" + ip + '\'' +
                ", value=" + value +
                ", netId='" + netId + '\'' +
                ", clearUserId='" + clearUserId + '\'' +
                '}';
    }
}
