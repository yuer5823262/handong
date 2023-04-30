package com.example.dampouring.model.pojo;

public class SmartHeat7day {
    private Integer id;

    private Integer sbId;

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

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getBwTime() {
        return bwTime;
    }

    public void setBwTime(String bwTime) {
        this.bwTime = bwTime == null ? null : bwTime.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
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
}