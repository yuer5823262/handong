package com.example.dampouring.model.vo;

public class CurTempInfo {
    private Integer pointId;
    private String pointName;
    private Double standardValue;
    private Double minVal;
    private Double maxVal;
    private Double curValue;
    private Double age;
    private Double coolingRate;
    private Double waterFlow;

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Double getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(Double standardValue) {
        this.standardValue = standardValue;
    }

    public Double getMinVal() {
        return minVal;
    }

    public void setMinVal(Double minVal) {
        this.minVal = minVal;
    }

    public Double getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(Double maxVal) {
        this.maxVal = maxVal;
    }

    public Double getCurValue() {
        return curValue;
    }

    public void setCurValue(Double curValue) {
        this.curValue = curValue;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Double getCoolingRate() {
        return coolingRate;
    }

    public void setCoolingRate(Double coolingRate) {
        this.coolingRate = coolingRate;
    }

    public Double getWaterFlow() {
        return waterFlow;
    }

    public void setWaterFlow(Double waterFlow) {
        this.waterFlow = waterFlow;
    }
}
