package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class MixingEgSensorVO {
    private Integer id;
    @Excel(name = "IP地址",width = 20)
    private String ip;
    @Excel(name = "端口号",width = 20)
    private Integer dkno;
    @Excel(name = "通道号",width = 20)
    private Integer cno;
    @Excel(name = "备注",width = 20)
    private String remark;
    @Excel(name = "类型",width = 20)
    private String type;
    @Excel(name = "冷却类型",width = 20)
    private String lqType;
    @Excel(name = "骨料类型",width = 20)
    private String glType;
    @Excel(name = "拌合楼号",width = 20)
    private String bhNo;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getDkno() {
        return dkno;
    }

    public void setDkno(Integer dkno) {
        this.dkno = dkno;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
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

    public String getBhNo() {
        return bhNo;
    }

    public void setBhNo(String bhNo) {
        this.bhNo = bhNo;
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

    public String getLqType() {
        return lqType;
    }

    public void setLqType(String lqType) {
        this.lqType = lqType;
    }

    public String getGlType() {
        return glType;
    }

    public void setGlType(String glType) {
        this.glType = glType;
    }
}
