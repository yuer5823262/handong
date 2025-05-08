package com.example.dampouring.model.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class InnerTempSensorInfoEx {
    @Excel(name = "仓号",width = 20)
    String smallNo;
    @Excel(name = "温度计编号",width = 20)
    String tempSensorNo;
    @Excel(name = "时间",width = 20)
    String time;
    @Excel(name = "温度（C°）",width = 20)
    Double temp;

    public String getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(String smallNo) {
        this.smallNo = smallNo;
    }

    public String getTempSensorNo() {
        return tempSensorNo;
    }

    public void setTempSensorNo(String tempSensorNo) {
        this.tempSensorNo = tempSensorNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
