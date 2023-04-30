package com.example.dampouring.model.vo;

public class CalculatingVO {
    String sbNo;
    String wpNo;
    Double enterTemp;
    Double outTemp;
    Double Temp;
    Double flow;
    String qi;


    public String getWpNo() {
        return wpNo;
    }

    public void setWpNo(String wpNo) {
        this.wpNo = wpNo;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public Double getEnterTemp() {
        return enterTemp;
    }

    public void setEnterTemp(Double enterTemp) {
        this.enterTemp = enterTemp;
    }

    public Double getOutTemp() {
        return outTemp;
    }

    public void setOutTemp(Double outTemp) {
        this.outTemp = outTemp;
    }

    public Double getFlow() {
        return flow;
    }

    public void setFlow(Double flow) {
        this.flow = flow;
    }

    public Double getTemp() {
        return Temp;
    }

    public void setTemp(Double temp) {
        Temp = temp;
    }

    public String getQi() {
        return qi;
    }

    public void setQi(String qi) {
        this.qi = qi;
    }
}
