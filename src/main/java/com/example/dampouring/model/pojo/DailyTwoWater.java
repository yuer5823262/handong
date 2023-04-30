package com.example.dampouring.model.pojo;

public class DailyTwoWater {
    private Integer id;

    private Integer sbId;

    private String time;

    private Double min24hTemp;

    private Double avgTemp;

    private Double waterBetonTempDiff;

    private Double innerTemp;

    private String isHgDiff;

    private Double coolingRate;

    private Integer waterTime;

    private String isHgTemp;

    private Double flow;

    private Double inTemp;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
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
        this.isHgDiff = isHgDiff == null ? null : isHgDiff.trim();
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
        this.isHgTemp = isHgTemp == null ? null : isHgTemp.trim();
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