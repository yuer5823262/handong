package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateControlBoxReq {
    @NotNull
    private Integer id;
    @Size(min = 3,max = 32)
    private String cbNo;

    private Integer scsId;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
