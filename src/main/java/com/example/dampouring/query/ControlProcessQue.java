package com.example.dampouring.query;

public class ControlProcessQue {
    Integer pageNum;
    Integer pageSize;
    String sbNo;
    String startTime;
    String endTime;
    String isMeet;

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

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
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

    public String getIsMeet() {
        return isMeet;
    }

    public void setIsMeet(String isMeet) {
        this.isMeet = isMeet;
    }
}
