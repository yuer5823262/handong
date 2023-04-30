package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddSubControlStationReq {
    @NotNull
    @Size(min = 3,max=32)
    private String scsNo;

    private String remark;

    public String getScsNo() {
        return scsNo;
    }

    public void setScsNo(String scsNo) {
        this.scsNo = scsNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
