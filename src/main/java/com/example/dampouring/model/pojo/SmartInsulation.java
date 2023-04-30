package com.example.dampouring.model.pojo;

public class SmartInsulation {
    private Integer id;

    private Integer smallId;

    private String time;

    private Double coldWave;

    private Double tempDiff;

    private Integer isBaowen;

    private Integer isGanyu;

    private String type;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSmallId() {
        return smallId;
    }

    public void setSmallId(Integer smallId) {
        this.smallId = smallId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Double getColdWave() {
        return coldWave;
    }

    public void setColdWave(Double coldWave) {
        this.coldWave = coldWave;
    }

    public Double getTempDiff() {
        return tempDiff;
    }

    public void setTempDiff(Double tempDiff) {
        this.tempDiff = tempDiff;
    }

    public Integer getIsBaowen() {
        return isBaowen;
    }

    public void setIsBaowen(Integer isBaowen) {
        this.isBaowen = isBaowen;
    }

    public Integer getIsGanyu() {
        return isGanyu;
    }

    public void setIsGanyu(Integer isGanyu) {
        this.isGanyu = isGanyu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}