package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class AirTempSensorVO {
    private Integer id;
    @Excel(name = "分控站编号",width=20)
    private String fkzNo;
    @Excel(name = "控制箱编号",width=20)
    private String kzxNo;
    @Excel(name = "地址",width=20)
    private String addr;
    @Excel(name = "控制单元地址",width=20)
    private String cuAddr;
    @Excel(name = "通道号",width=20)
    private Integer channelNo;
    private Integer channel;
    private String createTime;
    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFkzNo() {
        return fkzNo;
    }

    public void setFkzNo(String fkzNo) {
        this.fkzNo = fkzNo;
    }

    public String getKzxNo() {
        return kzxNo;
    }

    public void setKzxNo(String kzxNo) {
        this.kzxNo = kzxNo;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCuAddr() {
        return cuAddr;
    }

    public void setCuAddr(String cuAddr) {
        this.cuAddr = cuAddr;
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
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

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}
