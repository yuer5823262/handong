package com.example.dampouring.model.pojo;

public class FaceTempSensor {
    private Integer id;

    private String tempNo;

    private String tempAddr;

    private Integer channelNo;

    private Integer channel;

    private String stakeMarkUp;

    private String stakeMarkDown;

    private String stakeMarkLeft;

    private String stakeMarkRight;

    private Integer sbId;

    private Integer cuId;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTempNo() {
        return tempNo;
    }

    public void setTempNo(String tempNo) {
        this.tempNo = tempNo == null ? null : tempNo.trim();
    }

    public String getTempAddr() {
        return tempAddr;
    }

    public void setTempAddr(String tempAddr) {
        this.tempAddr = tempAddr == null ? null : tempAddr.trim();
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getStakeMarkUp() {
        return stakeMarkUp;
    }

    public void setStakeMarkUp(String stakeMarkUp) {
        this.stakeMarkUp = stakeMarkUp == null ? null : stakeMarkUp.trim();
    }

    public String getStakeMarkDown() {
        return stakeMarkDown;
    }

    public void setStakeMarkDown(String stakeMarkDown) {
        this.stakeMarkDown = stakeMarkDown == null ? null : stakeMarkDown.trim();
    }

    public String getStakeMarkLeft() {
        return stakeMarkLeft;
    }

    public void setStakeMarkLeft(String stakeMarkLeft) {
        this.stakeMarkLeft = stakeMarkLeft == null ? null : stakeMarkLeft.trim();
    }

    public String getStakeMarkRight() {
        return stakeMarkRight;
    }

    public void setStakeMarkRight(String stakeMarkRight) {
        this.stakeMarkRight = stakeMarkRight == null ? null : stakeMarkRight.trim();
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
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
}