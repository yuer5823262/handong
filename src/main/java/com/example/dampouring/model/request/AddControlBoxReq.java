package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddControlBoxReq {
    @NotNull
    @Size(min=3,max=32)
    private String cbNo;
    @NotNull
    private Integer scsId;

    private String remark;

    public String getCbNo() {
        return cbNo;
    }

    public void setCbNo(String cbNo) {
        this.cbNo = cbNo;
    }

    public Integer getScsId() {
        return scsId;
    }

    public void setScsId(Integer scsId) {
        this.scsId = scsId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
