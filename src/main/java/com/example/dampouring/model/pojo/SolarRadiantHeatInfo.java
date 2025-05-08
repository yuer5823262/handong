package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class SolarRadiantHeatInfo {
    private Integer id;
    @Excel(name = "瞬时值",width = 20)
    private Double momentVal;
    @Excel(name = "累计值",width = 20)
    private Double aggregateVal;
    @Excel(name = "时间",width = 20)
    private String date;
    @Excel(name = "湿度",width = 20)
    private Double humidity;
    @Excel(name = "风速",width = 20)
    private Double wind;
    @Excel(name = "2分钟风速",width = 20)
    private Double wind2;
    @Excel(name = "10分钟风速",width = 20)
    private Double wind10;
    @Excel(name = "风向",width = 20)
    private Double direction;
    @Excel(name = "气温",width = 20)
    private Double temp;
    private Integer bl;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMomentVal() {
        return momentVal;
    }

    public void setMomentVal(Double momentVal) {
        this.momentVal = momentVal;
    }

    public Double getAggregateVal() {
        return aggregateVal;
    }

    public void setAggregateVal(Double aggregateVal) {
        this.aggregateVal = aggregateVal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getWind() {
        return wind;
    }

    public void setWind(Double wind) {
        this.wind = wind;
    }

    public Double getWind2() {
        return wind2;
    }

    public void setWind2(Double wind2) {
        this.wind2 = wind2;
    }

    public Double getWind10() {
        return wind10;
    }

    public void setWind10(Double wind10) {
        this.wind10 = wind10;
    }

    public Double getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = (double) direction;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
