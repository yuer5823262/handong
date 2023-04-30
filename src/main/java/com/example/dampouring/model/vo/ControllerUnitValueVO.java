package com.example.dampouring.model.vo;

import java.util.ArrayList;
import java.util.List;

public class ControllerUnitValueVO {
    private Integer id;
    private String name;
    private String cuAddr;
    private String cuType;
    private List<Double> valueList = new ArrayList<>();
    private String time;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuAddr() {
        return cuAddr;
    }

    public void setCuAddr(String cuAddr) {
        this.cuAddr = cuAddr;
    }

    public String getCuType() {
        return cuType;
    }

    public void setCuType(String cuType) {
        this.cuType = cuType;
    }

    public List<Double> getValueList() {
        return valueList;
    }

    public void setValueList(List<Double> valueList) {
        this.valueList = valueList;
    }

    public void addValueList(Double value) {
        this.valueList.add(value);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
