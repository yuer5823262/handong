package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class DailyOneWaterVO {
    private Integer id;

    private Integer sbId;
    @Excel(name = "浇筑单元",width = 20)
    private String sbNo;
    @Excel(name = "巡查时间",width = 20)
    private String time;
    @Excel(name = "24h最低气温(℃)",width = 20)
    private Double min24hTemp;
    @Excel(name = "24h最高气温(℃)",width = 20)
    private Double max24hTemp;
    @Excel(name = "平均气温(℃)",width = 20)
    private Double avgTemp;
    @Excel(name = "水-混凝土温差(℃)",width = 20)
    private Double waterBetonTempDiff;
    @Excel(name = "内部温度(℃)",width = 20)
    private Double innerTemp;
    @Excel(name = "表面温度(℃)",width = 20)
    private Double surfaceTemp;
    @Excel(name = "混凝土内部与表面温差(℃)",width = 20)
    private Double innerSurfaceTempDiff;
    @Excel(name = "是否满足设计要求",width = 20)
    private String isHgDiff;
    @Excel(name = "降温速率(℃)",width = 20)
    private Double coolingRate;
    @Excel(name = "龄期",width = 20)
    private String age;
    @Excel(name = "累计通水时长",width = 20)
    private Integer waterTime;
    @Excel(name = "是否满足设计要求",width = 20)
    private String isHgTemp;
    @Excel(name = "流量(m³/h)",width = 20)
    private Double flow;
    @Excel(name = "最低流量(m³/h)",width = 20)
    private Double minFlow;
    @Excel(name = "最高流量(m³/h)",width = 20)
    private Double maxFlow;
    @Excel(name = "平均流量(m³/h)",width = 20)
    private Double avgFlow;
    @Excel(name = "进口水温(℃)",width = 20)
    private Double inTemp;
    @Excel(name = "出口水温(℃)",width = 20)
    private Double outTemp;
    @Excel(name = "降温速率标准(℃)",width = 20)
    private Double coolingNorm;
    @Excel(name = "内部温度采集时间",width = 20)
    private String innerTime;
    @Excel(name = "备注",width = 20)
    private String mark;
    @Excel(name = "目标温度",width = 20)
    private Double targetTemp;
    @Excel(name = "是否达标",width = 20)
    private String isDb;

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

    public Double getSurfaceTemp() {
        return surfaceTemp;
    }

    public void setSurfaceTemp(Double surfaceTemp) {
        this.surfaceTemp = surfaceTemp;
    }

    public Double getInnerSurfaceTempDiff() {
        return innerSurfaceTempDiff;
    }

    public void setInnerSurfaceTempDiff(Double innerSurfaceTempDiff) {
        this.innerSurfaceTempDiff = innerSurfaceTempDiff;
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


    public Double getMax24hTemp() {
        return max24hTemp;
    }

    public void setMax24hTemp(Double max24hTemp) {
        this.max24hTemp = max24hTemp;
    }

    public Double getMinFlow() {
        return minFlow;
    }

    public void setMinFlow(Double minFlow) {
        this.minFlow = minFlow;
    }

    public Double getMaxFlow() {
        return maxFlow;
    }

    public void setMaxFlow(Double maxFlow) {
        this.maxFlow = maxFlow;
    }

    public Double getAvgFlow() {
        return avgFlow;
    }

    public void setAvgFlow(Double avgFlow) {
        this.avgFlow = avgFlow;
    }

    public Double getCoolingNorm() {
        return coolingNorm;
    }

    public void setCoolingNorm(Double coolingNorm) {
        this.coolingNorm = coolingNorm;
    }

    public String getInnerTime() {
        return innerTime;
    }

    public void setInnerTime(String innerTime) {
        this.innerTime = innerTime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Double getTargetTemp() {
        return targetTemp;
    }

    public void setTargetTemp(Double targetTemp) {
        this.targetTemp = targetTemp;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIsDb() {
        return isDb;
    }

    public void setIsDb(String isDb) {
        this.isDb = isDb;
    }
}
