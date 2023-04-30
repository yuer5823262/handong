package com.example.dampouring.model.pojo;

public class WaterTempSensor {
    private Integer id;

    private String enterAddr;

    private Integer enterChannelNo;
    private Integer enterChannel;
    private String exitAddr;

    private Integer exitChannelNo;
    private Integer exitChannel;
    private Integer cuId;
    private Integer sbId;
    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterAddr() {
        return enterAddr;
    }

    public void setEnterAddr(String enterAddr) {
        this.enterAddr = enterAddr == null ? null : enterAddr.trim();
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
        this.exitAddr = exitAddr == null ? null : exitAddr.trim();
    }

    public Integer getExitChannelNo() {
        return exitChannelNo;
    }

    public void setExitChannelNo(Integer exitChannelNo) {
        this.exitChannelNo = exitChannelNo;
    }

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
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

    public Integer getEnterChannel() {
        return enterChannel;
    }

    public void setEnterChannel(Integer enterChannel) {
        this.enterChannel = enterChannel;
    }

    public Integer getExitChannel() {
        return exitChannel;
    }

    public void setExitChannel(Integer exitChannel) {
        this.exitChannel = exitChannel;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }
}