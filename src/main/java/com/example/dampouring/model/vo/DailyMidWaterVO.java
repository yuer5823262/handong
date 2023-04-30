package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class DailyMidWaterVO {
    private Integer id;

    private Integer sbId;
    @Excel(name = "浇筑单元",width = 20)
    private String sbNo;
    @Excel(name = "巡视时间",width = 20)
    private String time;
    @Excel(name = "24h最低气温",width = 20)
    private Double min24hTemp;
    @Excel(name = "平均气温",width = 20)
    private Double avgTemp;
    @Excel(name = "水-混凝土温差",width = 20)
    private Double waterBetonTempDiff;
    @Excel(name = "内部温度",width = 20)
    private Double innerTemp;
    @Excel(name = "是否满足设计要求",width = 20)
    private String isHgDiff;
    @Excel(name = "降温速率",width = 20)
    private Double coolingRate;
    @Excel(name = "累计通水时长",width = 20)
    private Integer waterTime;
    @Excel(name = "是否满足设计要求",width = 20)
    private String isHgTemp;
    @Excel(name = "流量",width = 20)
    private Double flow;
    @Excel(name = "进口水温",width = 20)
    private Double inTemp;
    @Excel(name = "出口水温",width = 20)
    private Double outTemp;

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

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getMin24hTemp() {
        return min24hTemp;
    }

    public void setMin24hTemp(Double min24hTemp) {
        this.min24hTemp = min24hTemp;
    }

    public Double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(Double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public Double getWaterBetonTempDiff() {
        return waterBetonTempDiff;
    }

    public void setWaterBetonTempDiff(Double waterBetonTempDiff) {
        this.waterBetonTempDiff = waterBetonTempDiff;
    }

    public Double getInnerTemp() {
        return innerTemp;
    }

    public void setInnerTemp(Double innerTemp) {
        this.innerTemp = innerTemp;
    }

    public String getIsHgDiff() {
        return isHgDiff;
    }

    public void setIsHgDiff(String isHgDiff) {
        this.isHgDiff = isHgDiff;
    }

    public Double getCoolingRate() {
        return coolingRate;
    }

    public void setCoolingRate(Double coolingRate) {
        this.coolingRate = coolingRate;
    }

    public Integer getWaterTime() {
        return waterTime;
    }

    public void setWaterTime(Integer waterTime) {
        this.waterTime = waterTime;
    }

    public String getIsHgTemp() {
        return isHgTemp;
    }

    public void setIsHgTemp(String isHgTemp) {
        this.isHgTemp = isHgTemp;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }

    public Double getInTemp() {
        return inTemp;
    }

    public void setInTemp(Double inTemp) {
        this.inTemp = inTemp;
    }

    public Double getOutTemp() {
        return outTemp;
    }

    public void setOutTemp(Double outTemp) {
        this.outTemp = outTemp;
    }
}
