package com.example.dampouring.model.pojo;

public class SmartWarehouseWarning {
    private Integer id;

    private Integer smallId;

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

    public Integer getSmallId() {
        return smallId;
    }

    public void setSmallId(Integer smallId) {
        this.smallId = smallId;
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
        this.time = time == null ? null : time.trim();
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
        this.processingTime = processingTime == null ? null : processingTime.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}