package com.example.dampouring.model.request;

public class UpdateMixingEgSensorReq {
    private Integer id;

    private String ip;

    private Integer dkno;

    private Integer cno;

    private String remark;

    private String type;
    private String lqType;
    private String glType;
    private Integer bhid;

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

    public Integer getBhid() {
        return bhid;
    }

    public void setBhid(Integer bhid) {
        this.bhid = bhid;
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
