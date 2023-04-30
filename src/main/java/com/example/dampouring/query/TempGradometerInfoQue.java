package com.example.dampouring.query;

public class TempGradometerInfoQue {
    Integer pageNum;
    Integer pageSize;
    Integer smallId;
    String startTime;
    String endTime;
    Integer tempGradometerId;

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

    public Integer getSmallId() {
        return smallId;
    }

    public void setSmallId(Integer smallId) {
        this.smallId = smallId;
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

    public Integer getTempGradometerId() {
        return tempGradometerId;
    }

    public void setTempGradometerId(Integer tempGradometerId) {
        this.tempGradometerId = tempGradometerId;
    }
}
