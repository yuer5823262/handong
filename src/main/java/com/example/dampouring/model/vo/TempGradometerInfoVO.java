package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class TempGradometerInfoVO {
    private Integer id;
    @Excel(name = "仓号",width = 20)
    private String smallNo;
    @Excel(name = "控制箱编号",width = 20)
    private String kzxNo;
    @Excel(name = "温度梯度仪器",width = 20)
    private String tempGradometerNo;
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
    @Excel(name = "位置",width = 20)
    private String position;
    @Excel(name = "测控单元地址",width = 20)
    private String cuAddr;
    private Integer bl;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(String smallNo) {
        this.smallNo = smallNo;
    }

    public String getKzxNo() {
        return kzxNo;
    }

    public void setKzxNo(String kzxNo) {
        this.kzxNo = kzxNo;
    }

    public String getTempGradometerNo() {
        return tempGradometerNo;
    }

    public void setTempGradometerNo(String tempGradometerNo) {
        this.tempGradometerNo = tempGradometerNo;
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
        this.time = time;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCuAddr() {
        return cuAddr;
    }

    public void setCuAddr(String cuAddr) {
        this.cuAddr = cuAddr;
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }
}
