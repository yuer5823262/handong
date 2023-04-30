package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class WaterPressureSensorVO {
    private Integer id;
    @Excel(name = "仓号",width = 20)
    private String smallNo;
    @Excel(name = "测控地址",width = 20)
    private String cuAddr;
    @Excel(name = "进口地址",width = 20)
    private String enterAddr;
    @Excel(name = "进口通道号",width = 20)
    private Integer enterChannelNo;
    @Excel(name = "出口地址",width = 20)
    private String exitAddr;
    @Excel(name = "出口通道号",width = 20)
    private Integer exitChannelNo;

    private String createTime;

    private String operator;

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

    public String getCuAddr() {
        return cuAddr;
    }

    public void setCuAddr(String cuAddr) {
        this.cuAddr = cuAddr;
    }

    public String getEnterAddr() {
        return enterAddr;
    }

    public void setEnterAddr(String enterAddr) {
        this.enterAddr = enterAddr;
    }

    public Integer getEnterChannelNo() {
        return enterChannelNo;
    }

    public void setEnterChannelNo(Integer enterChannelNo) {
        this.enterChannelNo = enterChannelNo;
    }

    public String getExitAddr() {
        return exitAddr;
    }

    public void setExitAddr(String exitAddr) {
        this.exitAddr = exitAddr;
    }

    public Integer getExitChannelNo() {
        return exitChannelNo;
    }

    public void setExitChannelNo(Integer exitChannelNo) {
        this.exitChannelNo = exitChannelNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
