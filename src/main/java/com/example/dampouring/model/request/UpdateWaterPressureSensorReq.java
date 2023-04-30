package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;

public class UpdateWaterPressureSensorReq {
    @NotNull
    private Integer id;

    private String enterAddr;

    private Integer enterChannelNo;

    private String exitAddr;

    private Integer exitChannelNo;

    private Integer cuId;

    private Integer sbId;

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

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }
}
