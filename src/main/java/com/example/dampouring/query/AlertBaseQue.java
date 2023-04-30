package com.example.dampouring.query;

import java.util.List;

public class AlertBaseQue {
    Integer pageSize;
    Integer pageNum;
    String que;
    Integer typeNo;
    Integer state;
    String startTime;
    String endTime;
    List<Integer> alertTypeList;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public Integer getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(Integer typeNo) {
        this.typeNo = typeNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public List<Integer> getAlertTypeList() {
        return alertTypeList;
    }

    public void setAlertTypeList(List<Integer> alertTypeList) {
        this.alertTypeList = alertTypeList;
    }
}
