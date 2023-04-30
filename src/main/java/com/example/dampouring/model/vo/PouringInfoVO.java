package com.example.dampouring.model.vo;

public class PouringInfoVO {
    private Integer warehouseId;
    private String warehouseName;
    private Double monthPouringQuantity;
    private String PouringStartTime;
    private Double PouringIntensity;
    private String PouringEndTime;
    private Double PouringPly;
    private Double PouringTime;


    public String getPouringEndTime() {
        return PouringEndTime;
    }

    public void setPouringEndTime(String pouringEndTime) {
        PouringEndTime = pouringEndTime;
    }

    public Double getPouringPly() {
        return PouringPly;
    }

    public void setPouringPly(Double pouringPly) {
        PouringPly = pouringPly;
    }

    public Double getPouringTime() {
        return PouringTime;
    }

    public void setPouringTime(Double pouringTime) {
        PouringTime = pouringTime;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Double getMonthPouringQuantity() {
        return monthPouringQuantity;
    }

    public void setMonthPouringQuantity(Double monthPouringQuantity) {
        this.monthPouringQuantity = monthPouringQuantity;
    }

    public String getPouringStartTime() {
        return PouringStartTime;
    }

    public void setPouringStartTime(String pouringStartTime) {
        PouringStartTime = pouringStartTime;
    }

    public Double getPouringIntensity() {
        return PouringIntensity;
    }

    public void setPouringIntensity(Double pouringIntensity) {
        PouringIntensity = pouringIntensity;
    }
}
