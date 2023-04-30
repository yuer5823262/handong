package com.example.dampouring.model.vo;

public class ReduceTempAlertVO {
    private Integer id;

    private Double tempToday;

    private Double tempYesterday;

    private Double reduceSpeed;

    private Double exceedAmount;

    private Double normSpeed;

    private String alertTime;
    private String alertContent;
    private String hasDispose;

    private String sbNo;

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

    public Double getExceedAmount() {
        return exceedAmount;
    }

    public void setExceedAmount(Double exceedAmount) {
        this.exceedAmount = exceedAmount;
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
        this.alertTime = alertTime;
    }

    public String getHasDispose() {
        return hasDispose;
    }

    public void setHasDispose(String hasDispose) {
        this.hasDispose = hasDispose;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public String getOpTime() {
        return opTime;
    }

    public void setOpTime(String opTime) {
        this.opTime = opTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAlertContent() {
        return alertContent;
    }

    public void setAlertContent(String alertContent) {
        this.alertContent = alertContent;
    }
}
