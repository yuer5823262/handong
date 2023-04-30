package com.example.dampouring.model.vo;

public class LayerTdiffAlertVO {
    private Integer id;

    private Double tempUpper;

    private Double tempLower;

    private Double tempDiff;

    private Double tempNorm;

    private Double exceedAmount;

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

    public Double getTempUpper() {
        return tempUpper;
    }

    public void setTempUpper(Double tempUpper) {
        this.tempUpper = tempUpper;
    }

    public Double getTempLower() {
        return tempLower;
    }

    public void setTempLower(Double tempLower) {
        this.tempLower = tempLower;
    }

    public Double getTempDiff() {
        return tempDiff;
    }

    public void setTempDiff(Double tempDiff) {
        this.tempDiff = tempDiff;
    }

    public Double getTempNorm() {
        return tempNorm;
    }

    public void setTempNorm(Double tempNorm) {
        this.tempNorm = tempNorm;
    }

    public Double getExceedAmount() {
        return exceedAmount;
    }

    public void setExceedAmount(Double exceedAmount) {
        this.exceedAmount = exceedAmount;
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
