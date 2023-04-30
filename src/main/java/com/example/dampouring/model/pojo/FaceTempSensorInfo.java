package com.example.dampouring.model.pojo;

public class FaceTempSensorInfo {
    private Integer id;

    private Integer innerTempSensorId;

    private String time;

    private Double avgtemp;

    private Double temp;

    private Double norm;

    private Byte bl;

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

    public Double getAvgtemp() {
        return avgtemp;
    }

    public void setAvgtemp(Double avgtemp) {
        this.avgtemp = avgtemp;
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

    public Byte getBl() {
        return bl;
    }

    public void setBl(Byte bl) {
        this.bl = bl;
    }
}