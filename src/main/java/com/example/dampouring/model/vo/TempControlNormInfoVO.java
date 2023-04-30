package com.example.dampouring.model.vo;

import java.util.Date;

public class TempControlNormInfoVO {
    private Integer id;

    private String tempControlName;

    private Integer month;

    private Double portTemp;
    private Double minTemp;

    private Double flowTempMin;
    private Double entryTemp;
    private Double pouringTemp;
    private Double flowTemp;

    private Double gradTemp;
    private Double maxTemp;

    private Double baseTempDiff;

    private Double upperLowTenpDiff;

    private Double inOutTempDiff;

    private String intervals;

    private String surfaceWarm;

    private Double oneColdBefore;

    private Double oneColdAfter;

    private Double middleClod;

    private Double adjacentBlock;

    private Double betweenBlock;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTempControlName() {
        return tempControlName;
    }

    public void setTempControlName(String tempControlName) {
        this.tempControlName = tempControlName;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getPortTemp() {
        return portTemp;
    }

    public void setPortTemp(Double portTemp) {
        this.portTemp = portTemp;
    }

    public Double getEntryTemp() {
        return entryTemp;
    }

    public void setEntryTemp(Double entryTemp) {
        this.entryTemp = entryTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getBaseTempDiff() {
        return baseTempDiff;
    }

    public void setBaseTempDiff(Double baseTempDiff) {
        this.baseTempDiff = baseTempDiff;
    }

    public Double getUpperLowTenpDiff() {
        return upperLowTenpDiff;
    }

    public void setUpperLowTenpDiff(Double upperLowTenpDiff) {
        this.upperLowTenpDiff = upperLowTenpDiff;
    }

    public Double getInOutTempDiff() {
        return inOutTempDiff;
    }

    public void setInOutTempDiff(Double inOutTempDiff) {
        this.inOutTempDiff = inOutTempDiff;
    }

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }

    public String getSurfaceWarm() {
        return surfaceWarm;
    }

    public void setSurfaceWarm(String surfaceWarm) {
        this.surfaceWarm = surfaceWarm;
    }

    public Double getOneColdBefore() {
        return oneColdBefore;
    }

    public void setOneColdBefore(Double oneColdBefore) {
        this.oneColdBefore = oneColdBefore;
    }

    public Double getOneColdAfter() {
        return oneColdAfter;
    }

    public void setOneColdAfter(Double oneColdAfter) {
        this.oneColdAfter = oneColdAfter;
    }

    public Double getMiddleClod() {
        return middleClod;
    }

    public void setMiddleClod(Double middleClod) {
        this.middleClod = middleClod;
    }

    public Double getAdjacentBlock() {
        return adjacentBlock;
    }

    public void setAdjacentBlock(Double adjacentBlock) {
        this.adjacentBlock = adjacentBlock;
    }

    public Double getBetweenBlock() {
        return betweenBlock;
    }

    public void setBetweenBlock(Double betweenBlock) {
        this.betweenBlock = betweenBlock;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double getPouringTemp() {
        return pouringTemp;
    }

    public void setPouringTemp(Double pouringTemp) {
        this.pouringTemp = pouringTemp;
    }

    public Double getFlowTemp() {
        return flowTemp;
    }

    public void setFlowTemp(Double flowTemp) {
        this.flowTemp = flowTemp;
    }

    public Double getGradTemp() {
        return gradTemp;
    }

    public void setGradTemp(Double gradTemp) {
        this.gradTemp = gradTemp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getFlowTempMin() {
        return flowTempMin;
    }

    public void setFlowTempMin(Double flowTempMin) {
        this.flowTempMin = flowTempMin;
    }
}
