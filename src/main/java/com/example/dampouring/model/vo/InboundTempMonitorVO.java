package com.example.dampouring.model.vo;

public class InboundTempMonitorVO {
    String sbNo;
    Double temp;
    Double norm;
    String time;
    String isCb;
    public void setIsCbByNorm()
    {
        if(temp>norm) this.isCb = "是";
        else this.isCb = "否";
    }
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

    public String getIsCb() {
        return isCb;
    }

    public void setIsCb(String isCb) {
        this.isCb = isCb;
    }
}
