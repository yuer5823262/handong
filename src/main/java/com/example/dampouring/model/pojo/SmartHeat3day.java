package com.example.dampouring.model.pojo;

public class SmartHeat3day {
    private Integer id;

    private Integer sbId;

    private String isBw;

    private String materials;

    private Double thickness;

    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getIsBw() {
        return isBw;
    }

    public void setIsBw(String isBw) {
        this.isBw = isBw == null ? null : isBw.trim();
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials == null ? null : materials.trim();
    }

    public Double getThickness() {
        return thickness;
    }

    public void setThickness(Double thickness) {
        this.thickness = thickness;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}