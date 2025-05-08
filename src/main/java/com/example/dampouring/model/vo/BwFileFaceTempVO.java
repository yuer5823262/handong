package com.example.dampouring.model.vo;

public class BwFileFaceTempVO {
    Integer dsNo;
    Integer sbId;
    String time;
    Double avgTemp;


    public Integer getDsNo() {
        return dsNo;
    }

    public void setDsNo(Integer dsNo) {
        this.dsNo = dsNo;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(Double avgTemp) {
        this.avgTemp = avgTemp;
    }
}
