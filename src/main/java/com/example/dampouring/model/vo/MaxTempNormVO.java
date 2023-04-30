package com.example.dampouring.model.vo;

public class MaxTempNormVO {
    Integer itsId;
    String ds;
    Integer sbId;
    Double maxTemp;
    Double minTemp;
    String sbNo;
    public Integer getItsId() {
        return itsId;
    }

    public void setItsId(Integer itsId) {
        this.itsId = itsId;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }
}
