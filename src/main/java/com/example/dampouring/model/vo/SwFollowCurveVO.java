package com.example.dampouring.model.vo;

public class SwFollowCurveVO {
    private Integer id;

    private String sbNo;

    private Double airTemp;

    private Double scTemp;
    private Double mbTemp;
    private Double ycTemp;

    private Double waterTemp;

    private Double scFlow;
    private Double ycFlow;
    private Double mbFlow;
    private Double frxg;

    private Double cmsr;

    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public Double getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(Double airTemp) {
        this.airTemp = airTemp;
    }

    public Double getScTemp() {
        return scTemp;
    }

    public void setScTemp(Double scTemp) {
        this.scTemp = scTemp;
    }

    public Double getMbTemp() {
        return mbTemp;
    }

    public void setMbTemp(Double mbTemp) {
        this.mbTemp = mbTemp;
    }

    public Double getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(Double waterTemp) {
        this.waterTemp = waterTemp;
    }

    public Double getScFlow() {
        return scFlow;
    }

    public void setScFlow(Double scFlow) {
        this.scFlow = scFlow;
    }

    public Double getYcFlow() {
        return ycFlow;
    }

    public void setYcFlow(Double ycFlow) {
        this.ycFlow = ycFlow;
    }

    public Double getMbFlow() {
        return mbFlow;
    }

    public void setMbFlow(Double mbFlow) {
        this.mbFlow = mbFlow;
    }

    public Double getYcTemp() {
        return ycTemp;
    }

    public void setYcTemp(Double ycTemp) {
        this.ycTemp = ycTemp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getFrxg() {
        return frxg;
    }

    public void setFrxg(Double frxg) {
        this.frxg = frxg;
    }

    public Double getCmsr() {
        return cmsr;
    }

    public void setCmsr(Double cmsr) {
        this.cmsr = cmsr;
    }
}
