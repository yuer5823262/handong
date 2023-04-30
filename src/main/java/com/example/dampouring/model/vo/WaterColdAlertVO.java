package com.example.dampouring.model.vo;

public class WaterColdAlertVO {
    private Integer id;

    private Double inwhTemp;

    private String alertType;

    private String alertTime;
    private String alertContent;
    private String hasDispose;

    private String sbNo;

    private String opTime;

    private String operator;

    public String getAlertContent() {
        return alertContent;
    }

    public void setAlertContent(String alertContent) {
        this.alertContent = alertContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getInwhTemp() {
        return inwhTemp;
    }

    public void setInwhTemp(Double inwhTemp) {
        this.inwhTemp = inwhTemp;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
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
