package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class TempMeasurementsAssess {
    private Integer id;
    @Excel(name = "时间",width = 20)
    private String time;
    @Excel(name = "最高温度",width = 20)
    private Double topTemp;
    @Excel(name = "最低温度",width = 20)
    private Double bottomTemp;
    @Excel(name = "平均温度",width = 20)
    private Double avgTemp;
    @Excel(name = "日温差",width = 20)
    private Double differenceTemp;
    @Excel(name = "温度骤降",width = 20)
    private Double lessTemp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Double getTopTemp() {
        return topTemp;
    }

    public void setTopTemp(Double topTemp) {
        this.topTemp = topTemp;
    }

    public Double getBottomTemp() {
        return bottomTemp;
    }

    public void setBottomTemp(Double bottomTemp) {
        this.bottomTemp = bottomTemp;
    }

    public Double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(Double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public Double getDifferenceTemp() {
        return differenceTemp;
    }

    public void setDifferenceTemp(Double differenceTemp) {
        this.differenceTemp = differenceTemp;
    }

    public Double getLessTemp() {
        return lessTemp;
    }

    public void setLessTemp(Double lessTemp) {
        this.lessTemp = lessTemp;
    }
}