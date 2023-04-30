package com.example.dampouring.model.pojo;

public class TempGradometer {
    private Integer id;

    private String tgmName;

    private Integer channelNo;
    private String channel;
    private Integer cuId;
    private Integer sbId;
    private String addr1;

    private String addr2;

    private String addr3;

    private String addr4;

    private String addr5;

    private String addr6;
    private Double length;
    private String position;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTgmName() {
        return tgmName;
    }

    public void setTgmName(String tgmName) {
        this.tgmName = tgmName == null ? null : tgmName.trim();
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1 == null ? null : addr1.trim();
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2 == null ? null : addr2.trim();
    }

    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3 == null ? null : addr3.trim();
    }

    public String getAddr4() {
        return addr4;
    }

    public void setAddr4(String addr4) {
        this.addr4 = addr4 == null ? null : addr4.trim();
    }

    public String getAddr5() {
        return addr5;
    }

    public void setAddr5(String addr5) {
        this.addr5 = addr5 == null ? null : addr5.trim();
    }

    public String getAddr6() {
        return addr6;
    }

    public void setAddr6(String addr6) {
        this.addr6 = addr6 == null ? null : addr6.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
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

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }
}