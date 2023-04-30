package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddBigSegmentReq {
    @NotNull
    @Size(min=1,max = 20,message = "名称长度在1到20位")
    private String bsName;
    @NotNull
    @Size(min=1,max=20)
    private String contractor;

    private String remark;
    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
