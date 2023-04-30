package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;

public class AddWaterRainStationReq {
    @NotNull
    private String wrsName;
    @NotNull
    private String wrsType;

    private String remark;

    public String getWrsName() {
        return wrsName;
    }

    public void setWrsName(String wrsName) {
        this.wrsName = wrsName;
    }

    public String getWrsType() {
        return wrsType;
    }

    public void setWrsType(String wrsType) {
        this.wrsType = wrsType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
