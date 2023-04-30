package com.example.dampouring.query;

public class PouringTempInfoQue {
    Integer pageNum;
    Integer pageSize;
    Integer smallId;
    String startTime;
    String endTime;
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
