package com.example.dampouring.model.request;

public class UpdateSmartWarehouseNormReq {
    private Integer id;

    private Integer month;

    private Double norm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getNorm() {
        return norm;
    }

    public void setNorm(Double norm) {
        this.norm = norm;
    }
}
