package com.example.dampouring.model.pojo;

public class LayerTdiffAlert {
    private Integer id;

    private Double tempUpper;

    private Double tempLower;

    private Double tempDiff;

    private Double tempNorm;

    private Double exceedAmount;

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