package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;

public class UpdateWaterRainStationReq {
    @NotNull
    private Integer id;

    private String wrsName;

    private String wrsType;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
