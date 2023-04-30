package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;

public class AddFaceMicroClimateReq {
    @NotNull
    private String deviceNo;
    @NotNull
    private String deviceAddr;
    @NotNull
    private String deviceIp;

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDeviceAddr() {
        return deviceAddr;
    }

    public void setDeviceAddr(String deviceAddr) {
        this.deviceAddr = deviceAddr;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }
}
