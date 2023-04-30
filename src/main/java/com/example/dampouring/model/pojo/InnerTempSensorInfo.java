package com.example.dampouring.model.pojo;


public class InnerTempSensorInfo {
    private Integer id;

    private Integer innerTempSensorId;

    private String time;
    private Double avgTemp;
    private Double temp;

    private Double norm;

    private Integer bl;

    public Double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(Double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInnerTempSensorId() {
        return innerTempSensorId;
    }

    public void setInnerTempSensorId(Integer innerTempSensorId) {
        this.innerTempSensorId = innerTempSensorId;
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

    public Double getNorm() {
        return norm;
    }

    public void setNorm(Double norm) {
        this.norm = norm;
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }
}