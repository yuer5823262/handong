package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class WaterPipeFlowAssessVO {
    private Integer id;
    @Excel(name = "仓号",width = 20)
    private String smallNo;
    @Excel(name = "水管编号",width = 20)
    private String waterPipeNo;
    @Excel(name = "开始通水时间",width = 20)
    private String startTime;
    @Excel(name = "管路数目",width = 20)
    private Integer pipeNum;
    @Excel(name = "进口水温最大值（C°）",width = 20)
    private Double enterTempTop;
    @Excel(name = "进口水温最小值（C°）",width = 20)
    private Double enterTempBottom;
    @Excel(name = "进口水温平均值（C°）",width = 20)
    private Double enterTempAvg;
    @Excel(name = "出口水温最大值（C°）",width = 20)
    private Double outTempTop;
    @Excel(name = "出口水温最小值（C°）",width = 20)
    private Double outTempBottom;
    @Excel(name = "出口水温平均值（C°）",width = 20)
    private Double outTempAvg;
    @Excel(name = "进口水压最大值（MPa）",width = 20)
    private Double enterMpaTop;
    @Excel(name = "进口水压最小值（MPa）",width = 20)
    private Double enterMpaBottom;
    @Excel(name = "进口水压平均值（MPa）",width = 20)
    private Double enterMpaAvg;
    @Excel(name = "出口水压最大值（MPa）",width = 20)
    private Double outMpaTop;
    @Excel(name = "出口水压最小值（MPa）",width = 20)
    private Double outMpaBottom;
    @Excel(name = "出口水压平均值（MPa）",width = 20)
    private Double outMpaAvg;
    @Excel(name = "流量最大值（m³/d）",width = 20)
    private Double flowTop;
    @Excel(name = "流量最小值（m³/d）",width = 20)
    private Double flowBottom;
    @Excel(name = "流量平均值（m³/d）",width = 20)
    private Double flowAvg;
    @Excel(name = "总通水流量（m³/d）",width = 20)
    private Double flowCount;
    @Excel(name = "期数",width = 20)
    private String qi;

    public Double getFlowCount() {
        return flowCount;
    }

    public void setFlowCount(Double flowCount) {
        this.flowCount = flowCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(String smallNo) {
        this.smallNo = smallNo;
    }

    public String getWaterPipeNo() {
        return waterPipeNo;
    }

    public void setWaterPipeNo(String waterPipeNo) {
        this.waterPipeNo = waterPipeNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
