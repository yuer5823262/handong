package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class WaterMonitorVO {

    private String smallNo;

    private String time;

    private String waterPipeNo;

    private Double enterTemp;

    private Double outTemp;

    private Double enterMpa;

    private Double outMpa;
    private Double mpaDiff;
    private String isCb;
    private Double flow;

    private Double opening;

    public String getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(String smallNo) {
        this.smallNo = smallNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWaterPipeNo() {
        return waterPipeNo;
    }

    public void setWaterPipeNo(String waterPipeNo) {
        this.waterPipeNo = waterPipeNo;
    }

    public Double getEnterTemp() {
        return enterTemp;
    }

    public void setEnterTemp(Double enterTemp) {
        this.enterTemp = enterTemp;
    }

    public Double getOutTemp() {
        return outTemp;
    }

    public void setOutTemp(Double outTemp) {
        this.outTemp = outTemp;
    }

    public Double getEnterMpa() {
        return enterMpa;
    }

    public void setEnterMpa(Double enterMpa) {
        this.enterMpa = enterMpa;
    }

    public Double getOutMpa() {
        return outMpa;
    }

    public void setOutMpa(Double outMpa) {
        this.outMpa = outMpa;
    }

    public Double getMpaDiff() {
        return mpaDiff;
    }

    public void setMpaDiff(Double mpaDiff) {
        this.mpaDiff = mpaDiff;
    }

    public String getIsCb() {
        return isCb;
    }

    public void setIsCb(String isCb) {
        this.isCb = isCb;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }

    public Double getOpening() {
        return opening;
    }

    public void setOpening(Double opening) {
        this.opening = opening;
    }
}
