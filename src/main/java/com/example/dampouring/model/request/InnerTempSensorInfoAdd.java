package com.example.dampouring.model.request;

public class InnerTempSensorInfoAdd {
    private Integer innerTempSensorId;
    private Double temp;

    public Integer getInnerTempSensorId() {
        return innerTempSensorId;
    }

    public void setInnerTempSensorId(Integer innerTempSensorId) {
        this.innerTempSensorId = innerTempSensorId;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
