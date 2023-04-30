package com.example.dampouring.model.request;

public class AddInsulationSensorReq {
    private Integer cuId;

    private Integer dsNo;

    private Integer chanelNo;

    private String position;

    private String addr;

    private String tempNo;

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
    }

    public Integer getDsNo() {
        return dsNo;
    }

    public void setDsNo(Integer dsNo) {
        this.dsNo = dsNo;
    }

    public Integer getChanelNo() {
        return chanelNo;
    }

    public void setChanelNo(Integer chanelNo) {
        this.chanelNo = chanelNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTempNo() {
        return tempNo;
    }

    public void setTempNo(String tempNo) {
        this.tempNo = tempNo;
    }
}
