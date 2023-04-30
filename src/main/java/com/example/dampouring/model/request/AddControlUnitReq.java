package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;

public class AddControlUnitReq {
    private String cuAddr;
    @NotNull
    private String name;
    @NotNull
    private String cuType;
    @NotNull
    private Integer cbNo;

    private String remark;

    public String getCuAddr() {
        return cuAddr;
    }

    public void setCuAddr(String cuAddr) {
        this.cuAddr = cuAddr;
    }

    public String getCuType() {
        return cuType;
    }

    public void setCuType(String cuType) {
        this.cuType = cuType;
    }

    public Integer getCbNo() {
        return cbNo;
    }

    public void setCbNo(Integer cbNo) {
        this.cbNo = cbNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
