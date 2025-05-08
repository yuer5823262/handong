package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class TempMeasurements {
    private Integer id;
    @Excel(name = "时间",width = 20)
    private String date;
    @Excel(name = "温度（℃）",width = 20)
    private Double temperature;
    private Integer bl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }
}
