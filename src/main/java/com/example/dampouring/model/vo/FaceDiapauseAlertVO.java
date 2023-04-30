package com.example.dampouring.model.vo;

public class FaceDiapauseAlertVO {
    private Integer id;

    private String timeCurr;

    private String timeClose;

    private Double diapauseDays;

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

    public String getTimeCurr() {
        return timeCurr;
    }

    public void setTimeCurr(String timeCurr) {
        this.timeCurr = timeCurr;
    }

    public String getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(String timeClose) {
        this.timeClose = timeClose;
    }

    public Double getDiapauseDays() {
        return diapauseDays;
    }

    public void setDiapauseDays(Double diapauseDays) {
        this.diapauseDays = diapauseDays;
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
