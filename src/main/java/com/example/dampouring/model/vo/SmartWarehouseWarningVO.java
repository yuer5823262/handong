package com.example.dampouring.model.vo;

public class SmartWarehouseWarningVO {
    private Integer id;

    private String smallNo;

    private Double temp;

    private Double norm;

    private Double excessive;

    private String time;

    private Integer isProcessing;

    private String processingTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(String smallNo) {
        this.smallNo = smallNo;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getNorm() {
        return norm;
    }

    public void setNorm(Double norm) {
        this.norm = norm;
    }

    public Double getExcessive() {
        return excessive;
    }

    public void setExcessive(Double excessive) {
        this.excessive = excessive;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getIsProcessing() {
        return isProcessing;
    }

    public void setIsProcessing(Integer isProcessing) {
        this.isProcessing = isProcessing;
    }

    public String getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(String processingTime) {
        this.processingTime = processingTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
