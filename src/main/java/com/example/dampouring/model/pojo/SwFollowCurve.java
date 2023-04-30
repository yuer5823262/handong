package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class SwFollowCurve {
    private Integer id;
    @Excel(name = "仓号",width = 20)
    private String sbNo;
    @Excel(name = "气温",width = 20)
    private Double airTemp;
    @Excel(name = "实测温度",width = 20)
    private Double scTemp;
    @Excel(name = "目标温度",width = 20)
    private Double mbTemp;
    @Excel(name = "水温",width = 20)
    private Double waterTemp;
    @Excel(name = "实测流量",width = 20)
    private Double scFlow;
    @Excel(name = "预测流量",width = 20)
    private Double ycFlow;
    @Excel(name = "目标流量",width = 20)
    private Double mbFlow;
    @Excel(name = "预测温度",width = 20)
    private Double ycTemp;

    private Double frxg;

    private Double cmsr;
    @Excel(name = "时间",width = 20)
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
        this.sbNo = sbNo == null ? null : sbNo.trim();
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}