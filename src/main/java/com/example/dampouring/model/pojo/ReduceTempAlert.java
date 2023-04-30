package com.example.dampouring.model.pojo;

public class ReduceTempAlert {
    private Integer id;

    private Double tempToday;

    private Double tempYesterday;

    private Double reduceSpeed;

    private Double exceedAmount;

    private Double normSpeed;

    private String alertTime;
    private String alertContent;
    private String hasDispose;

    private Integer sbId;

    private String opTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTempToday() {
        return tempToday;
    }

    public void setTempToday(Double tempToday) {
        this.tempToday = tempToday;
    }

    public Double getTempYesterday() {
        return tempYesterday;
    }

    public void setTempYesterday(Double tempYesterday) {
        this.tempYesterday = tempYesterday;
    }

    public Double getReduceSpeed() {
        return reduceSpeed;
    }

    public void setReduceSpeed(Double reduceSpeed) {
        this.reduceSpeed = reduceSpeed;
    }


    public void setReduceSpeedBySelf() {
        this.reduceSpeed = this.tempYesterday-this.tempToday;
    }

    public Double getExceedAmount() {
        return exceedAmount;
    }

    public void setExceedAmount(Double exceedAmount) {
        this.exceedAmount = exceedAmount;
    }
    public void setExceedAmountBySelf() {
        this.exceedAmount = this.reduceSpeed-this.normSpeed;
    }

    public Double getNormSpeed() {
        return normSpeed;
    }

    public void setNormSpeed(Double normSpeed) {
        this.normSpeed = normSpeed;
    }

    public String getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(String alertTime) {
        this.alertTime = alertTime == null ? null : alertTime.trim();
    }

    public String getHasDispose() {
        return hasDispose;
    }

    public void setHasDispose(String hasDispose) {
        this.hasDispose = hasDispose == null ? null : hasDispose.trim();
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getOpTime() {
        return opTime;
    }

    public void setOpTime(String opTime) {
        this.opTime = opTime == null ? null : opTime.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getAlertContent() {
        return alertContent;
    }

    public void setAlertContent(String alertContent) {
        this.alertContent = alertContent;
    }
}