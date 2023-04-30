package com.example.dampouring.model.vo;

public class SmartHeat7dayVO {
    private Integer id;

    private String sbNo;

    private String bwTime;

    private String time;

    private String materials;

    private Double thickness;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public String getBwTime() {
        return bwTime;
    }

    public void setBwTime(String bwTime) {
        this.bwTime = bwTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }
}
