package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class WaterPipeFlowInfoVO {
    private Integer id;
    @Excel(name = "仓号",width = 20)
    private String smallNo;
    @Excel(name = "时间",width = 20)
    private String time;
    @Excel(name = "水管编号",width = 20)
    private String waterPipeNo;
    @Excel(name = "进口水温",width = 20)
    private Double enterTemp;
    @Excel(name = "出口水温",width = 20)
    private Double outTemp;
    @Excel(name = "进口水压",width = 20)
    private Double enterMpa;
    @Excel(name = "出口水压",width = 20)
    private Double outMpa;
    @Excel(name = "通水流量",width = 20)
    private Double flow;
    @Excel(name = "阀门开度",width = 20)
    private Double opening;
    @Excel(name = "期数",width = 20)
    private String qi;
    private Integer bl;
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

    public String getQi() {
        return qi;
    }

    public void setQi(String qs) {
        this.qi = qs;
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }

    public String toMqStr() {
        return "通水数据"+","+smallNo+","+time+","+waterPipeNo+","+enterTemp+","+outTemp+","+
                enterMpa+","+outMpa+","+flow+","+qi;
    }
}
