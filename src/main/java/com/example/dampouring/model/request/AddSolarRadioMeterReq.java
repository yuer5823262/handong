package com.example.dampouring.model.request;

public class AddSolarRadioMeterReq {

    private String no;

    private Integer serialNo;

    private Integer equipmentNo;

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
