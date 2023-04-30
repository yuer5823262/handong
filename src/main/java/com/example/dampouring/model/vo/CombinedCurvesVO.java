package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class CombinedCurvesVO {
    @Excel(name = "时间",width = 20)
    String time;
    @Excel(name = "平均内部温度",width = 20)
    Double avgInnerTemp;
    @Excel(name = "平均进水口温度",width = 20)
    Double avgEnterTemp;
    @Excel(name = "平均出水口温度",width = 20)
    Double avgOutTemp;
    @Excel(name = "气温",width = 20)
    Double avgTempMeasurements;
    @Excel(name = "日温差",width = 20)
    Double diffInnerTemp;
    @Excel(name = "平均流量",width = 20)
    Double avgFlow;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getAvgInnerTemp() {
        return avgInnerTemp;
    }

    public void setAvgInnerTemp(Double avgInnerTemp) {
        this.avgInnerTemp = avgInnerTemp;
    }

    public Double getAvgEnterTemp() {
        return avgEnterTemp;
    }

    public void setAvgEnterTemp(Double avgEnterTemp) {
        this.avgEnterTemp = avgEnterTemp;
    }

    public Double getAvgOutTemp() {
        return avgOutTemp;
    }

    public void setAvgOutTemp(Double avgOutTemp) {
        this.avgOutTemp = avgOutTemp;
    }

    public Double getAvgTempMeasurements() {
        return avgTempMeasurements;
    }

    public void setAvgTempMeasurements(Double avgTempMeasurements) {
        this.avgTempMeasurements = avgTempMeasurements;
    }

    public Double getDiffInnerTemp() {
        return diffInnerTemp;
    }

    public void setDiffInnerTemp(Double diffInnerTemp) {
        this.diffInnerTemp = diffInnerTemp;
    }

    public Double getAvgFlow() {
        return avgFlow;
    }

    public void setAvgFlow(Double avgFlow) {
        this.avgFlow = avgFlow;
    }
}
