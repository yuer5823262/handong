package com.example.dampouring.model.pojo;

public class TempControlCurveSpecial {
    private Integer id;

    private String winterCoolingStartTime;

    private Integer winterCoolingDays;

    private Double winterCoolingTargetTemp;

    private String overflowingStartTime;

    private Integer overflowingDays;

    private Double overflowingTargetTemp;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWinterCoolingStartTime() {
        return winterCoolingStartTime;
    }

    public void setWinterCoolingStartTime(String winterCoolingStartTime) {
        this.winterCoolingStartTime = winterCoolingStartTime == null ? null : winterCoolingStartTime.trim();
    }

    public Integer getWinterCoolingDays() {
        return winterCoolingDays;
    }

    public void setWinterCoolingDays(Integer winterCoolingDays) {
        this.winterCoolingDays = winterCoolingDays;
    }

    public Double getWinterCoolingTargetTemp() {
        return winterCoolingTargetTemp;
    }

    public void setWinterCoolingTargetTemp(Double winterCoolingTargetTemp) {
        this.winterCoolingTargetTemp = winterCoolingTargetTemp;
    }

    public String getOverflowingStartTime() {
        return overflowingStartTime;
    }

    public void setOverflowingStartTime(String overflowingStartTime) {
        this.overflowingStartTime = overflowingStartTime == null ? null : overflowingStartTime.trim();
    }

    public Integer getOverflowingDays() {
        return overflowingDays;
    }

    public void setOverflowingDays(Integer overflowingDays) {
        this.overflowingDays = overflowingDays;
    }

    public Double getOverflowingTargetTemp() {
        return overflowingTargetTemp;
    }

    public void setOverflowingTargetTemp(Double overflowingTargetTemp) {
        this.overflowingTargetTemp = overflowingTargetTemp;
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