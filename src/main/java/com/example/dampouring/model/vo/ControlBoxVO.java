package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ControlBoxVO {
    private Integer id;
    @Excel(name="控制箱编号",width = 20)
    private String cbNo;
    @Excel(name="分控站编号",width = 20)
    private String  scsNo;
    @Excel(name="备注",width = 20)
    private String remark;

    private String createTime;

    private String operator;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
