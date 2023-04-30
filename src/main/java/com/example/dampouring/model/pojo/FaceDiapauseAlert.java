package com.example.dampouring.model.pojo;

public class FaceDiapauseAlert {
    private Integer id;

    private String timeCurr;

    private String timeClose;

    private Double diapauseDays;

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

    public String getTimeCurr() {
        return timeCurr;
    }

    public void setTimeCurr(String timeCurr) {
        this.timeCurr = timeCurr == null ? null : timeCurr.trim();
    }

    public String getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(String timeClose) {
        this.timeClose = timeClose == null ? null : timeClose.trim();
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