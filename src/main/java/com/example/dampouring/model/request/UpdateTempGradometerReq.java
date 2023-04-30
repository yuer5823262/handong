package com.example.dampouring.model.request;

public class UpdateTempGradometerReq {
    private Integer id;

    private String tgmName;

    private Integer channelNo;

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
        this.tgmName = tgmName;
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
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3;
    }

    public String getAddr4() {
        return addr4;
    }

    public void setAddr4(String addr4) {
        this.addr4 = addr4;
    }

    public String getAddr5() {
        return addr5;
    }

    public void setAddr5(String addr5) {
        this.addr5 = addr5;
    }

    public String getAddr6() {
        return addr6;
    }

    public void setAddr6(String addr6) {
        this.addr6 = addr6;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }
}
