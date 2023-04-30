package com.example.dampouring.model.pojo;

public class TempRiseAlert {
    private Integer id;

    private Integer tmeterId;

    private Double sbNorm;

    private String alertType;

    private String alertContent;

    private String alertTime;

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

    public Integer getTmeterId() {
        return tmeterId;
    }

    public void setTmeterId(Integer tmeterId) {
        this.tmeterId = tmeterId;
    }

    public Double getSbNorm() {
        return sbNorm;
    }

    public void setSbNorm(Double sbNorm) {
        this.sbNorm = sbNorm;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType == null ? null : alertType.trim();
    }

    public String getAlertContent() {
        return alertContent;
    }

    public void setAlertContent(String alertContent) {
        this.alertContent = alertContent == null ? null : alertContent.trim();
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
}