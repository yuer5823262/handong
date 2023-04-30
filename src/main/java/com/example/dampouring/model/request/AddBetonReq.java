package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;

public class AddBetonReq {
    @NotNull
    private String markNumber;

    private String type;

    private Integer materialNo;

    public String getMarkNumber() {
        return markNumber;
    }

    public void setMarkNumber(String markNumber) {
        this.markNumber = markNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(Integer materialNo) {
        this.materialNo = materialNo;
    }

}
