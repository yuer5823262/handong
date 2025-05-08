package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class InnerTempSensorInfoVO {
    Integer id;
    @Excel(name = "仓号",width = 20)
    String smallNo;
    @Excel(name = "温度计编号",width = 20)
    String tempSensorNo;
    @Excel(name = "时间",width = 20)
    String time;
    @Excel(name = "温度(℃)",width = 20)
    Double temp;
    @Excel(name = "标准(℃)",width = 20)
    Double norm;
    @Excel(name = "混凝土标号",width = 20)
    String betonNo;
    @Excel(name = "平均温度(℃)",width = 20)
    Double avgTemp;
    @Excel(name = "备注",width = 20)
    String bz;
    String zhs;
    String zhx;
    String zhz;
    String zhy;
    String mssj;
    private Integer bl;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNorm() {
        return norm;
    }

    public void setNorm(Double norm) {
        this.norm = norm;
    }

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

    public String getBetonNo() {
        return betonNo;
    }

    public void setBetonNo(String betonNo) {
        this.betonNo = betonNo;
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }

    public Double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(Double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public String getZhs() {
        return zhs;
    }

    public void setZhs(String zhs) {
        this.zhs = zhs;
    }

    public String getZhx() {
        return zhx;
    }

    public void setZhx(String zhx) {
        this.zhx = zhx;
    }

    public String getZhz() {
        return zhz;
    }

    public void setZhz(String zhz) {
        this.zhz = zhz;
    }

    public String getZhy() {
        return zhy;
    }

    public void setZhy(String zhy) {
        this.zhy = zhy;
    }

    public String getMssj() {
        return mssj;
    }

    public void setMssj(String mssj) {
        this.mssj = mssj;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String toMqStr() {
        return "内部温度"+","+smallNo+","+tempSensorNo+","+temp+","+time+","+avgTemp+","+betonNo+","+
                zhs+","+zhx+","+zhz+","+zhy+","+mssj;
    }
}
