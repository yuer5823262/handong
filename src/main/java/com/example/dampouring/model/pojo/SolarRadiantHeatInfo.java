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
}