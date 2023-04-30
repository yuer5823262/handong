package com.example.dampouring.model.vo;

public class DataMissAlertVO {
    private Integer id;

    private String missType;

    private Integer missDays;

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

    public String getMissType() {
        return missType;
    }

    public void setMissType(String missType) {
        this.missType = missType;
    }

    public Integer getMissDays() {
        return missDays;
    }

    public void setMissDays(Integer missDays) {
        this.missDays = missDays;
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
