package com.example.dampouring.query;

public class StorageBinQue {
    Integer pageNum;
    Integer pageSize;
    Integer sbId;
    String dsNo;
    String que;
    Double startElevation;
    Double endElevation;

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

    public String getDsNo() {
        return dsNo;
    }

    public void setDsNo(String dsNo) {
        this.dsNo = dsNo;
    }

    public Double getStartElevation() {
        return startElevation;
    }

    public void setStartElevation(Double startElevation) {
        this.startElevation = startElevation;
    }

    public Double getEndElevation() {
        return endElevation;
    }

    public void setEndElevation(Double endElevation) {
        this.endElevation = endElevation;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }
}
