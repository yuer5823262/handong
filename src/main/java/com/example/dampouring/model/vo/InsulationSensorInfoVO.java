package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class InsulationSensorInfoVO {
    private Integer id;
    @Excel(name = "坝段",width = 20)
    private Integer dsNo;
    @Excel(name = "温度计编号",width = 20)
    private String tempNo;
    @Excel(name = "埋设位置",width = 20)
    private String position;
    @Excel(name = "温度",width = 20)
    private Double temp;
    @Excel(name = "时间",width = 20)
    private String time;
    private Byte bl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDsNo() {
        return dsNo;
    }

    public void setDsNo(Integer dsNo) {
        this.dsNo = dsNo;
    }

    public String getTempNo() {
        return tempNo;
    }

    public void setTempNo(String tempNo) {
        this.tempNo = tempNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Byte getBl() {
        return bl;
    }

    public void setBl(Byte bl) {
        this.bl = bl;
    }
}
