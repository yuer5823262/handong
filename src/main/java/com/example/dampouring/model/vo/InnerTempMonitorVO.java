package com.example.dampouring.model.vo;

import com.example.dampouring.util.TimeUtils;

public class InnerTempMonitorVO {
    String sbNo;
    Double temp;
    Double norm;
    Integer age;
    String time;
    String isCb;
    Double tempDiff;
    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getIsCb() {
        return isCb;
    }

    public void setIsCb(String isCb) {
        this.isCb = isCb;
    }

    public Double getNorm() {
        return norm;
    }

    public void setNorm(Double norm) {
        this.norm = norm;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getTempDiff() {
        return tempDiff;
    }

    public void setTempDiff(Double tempDiff) {
        this.tempDiff = tempDiff;
    }
}
