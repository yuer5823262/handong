package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class WaterRainStation {
    private Integer id;
    @Excel(name = "名称",width = 20)
    private String wrsName;
    @Excel(name = "类型",width = 20)
    private String wrsType;
    @Excel(name = "备注",width = 20)
    private String remark;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWrsName() {
        return wrsName;
    }

    public void setWrsName(String wrsName) {
        this.wrsName = wrsName == null ? null : wrsName.trim();
    }

    public String getWrsType() {
        return wrsType;
    }

    public void setWrsType(String wrsType) {
        this.wrsType = wrsType == null ? null : wrsType.trim();
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