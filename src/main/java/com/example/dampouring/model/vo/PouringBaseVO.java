package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class PouringBaseVO {
    private Integer id;
    private Integer smallSbId;
    @Excel(name = "仓号",width = 20)
    private String smallSbNo;
    @Excel(name = "开盘时间",width = 20)
    private String openTime;
    @Excel(name = "收盘时间",width = 20)
    private String closeTime;
    @Excel(name = "覆盖时间",width = 20)
    private String coverTime;
    @Excel(name = "温控曲线号",width = 20)
    private Integer tempControlId;
    @Excel(name = "工程量(m³)",width = 20)
    private Double workAmount;
    @Excel(name = "混凝土标号",width = 20)
    private String markNumber;
    private Integer materialNo;
    @Excel(name = "设计浇筑温度(C°)",width = 20)
    private Double designPouringTemp;
    @Excel(name = "中冷开始时间",width = 20)
    private String interCoolingStartTime;
    @Excel(name = "二冷开始时间",width = 20)
    private String secondCoolingStartTime;
    @Excel(name = "封拱灌浆时间",width = 20)
    private String closureGroutTime;
    @Excel(name = "仓面保温",width = 20)
    private String faceKeepWarm;
    @Excel(name = "浇筑历时(h)",width = 20)
    private Double pouringTime;
    @Excel(name = "浇筑强度(m³/h)",width = 20)
    private Double pouringStrength;
    @Excel(name = "Bata号",width = 20)
    private Integer bataNo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmallSbNo() {
        return smallSbNo;
    }

    public void setSmallSbNo(String smallSbNo) {
        this.smallSbNo = smallSbNo;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getCoverTime() {
        return coverTime;
    }

    public void setCoverTime(String coverTime) {
        this.coverTime = coverTime;
    }

    public Integer getTempControlId() {
        return tempControlId;
    }

    public void setTempControlId(Integer tempControlId) {
        this.tempControlId = tempControlId;
    }

    public Double getWorkAmount() {
        return workAmount;
    }

    public void setWorkAmount(Double workAmount) {
        this.workAmount = workAmount;
    }

    public String getMarkNumber() {
        return markNumber;
    }

    public void setMarkNumber(String markNumber) {
        this.markNumber = markNumber;
    }

    public Integer getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(Integer materialNo) {
        this.materialNo = materialNo;
    }

    public Double getDesignPouringTemp() {
        return designPouringTemp;
    }

    public void setDesignPouringTemp(Double designPouringTemp) {
        this.designPouringTemp = designPouringTemp;
    }

    public String getInterCoolingStartTime() {
        return interCoolingStartTime;
    }

    public void setInterCoolingStartTime(String interCoolingStartTime) {
        this.interCoolingStartTime = interCoolingStartTime;
    }

    public String getSecondCoolingStartTime() {
        return secondCoolingStartTime;
    }

    public void setSecondCoolingStartTime(String secondCoolingStartTime) {
        this.secondCoolingStartTime = secondCoolingStartTime;
    }

    public String getClosureGroutTime() {
        return closureGroutTime;
    }

    public void setClosureGroutTime(String closureGroutTime) {
        this.closureGroutTime = closureGroutTime;
    }

    public String getFaceKeepWarm() {
        return faceKeepWarm;
    }

    public void setFaceKeepWarm(String faceKeepWarm) {
        this.faceKeepWarm = faceKeepWarm;
    }

    public Double getPouringTime() {
        return pouringTime;
    }

    public void setPouringTime(Double pouringTime) {
        this.pouringTime = pouringTime;
    }

    public Double getPouringStrength() {
        return pouringStrength;
    }

    public void setPouringStrength(Double pouringStrength) {
        this.pouringStrength = pouringStrength;
    }

    public Integer getBataNo() {
        return bataNo;
    }

    public void setBataNo(Integer bataNo) {
        this.bataNo = bataNo;
    }

    public Integer getSmallSbId() {
        return smallSbId;
    }

    public void setSmallSbId(Integer smallSbId) {
        this.smallSbId = smallSbId;
    }
}
