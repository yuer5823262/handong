package com.example.dampouring.model.pojo;

public class waterPipeFlowAssess {
    private Integer id;

    private Integer waterPipeId;

    private String startTime;

    private Integer pipeNum;

    private Double enterTempTop;

    private Double enterTempBottom;

    private Double enterTempAvg;

    private Double outTempTop;

    private Double outTempBottom;

    private Double outTempAvg;

    private Double enterMpaTop;

    private Double enterMpaBottom;

    private Double enterMpaAvg;

    private Double outMpaTop;

    private Double outMpaBottom;

    private Double outMpaAvg;

    private Double flowTop;

    private Double flowBottom;

    private Double flowAvg;
    private String qi;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWaterPipeId() {
        return waterPipeId;
    }

    public void setWaterPipeId(Integer waterPipeId) {
        this.waterPipeId = waterPipeId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public Integer getPipeNum() {
        return pipeNum;
    }

    public void setPipeNum(Integer pipeNum) {
        this.pipeNum = pipeNum;
    }

    public Double getEnterTempTop() {
        return enterTempTop;
    }

    public void setEnterTempTop(Double enterTempTop) {
        this.enterTempTop = enterTempTop;
    }

    public Double getEnterTempBottom() {
        return enterTempBottom;
    }

    public void setEnterTempBottom(Double enterTempBottom) {
        this.enterTempBottom = enterTempBottom;
    }

    public Double getEnterTempAvg() {
        return enterTempAvg;
    }

    public void setEnterTempAvg(Double enterTempAvg) {
        this.enterTempAvg = enterTempAvg;
    }

    public Double getOutTempTop() {
        return outTempTop;
    }

    public void setOutTempTop(Double outTempTop) {
        this.outTempTop = outTempTop;
    }

    public Double getOutTempBottom() {
        return outTempBottom;
    }

    public void setOutTempBottom(Double outTempBottom) {
        this.outTempBottom = outTempBottom;
    }

    public Double getOutTempAvg() {
        return outTempAvg;
    }

    public void setOutTempAvg(Double outTempAvg) {
        this.outTempAvg = outTempAvg;
    }

    public Double getEnterMpaTop() {
        return enterMpaTop;
    }

    public void setEnterMpaTop(Double enterMpaTop) {
        this.enterMpaTop = enterMpaTop;
    }

    public Double getEnterMpaBottom() {
        return enterMpaBottom;
    }

    public void setEnterMpaBottom(Double enterMpaBottom) {
        this.enterMpaBottom = enterMpaBottom;
    }

    public Double getEnterMpaAvg() {
        return enterMpaAvg;
    }

    public void setEnterMpaAvg(Double enterMpaAvg) {
        this.enterMpaAvg = enterMpaAvg;
    }

    public Double getOutMpaTop() {
        return outMpaTop;
    }

    public void setOutMpaTop(Double outMpaTop) {
        this.outMpaTop = outMpaTop;
    }

    public Double getOutMpaBottom() {
        return outMpaBottom;
    }

    public void setOutMpaBottom(Double outMpaBottom) {
        this.outMpaBottom = outMpaBottom;
    }

    public Double getOutMpaAvg() {
        return outMpaAvg;
    }

    public void setOutMpaAvg(Double outMpaAvg) {
        this.outMpaAvg = outMpaAvg;
    }

    public Double getFlowTop() {
        return flowTop;
    }

    public void setFlowTop(Double flowTop) {
        this.flowTop = flowTop;
    }

    public Double getFlowBottom() {
        return flowBottom;
    }

    public void setFlowBottom(Double flowBottom) {
        this.flowBottom = flowBottom;
    }

    public Double getFlowAvg() {
        return flowAvg;
    }

    public void setFlowAvg(Double flowAvg) {
        this.flowAvg = flowAvg;
    }

    public String getQi() {
        return qi;
    }

    public void setQi(String qi) {
        this.qi = qi;
    }
}