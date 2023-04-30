package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class PouringTempInfoVO {
    private Integer id;
    @Excel(name = "仓号", width = 20)
    private String smallNo;
    @Excel(name = "时间", width = 20)
    private String time;
    @Excel(name = "温度", width = 20)
    private Double temperature;
    @Excel(name = "温度标准", width = 20)
    private Double norm;
    @Excel(name = "混凝土标号", width = 20)
    private String betonNo;
    @Excel(name = "操作人", width = 20)
    private String operator;
    private Integer bl;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(String smallNo) {
        this.smallNo = smallNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getNorm() {
        return norm;
    }

    public void setNorm(Double norm) {
        this.norm = norm;
    }

    public String getBetonNo() {
        return betonNo;
    }

    public void setBetonNo(String betonNo) {
        this.betonNo = betonNo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }
}
