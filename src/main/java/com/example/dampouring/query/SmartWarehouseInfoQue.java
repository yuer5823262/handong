package com.example.dampouring.query;

public class SmartWarehouseInfoQue {
    Integer pageNum;
    Integer pageSize;
    Double startTemp;
    Double endTemp;
    Double startHumidity;
    Double endHumidity;
    Double startWindSpeed;
    Double endWindSpeed;

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

    public Double getStartHumidity() {
        return startHumidity;
    }

    public void setStartHumidity(Double startHumidity) {
        this.startHumidity = startHumidity;
    }

    public Double getEndHumidity() {
        return endHumidity;
    }

    public void setEndHumidity(Double endHumidity) {
        this.endHumidity = endHumidity;
    }

    public Double getStartWindSpeed() {
        return startWindSpeed;
    }

    public void setStartWindSpeed(Double startWindSpeed) {
        this.startWindSpeed = startWindSpeed;
    }

    public Double getEndWindSpeed() {
        return endWindSpeed;
    }

    public void setEndWindSpeed(Double endWindSpeed) {
        this.endWindSpeed = endWindSpeed;
    }
}
