package com.example.dampouring.model.request;

public class UpdateSolarRadioMeterReq {
    private Integer id;

    private String no;

    private Integer serialNo;

    private Integer equipmentNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(Integer equipmentNo) {
        this.equipmentNo = equipmentNo;
    }
}
