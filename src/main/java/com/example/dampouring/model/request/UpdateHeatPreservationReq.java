package com.example.dampouring.model.request;

public class UpdateHeatPreservationReq {
    private Integer id;

    private Integer smallSbId;

    private String warmStartTime;

    private String warmEndTime;

    private String exposeStartTime;

    private String exposeEndTime;

    private String position;

    private String materials;

    private Integer thickness;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSmallSbId() {
        return smallSbId;
    }

    public void setSmallSbId(Integer smallSbId) {
        this.smallSbId = smallSbId;
    }

    public String getWarmStartTime() {
        return warmStartTime;
    }

    public void setWarmStartTime(String warmStartTime) {
        this.warmStartTime = warmStartTime;
    }

    public String getWarmEndTime() {
        return warmEndTime;
    }

    public void setWarmEndTime(String warmEndTime) {
        this.warmEndTime = warmEndTime;
    }

    public String getExposeStartTime() {
        return exposeStartTime;
    }

    public void setExposeStartTime(String exposeStartTime) {
        this.exposeStartTime = exposeStartTime;
    }

    public String getExposeEndTime() {
        return exposeEndTime;
    }

    public void setExposeEndTime(String exposeEndTime) {
        this.exposeEndTime = exposeEndTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public Integer getThickness() {
        return thickness;
    }

    public void setThickness(Integer thickness) {
        this.thickness = thickness;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
