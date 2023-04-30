package com.example.dampouring.model.request;

public class AddStorageBinExcludeReq {

    private Integer smallSbId;

    private String remark;

    private String type;

    public Integer getSmallSbId() {
        return smallSbId;
    }

    public void setSmallSbId(Integer smallSbId) {
        this.smallSbId = smallSbId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
