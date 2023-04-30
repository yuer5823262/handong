package com.example.dampouring.model.pojo;

public class TempControlNormInfo {
    private Integer id;
    //相应标准的ID
    private Integer tempControlId;
    //月份
    private Integer month;
    //浇筑温度
    private Double pouringTemp;
    //出击口温度
    private Double portTemp;
    //入仓温度
    private Double entryTemp;
    //最高温度
    private Double maxTemp;
    //最高水温
    private Double flowTemp;
    //最低温度
    private Double minTemp;
    //最低水温
    private Double flowTempMin;

    //温度梯度
    private Double gradTemp;
    //基础温差
    private Double baseTempDiff;
    //上下层温差
    private Double upperLowTenpDiff;
    //内外温差
    private Double inOutTempDiff;
    //间歇期
    private String intervals;
    //表面保温
    private String surfaceWarm;
    //一期冷却（降温速率）
    private Double oneColdBefore;
    //中期冷却（降温速率）
    private Double oneColdAfter;
    //二期冷却（降温速率）
    private Double middleClod;
    //相邻块
    private Double adjacentBlock;
    //坝间块
    private Double betweenBlock;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempControlId() {
        return tempControlId;
    }

    public void setTempControlId(Integer tempControlId) {
        this.tempControlId = tempControlId;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getPouringTemp() {
        return pouringTemp;
    }

    public void setPouringTemp(Double pouringTemp) {
        this.pouringTemp = pouringTemp;
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
        this.intervals = intervals == null ? null : intervals.trim();
    }

    public String getSurfaceWarm() {
        return surfaceWarm;
    }

    public void setSurfaceWarm(String surfaceWarm) {
        this.surfaceWarm = surfaceWarm == null ? null : surfaceWarm.trim();
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
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
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