package com.example.dampouring.model.vo;

public class SwZyDataVO {
    String sbNo;
    String time;
    Double temp;
    Double innerTemp;
    Double waterTemp;
    Double flow;

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getInnerTemp() {
        return innerTemp;
    }

    public void setInnerTemp(Double innerTemp) {
        this.innerTemp = innerTemp;
    }

    public Double getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(Double waterTemp) {
        this.waterTemp = waterTemp;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }
}
