package com.example.dampouring.model.pojo;

public class HeatPreservation {
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

    private String createTime;

    private String operator;

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
        this.warmStartTime = warmStartTime == null ? null : warmStartTime.trim();
    }

    public String getWarmEndTime() {
        return warmEndTime;
    }

    public void setWarmEndTime(String warmEndTime) {
        this.warmEndTime = warmEndTime == null ? null : warmEndTime.trim();
    }

    public String getExposeStartTime() {
        return exposeStartTime;
    }

    public void setExposeStartTime(String exposeStartTime) {
        this.exposeStartTime = exposeStartTime == null ? null : exposeStartTime.trim();
    }

    public String getExposeEndTime() {
        return exposeEndTime;
    }

    public void setExposeEndTime(String exposeEndTime) {
        this.exposeEndTime = exposeEndTime == null ? null : exposeEndTime.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials == null ? null : materials.trim();
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