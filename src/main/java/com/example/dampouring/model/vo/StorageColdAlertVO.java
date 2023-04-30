package com.example.dampouring.model.vo;

public class StorageColdAlertVO {
    private Integer id;

    private Double age;

    private Double tempCurr;

    private Double tempTarget;

    private Double coldAmount;

    private String alertType;

    private String alertContent;

    private String alertTime;

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

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Double getTempCurr() {
        return tempCurr;
    }

    public void setTempCurr(Double tempCurr) {
        this.tempCurr = tempCurr;
    }

    public Double getTempTarget() {
        return tempTarget;
    }

    public void setTempTarget(Double tempTarget) {
        this.tempTarget = tempTarget;
    }

    public Double getColdAmount() {
        return coldAmount;
    }

    public void setColdAmount(Double coldAmount) {
        this.coldAmount = coldAmount;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getAlertContent() {
        return alertContent;
    }

    public void setAlertContent(String alertContent) {
        this.alertContent = alertContent;
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
}
