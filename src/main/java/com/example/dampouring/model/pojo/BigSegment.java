package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class BigSegment {

    private Integer bsNo;
    @Excel(name = "标段名称", width = 20)
    private String bsName;
    @Excel(name = "承建单位", width = 20)
    private String contractor;
    @Excel(name = "备注", width = 20)
    private String remark;

    private String createTime;

    private String operator;

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
        this.bsName = bsName == null ? null : bsName.trim();
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor == null ? null : contractor.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}