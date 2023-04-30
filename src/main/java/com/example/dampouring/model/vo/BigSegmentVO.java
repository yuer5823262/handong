package com.example.dampouring.model.vo;

import com.example.dampouring.model.pojo.BigSegment;

import java.util.ArrayList;
import java.util.List;

public class BigSegmentVO {
    private Integer bsNo;

    private String bsName;

    private String contractor;

    private String remark;

    public Integer getBsNo() {
        return bsNo;
    }

    public void setBsNo(Integer bsNo) {
        this.bsNo = bsNo;
    }

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
