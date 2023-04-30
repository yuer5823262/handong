package com.example.dampouring.model.pojo;

public class MixingEgSensor {
    private Integer id;

    private String ip;

    private Integer dkno;

    private Integer cno;

    private String remark;

    private String type;
    private String lqType;
    private String glType;
    private Integer bhid;

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
        this.ip = ip == null ? null : ip.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getBhid() {
        return bhid;
    }

    public void setBhid(Integer bhid) {
        this.bhid = bhid;
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