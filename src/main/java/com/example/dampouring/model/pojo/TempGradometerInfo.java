package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TempGradometerInfo {
    private Integer id;
    @Excel(name = "温度梯度仪ID",width = 20)
    private Integer tempGradometerId;
    @Excel(name = "温度1",width = 20)
    private Double temp1;
    @Excel(name = "温度2",width = 20)
    private Double temp2;
    @Excel(name = "温度3",width = 20)
    private Double temp3;
    @Excel(name = "温度4",width = 20)
    private Double temp4;
    @Excel(name = "温度5",width = 20)
    private Double temp5;
    @Excel(name = "温度6",width = 20)
    private Double temp6;
    @Excel(name = "时间",width = 20)
    private String time;
    private Integer bl;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempGradometerId() {
        return tempGradometerId;
    }

    public void setTempGradometerId(Integer tempGradometerId) {
        this.tempGradometerId = tempGradometerId;
    }

    public Double getTemp1() {
        return temp1;
    }

    public void setTemp1(Double temp1) {
        this.temp1 = temp1;
    }

    public Double getTemp2() {
        return temp2;
    }

    public void setTemp2(Double temp2) {
        this.temp2 = temp2;
    }

    public Double getTemp3() {
        return temp3;
    }

    public void setTemp3(Double temp3) {
        this.temp3 = temp3;
    }

    public Double getTemp4() {
        return temp4;
    }

    public void setTemp4(Double temp4) {
        this.temp4 = temp4;
    }

    public Double getTemp5() {
        return temp5;
    }

    public void setTemp5(Double temp5) {
        this.temp5 = temp5;
    }

    public Double getTemp6() {
        return temp6;
    }

    public void setTemp6(Double temp6) {
        this.temp6 = temp6;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
    public Double getMaxTemp(){
        List<Double> tempList = new ArrayList<>();
        if(temp1!=null)
            tempList.add(temp1);
        if(temp2!=null)
            tempList.add(temp2);
        if(temp3!=null)
            tempList.add(temp3);
        if(temp4!=null)
            tempList.add(temp4);
        if(temp5!=null)
            tempList.add(temp5);
        if(temp6!=null)
            tempList.add(temp6);
        Double max = Collections.max(tempList);
        return max;
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }

    public String getTempListStr() {
        String tempListStr = temp1+" "+temp2+" "+temp3+" "
                +temp4+" " +temp5+" "+temp6+" ";
        return tempListStr;
    }
}