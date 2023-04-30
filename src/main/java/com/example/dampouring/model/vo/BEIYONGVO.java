package com.example.dampouring.model.vo;

public class BEIYONGVO {
    String dsName;
    Double maxTemp;
    String maxTime;
    Double innerTemp;
    String interTime;
    Double avgWaterTemp;
    Double waterTemp;

    public String getDsNo() {
        return dsName;
    }

    public void setDsNo(String dsNo) {
        this.dsName = dsNo;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(String maxTime) {
        this.maxTime = maxTime;
    }

    public Double getInnerTemp() {
        return innerTemp;
    }

    public void setInnerTemp(Double innerTemp) {
        this.innerTemp = innerTemp;
    }

    public String getInterTime() {
        return interTime;
    }

    public void setInterTime(String interTime) {
        this.interTime = interTime;
    }

    public Double getAvgWaterTemp() {
        return avgWaterTemp;
    }

    public void setAvgWaterTemp(Double avgWaterTemp) {
        this.avgWaterTemp = avgWaterTemp;
    }

    public Double getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(Double waterTemp) {
        this.waterTemp = waterTemp;
    }

    public String toStr() {
        return maxTime+" "+maxTemp+" "+innerTemp+" "+interTime+" "+avgWaterTemp+" "+waterTemp;
    }
}
