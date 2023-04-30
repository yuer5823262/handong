package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ControlUnitVO {
    private Integer id;
    @Excel(name="名称",width = 20)
    private String name;
    @Excel(name="分控站编号",width = 20)
    private String fkzNo;
    @Excel(name="控制箱编号",width = 20)
    private String kzxNo;
    @Excel(name="地址",width = 20)
    private String cuAddr;
    @Excel(name="类型",width = 20)
    private String cuType;
    @Excel(name="备注",width = 20)
    private String remark;
    private String createTime;
    private String operator;
    private  Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFkzNo() {
        return fkzNo;
    }

    public void setFkzNo(String fkzNo) {
        this.fkzNo = fkzNo;
    }

    public String getKzxNo() {
        return kzxNo;
    }

    public void setKzxNo(String kzxNo) {
        this.kzxNo = kzxNo;
    }

    public String getCuAddr() {
        return cuAddr;
    }

    public void setCuAddr(String cuAddr) {
        this.cuAddr = cuAddr;
    }

    public String getCuType() {
        return cuType;
    }

    public void setCuType(String cuType) {
        this.cuType = cuType;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
