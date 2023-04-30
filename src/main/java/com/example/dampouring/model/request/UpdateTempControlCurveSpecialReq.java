package com.example.dampouring.model.request;

public class UpdateTempControlCurveSpecialReq {
    private Integer id;

    private String winterCoolingStartTime;

    private Integer winterCoolingDays;

    private Double winterCoolingTargetTemp;

    private String overflowingStartTime;

    private Integer overflowingDays;

    private Double overflowingTargetTemp;

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
        this.winterCoolingStartTime = winterCoolingStartTime;
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
        this.overflowingStartTime = overflowingStartTime;
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
}
