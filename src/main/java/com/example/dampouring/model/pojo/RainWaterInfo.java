package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class RainWaterInfo {
    private Integer id;
    @Excel(name = "测站名称",width = 20)
    private String station;
    @Excel(name = "类型",width = 20)
    private String type;
    @Excel(name = "时间",width = 20)
    private String time;
    @Excel(name = "值",width = 20)
    private Integer value;
    @Excel(name = "备注",width = 20)
    private String remark;
    @Excel(name = "备用字段",width = 20)
    private String alternateField;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAlternateField() {
        return alternateField;
    }

    public void setAlternateField(String alternateField) {
        this.alternateField = alternateField == null ? null : alternateField.trim();
    }
}