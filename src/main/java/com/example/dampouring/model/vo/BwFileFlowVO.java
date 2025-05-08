package com.example.dampouring.model.vo;

public class BwFileFlowVO {
    Integer dsNo;
    String time;
    Integer sbId;
    Double temp;
    Double flow;

    public Integer getDsNo() {
        return dsNo;
    }

    public void setDsNo(Integer dsNo) {
        this.dsNo = dsNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }
}
