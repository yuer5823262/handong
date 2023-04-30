package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class WaterPipeFlowInfo {
    private Integer id;
    @Excel(name = "水管id",width = 20)
    private Integer waterPipeId;
    @Excel(name = "时间",width = 20)
    private String time;
    @Excel(name = "入口温度",width = 20)
    private Double enterTemp;
    @Excel(name = "出口温度",width = 20)
    private Double outTemp;
    @Excel(name = "入口水压",width = 20)
    private Double enterMpa;
    @Excel(name = "出口水压",width = 20)
    private Double outMpa;
    @Excel(name = "流量",width = 20)
    private Double flow;
    @Excel(name = "阀门开度",width = 20)
    private Double opening;
    private Integer bl;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
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
    public Double getMaxTemp(){
        return outTemp>enterTemp?outTemp:enterTemp;
    }
    public Double getMinTemp(){
        return outTemp<enterTemp?outTemp:enterTemp;
    }

    public String getQi() {
        return qi;
    }

    public void setQi(String qi) {
        this.qi = qi;
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }

    public void setTemp()
    {
        if(outTemp<enterTemp)
        {
            Double temp=outTemp;
            outTemp=enterTemp;
            enterTemp=temp;
        }
    }
    public void setMpa()
    {
        if(outMpa>enterMpa)
        {
            Double temp=outMpa;
            outMpa=enterMpa;
            enterMpa=temp;
        }
    }
}