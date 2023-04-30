package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class ControlProcess {
    private Integer id;
    @Excel(name = "时间",width = 20)
    private String time;
    @Excel(name = "仓号",width = 20)
    private String sbNo;
    @Excel(name = "水管编号",width = 20)
    private String wpNo;
    @Excel(name = "调控前流量",width = 20)
    private Double electricity;
    @Excel(name = "阀门开度",width = 20)
    private Double opening;
    @Excel(name = "调控后流量",width = 20)
    private Double flow;
    @Excel(name = "目标流量",width = 20)
    private Double mbFlow;
    @Excel(name = "换向",width = 20)
    private String direction;
    @Excel(name = "是否满足",width = 20)
    private String isMeetDemand;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public String getWpNo() {
        return wpNo;
    }

    public void setWpNo(String wpNo) {
        this.wpNo = wpNo;
    }

    public Double getElectricity() {
        return electricity;
    }

    public void setElectricity(Double electricity) {
        this.electricity = electricity;
    }

    public Double getOpening() {
        return opening;
    }

    public void setOpening(Double opening) {
        this.opening = opening;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }

    public Double getMbFlow() {
        return mbFlow;
    }

    public void setMbFlow(Double mbFlow) {
        this.mbFlow = mbFlow;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getIsMeetDemand() {
        return isMeetDemand;
    }

    public void setIsMeetDemand(String isMeetDemand) {
        this.isMeetDemand = isMeetDemand;
    }

    public void setMdBySelf()
    {
        if(Math.abs(flow-mbFlow)<=0.2)
            isMeetDemand="是";
        else
            isMeetDemand="否";
    }
}