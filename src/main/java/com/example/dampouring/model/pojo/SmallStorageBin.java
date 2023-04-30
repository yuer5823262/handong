package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class SmallStorageBin {
    private Integer id;
    @Excel(name = "仓号", width = 20)
    private String smallSbNo;
    @Excel(name = "起始分段", width = 20)
    private String dsStart;
    @Excel(name = "终止分段", width = 20)
    private String dsEnd;
    @Excel(name = "起始高程", width = 20)
    private Double elevationStart;
    @Excel(name = "终止高程", width = 20)
    private Double elevationEnd;
    @Excel(name = "桩号（上）", width = 20)
    private String stakeMarkUp;
    @Excel(name = "桩号（下）", width = 20)
    private String stakeMarkDown;
    @Excel(name = "桩号（左）", width = 20)
    private String stakeMarkLeft;
    @Excel(name = "桩号（右）", width = 20)
    private String stakeMarkRight;

    private String createTime;

    private String isAlert;

    private String isCalculate;

    private String isGetWater;
    private String isComputer;
    private String operator;

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
        this.smallSbNo = smallSbNo == null ? null : smallSbNo.trim();
    }

    public String getDsStart() {
        return dsStart;
    }

    public void setDsStart(String dsStart) {
        this.dsStart = dsStart == null ? null : dsStart.trim();
    }

    public String getDsEnd() {
        return dsEnd;
    }

    public void setDsEnd(String dsEnd) {
        this.dsEnd = dsEnd == null ? null : dsEnd.trim();
    }

    public Double getElevationStart() {
        return elevationStart;
    }

    public void setElevationStart(Double elevationStart) {
        this.elevationStart = elevationStart;
    }

    public Double getElevationEnd() {
        return elevationEnd;
    }

    public void setElevationEnd(Double elevationEnd) {
        this.elevationEnd = elevationEnd;
    }

    public String getStakeMarkUp() {
        return stakeMarkUp;
    }

    public void setStakeMarkUp(String stakeMarkUp) {
        this.stakeMarkUp = stakeMarkUp == null ? null : stakeMarkUp.trim();
    }

    public String getStakeMarkDown() {
        return stakeMarkDown;
    }

    public void setStakeMarkDown(String stakeMarkDown) {
        this.stakeMarkDown = stakeMarkDown == null ? null : stakeMarkDown.trim();
    }

    public String getStakeMarkLeft() {
        return stakeMarkLeft;
    }

    public void setStakeMarkLeft(String stakeMarkLeft) {
        this.stakeMarkLeft = stakeMarkLeft == null ? null : stakeMarkLeft.trim();
    }

    public String getStakeMarkRight() {
        return stakeMarkRight;
    }

    public void setStakeMarkRight(String stakeMarkRight) {
        this.stakeMarkRight = stakeMarkRight == null ? null : stakeMarkRight.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getIsAlert() {
        return isAlert;
    }

    public void setIsAlert(String isAlert) {
        this.isAlert = isAlert == null ? null : isAlert.trim();
    }

    public String getIsCalculate() {
        return isCalculate;
    }

    public void setIsCalculate(String isCalculate) {
        this.isCalculate = isCalculate == null ? null : isCalculate.trim();
    }

    public String getIsGetWater() {
        return isGetWater;
    }

    public void setIsGetWater(String isGetWater) {
        this.isGetWater = isGetWater == null ? null : isGetWater.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getIsComputer() {
        return isComputer;
    }

    public void setIsComputer(String isComputer) {
        this.isComputer = isComputer;
    }
    public void setBigSbNoByDs() {
        if(dsStart.equals(dsEnd))
            this.smallSbNo = dsStart+"#"+"-"+elevationStart;
        else
            this.smallSbNo = dsStart+"-"+dsEnd+"#"+"-"+elevationStart;
    }
}