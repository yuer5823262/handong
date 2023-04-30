package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class DailyPourTempVO {
    private Integer id;

    private Integer sbId;
    @Excel(name = "浇筑单元",width = 20)
    private String sbNo;
    @Excel(name = "巡查时间",width = 20)
    private String time;
    @Excel(name = "环境温度",width = 20)
    private Double temp;
    @Excel(name = "出机口温度",width = 20)
    private Double exTemp;
    @Excel(name = "入仓温度",width = 20)
    private Double inTemp;
    @Excel(name = "浇筑温度",width = 20)
    private Double pourTemp;
    @Excel(name = "运输温升",width = 20)
    private Double transTempUp;
    @Excel(name = "仓面温升",width = 20)
    private Double surfaceTempUp;
    @Excel(name = "是否满足设计要求",width = 20)
    private String isHg;
    @Excel(name = "备注",width = 20)
    private String mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
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

    public Double getExTemp() {
        return exTemp;
    }

    public void setExTemp(Double exTemp) {
        this.exTemp = exTemp;
    }

    public Double getInTemp() {
        return inTemp;
    }

    public void setInTemp(Double inTemp) {
        this.inTemp = inTemp;
    }

    public Double getPourTemp() {
        return pourTemp;
    }

    public void setPourTemp(Double pourTemp) {
        this.pourTemp = pourTemp;
    }

    public Double getTransTempUp() {
        return transTempUp;
    }

    public void setTransTempUp(Double transTempUp) {
        this.transTempUp = transTempUp;
    }

    public Double getSurfaceTempUp() {
        return surfaceTempUp;
    }

    public void setSurfaceTempUp(Double surfaceTempUp) {
        this.surfaceTempUp = surfaceTempUp;
    }

    public String getIsHg() {
        return isHg;
    }

    public void setIsHg(String isHg) {
        this.isHg = isHg;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
