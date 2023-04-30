package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class SolarRadioMeter {
    private Integer id;
    @Excel(name = "编号",width = 20)
    private String no;
    @Excel(name = "串口号",width = 20)
    private Integer serialNo;
    @Excel(name = "设备号",width = 20)
    private Integer equipmentNo;
    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(Integer equipmentNo) {
        this.equipmentNo = equipmentNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}