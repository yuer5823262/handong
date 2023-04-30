package com.example.dampouring.model.pojo;

public class SmartFlowResult {
    private Integer id;

    private Integer sbId;

    private String time;

    private Double innerTemp;

    private Double predicTemp;

    private Double targetTemp;

    private Double flow;

    private Double targetFlow;

    private Double waterTemp;

    private Double airTemp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Double getInnerTemp() {
        return innerTemp;
    }

    public void setInnerTemp(Double innerTemp) {
        this.innerTemp = innerTemp;
    }

    public Double getPredicTemp() {
        return predicTemp;
    }

    public void setPredicTemp(Double predicTemp) {
        this.predicTemp = predicTemp;
    }

    public Double getTargetTemp() {
        return targetTemp;
    }

    public void setTargetTemp(Double targetTemp) {
        this.targetTemp = targetTemp;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }

    public Double getTargetFlow() {
        return targetFlow;
    }

    public void setTargetFlow(Double targetFlow) {
        this.targetFlow = targetFlow;
    }

    public Double getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(Double waterTemp) {
        this.waterTemp = waterTemp;
    }

    public Double getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(Double airTemp) {
        this.airTemp = airTemp;
    }
}