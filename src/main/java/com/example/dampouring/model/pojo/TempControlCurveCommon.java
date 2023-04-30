package com.example.dampouring.model.pojo;

public class TempControlCurveCommon {
    private Integer id;

    private Integer idealId;

    private Double pouringTemp;

    private Integer oneColdTempControlTime;

    private Double maxTemp;

    private Integer oneColdCoolingTime;

    private Double oneColdCoolingTargetTemp;

    private Integer oneColdAfterTempControlTime;

    private Double oneColdAfterTargetTemp;

    private Integer middleColdCoolingTime;

    private Double middleColdCoolingTargetTemp;

    private Integer middleColdTempControlTime;

    private Double middleColdTempControlTargetTemp;

    private Double middleColdTempControlTargetTemp1;

    private Double twoColdCoolingTargetTemp;

    private Double twoColdCoolingTargetTemp1;

    private Double twoColdTempControlTargetTemp;

    private String createTime;

    private String operator;
    public Double getNormTargetTemp(Integer qs)
    {
        switch (qs)
        {
            case 1:return oneColdCoolingTargetTemp;
            case 2:return middleColdCoolingTargetTemp;
            case 3:return twoColdCoolingTargetTemp;
        }
        return null;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdealId() {
        return idealId;
    }

    public void setIdealId(Integer idealId) {
        this.idealId = idealId;
    }

    public Double getPouringTemp() {
        return pouringTemp;
    }

    public void setPouringTemp(Double pouringTemp) {
        this.pouringTemp = pouringTemp;
    }

    public Integer getOneColdTempControlTime() {
        return oneColdTempControlTime;
    }

    public void setOneColdTempControlTime(Integer oneColdTempControlTime) {
        this.oneColdTempControlTime = oneColdTempControlTime;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Integer getOneColdCoolingTime() {
        return oneColdCoolingTime;
    }

    public void setOneColdCoolingTime(Integer oneColdCoolingTime) {
        this.oneColdCoolingTime = oneColdCoolingTime;
    }

    public Double getOneColdCoolingTargetTemp() {
        return oneColdCoolingTargetTemp;
    }

    public void setOneColdCoolingTargetTemp(Double oneColdCoolingTargetTemp) {
        this.oneColdCoolingTargetTemp = oneColdCoolingTargetTemp;
    }

    public Integer getOneColdAfterTempControlTime() {
        return oneColdAfterTempControlTime;
    }

    public void setOneColdAfterTempControlTime(Integer oneColdAfterTempControlTime) {
        this.oneColdAfterTempControlTime = oneColdAfterTempControlTime;
    }

    public Double getOneColdAfterTargetTemp() {
        return oneColdAfterTargetTemp;
    }

    public void setOneColdAfterTargetTemp(Double oneColdAfterTargetTemp) {
        this.oneColdAfterTargetTemp = oneColdAfterTargetTemp;
    }

    public Integer getMiddleColdCoolingTime() {
        return middleColdCoolingTime;
    }

    public void setMiddleColdCoolingTime(Integer middleColdCoolingTime) {
        this.middleColdCoolingTime = middleColdCoolingTime;
    }

    public Double getMiddleColdCoolingTargetTemp() {
        return middleColdCoolingTargetTemp;
    }

    public void setMiddleColdCoolingTargetTemp(Double middleColdCoolingTargetTemp) {
        this.middleColdCoolingTargetTemp = middleColdCoolingTargetTemp;
    }

    public Integer getMiddleColdTempControlTime() {
        return middleColdTempControlTime;
    }

    public void setMiddleColdTempControlTime(Integer middleColdTempControlTime) {
        this.middleColdTempControlTime = middleColdTempControlTime;
    }

    public Double getMiddleColdTempControlTargetTemp() {
        return middleColdTempControlTargetTemp;
    }

    public void setMiddleColdTempControlTargetTemp(Double middleColdTempControlTargetTemp) {
        this.middleColdTempControlTargetTemp = middleColdTempControlTargetTemp;
    }

    public Double getMiddleColdTempControlTargetTemp1() {
        return middleColdTempControlTargetTemp1;
    }

    public void setMiddleColdTempControlTargetTemp1(Double middleColdTempControlTargetTemp1) {
        this.middleColdTempControlTargetTemp1 = middleColdTempControlTargetTemp1;
    }

    public Double getTwoColdCoolingTargetTemp() {
        return twoColdCoolingTargetTemp;
    }

    public void setTwoColdCoolingTargetTemp(Double twoColdCoolingTargetTemp) {
        this.twoColdCoolingTargetTemp = twoColdCoolingTargetTemp;
    }

    public Double getTwoColdCoolingTargetTemp1() {
        return twoColdCoolingTargetTemp1;
    }

    public void setTwoColdCoolingTargetTemp1(Double twoColdCoolingTargetTemp1) {
        this.twoColdCoolingTargetTemp1 = twoColdCoolingTargetTemp1;
    }

    public Double getTwoColdTempControlTargetTemp() {
        return twoColdTempControlTargetTemp;
    }

    public void setTwoColdTempControlTargetTemp(Double twoColdTempControlTargetTemp) {
        this.twoColdTempControlTargetTemp = twoColdTempControlTargetTemp;
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
}