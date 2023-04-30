package com.example.dampouring.model.pojo;

public class DailyPourTemp {
    private Integer id;

    private Integer sbId;

    private String time;

    private Double temp;

    private Double exTemp;

    private Double inTemp;

    private Double pourTemp;

    private Double transTempUp;

    private Double surfaceTempUp;

    private String isHg;

    private String mark;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getExTemp() {
        return exTemp;
    }

    public void setExTemp(Double exTemp) {
        this.exTemp = exTemp;
    }

    public Double getInTemp() {
        return inTemp;
    }

    public void setInTemp(Double inTemp) {
        this.inTemp = inTemp;
    }

    public Double getPourTemp() {
        return pourTemp;
    }

    public void setPourTemp(Double pourTemp) {
        this.pourTemp = pourTemp;
    }

    public Double getTransTempUp() {
        return transTempUp;
    }

    public void setTransTempUp(Double transTempUp) {
        this.transTempUp = transTempUp;
    }

    public Double getSurfaceTempUp() {
        return surfaceTempUp;
    }

    public void setSurfaceTempUp(Double surfaceTempUp) {
        this.surfaceTempUp = surfaceTempUp;
    }

    public String getIsHg() {
        return isHg;
    }

    public void setIsHg(String isHg) {
        this.isHg = isHg == null ? null : isHg.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}