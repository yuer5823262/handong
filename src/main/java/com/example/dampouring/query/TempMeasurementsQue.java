package com.example.dampouring.query;

public class TempMeasurementsQue {
    Integer pageNum;
    Integer pageSize;
    String startTime;
    String endTime;
    Double startTemp;
    Double endTemp;

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

    public Double getStartTemp() {
        return startTemp;
    }

    public void setStartTemp(Double startTemp) {
        this.startTemp = startTemp;
    }

    public Double getEndTemp() {
        return endTemp;
    }

    public void setEndTemp(Double endTemp) {
        this.endTemp = endTemp;
    }
}
