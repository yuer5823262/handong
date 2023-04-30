package com.example.dampouring.model.pojo;

public class InsulationSensorInfo {
    private Integer id;

    private Integer sensorId;

    private Double temp;

    private String time;

    private Byte bl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Byte getBl() {
        return bl;
    }

    public void setBl(Byte bl) {
        this.bl = bl;
    }
}