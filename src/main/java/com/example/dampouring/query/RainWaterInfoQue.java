package com.example.dampouring.query;

public class RainWaterInfoQue {
    Integer pageNum;
    Integer pageSize;
    String startTime;
    String endTime;
    String type;
    String station;
    Integer valStart;
    Integer valEnd;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Integer getValStart() {
        return valStart;
    }

    public void setValStart(Integer valStart) {
        this.valStart = valStart;
    }

    public Integer getValEnd() {
        return valEnd;
    }

    public void setValEnd(Integer valEnd) {
        this.valEnd = valEnd;
    }
}
