package com.example.dampouring.model.request;

public class UpdateSubControlStationReq {
    private Integer id;

    private String scsNo;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
