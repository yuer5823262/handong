package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class InnerTempSensorVO {
    private Integer id;
    @Excel(name="仓号",width = 20)
    private String smallNo;
    @Excel(name="分控站编号",width = 20)
    private String fkzNo;
    @Excel(name="控制箱编号",width = 20)
    private String kzxNo;
    @Excel(name="测控地址",width = 20)
    private String cuAddr;
    @Excel(name="温度计编号",width = 20)
    private String tempNo;
    @Excel(name="温度计地址",width = 20)
    private String tempAddr;
    @Excel(name="通道号",width = 20)
    private Integer channelNo;
    private Integer channel;
    @Excel(name="桩号-上",width = 20)
    private String stakeMarkUp;
    @Excel(name="桩号-下",width = 20)
    private String stakeMarkDown;
    @Excel(name="桩号-左",width = 20)
    private String stakeMarkLeft;
    @Excel(name="桩号-右",width = 20)
    private String stakeMarkRight;
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

    public String getCuAddr() {
        return cuAddr;
    }

    public void setCuAddr(String cuAddr) {
        this.cuAddr = cuAddr;
    }

    public String getTempNo() {
        return tempNo;
    }

    public void setTempNo(String tempNo) {
        this.tempNo = tempNo;
    }

    public String getTempAddr() {
        return tempAddr;
    }

    public void setTempAddr(String tempAddr) {
        this.tempAddr = tempAddr;
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public String getStakeMarkUp() {
        return stakeMarkUp;
    }

    public void setStakeMarkUp(String stakeMarkUp) {
        this.stakeMarkUp = stakeMarkUp;
    }

    public String getStakeMarkDown() {
        return stakeMarkDown;
    }

    public void setStakeMarkDown(String stakeMarkDown) {
        this.stakeMarkDown = stakeMarkDown;
    }

    public String getStakeMarkLeft() {
        return stakeMarkLeft;
    }

    public void setStakeMarkLeft(String stakeMarkLeft) {
        this.stakeMarkLeft = stakeMarkLeft;
    }

    public String getStakeMarkRight() {
        return stakeMarkRight;
    }

    public void setStakeMarkRight(String stakeMarkRight) {
        this.stakeMarkRight = stakeMarkRight;
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
