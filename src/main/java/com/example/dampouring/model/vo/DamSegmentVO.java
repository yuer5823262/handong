package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class DamSegmentVO {


    private String dsNo;
    @Excel(name = "坝段名称")
    private String dsName;
    @Excel(name = "所属标段")
    private String bsName;
    @Excel(name = "承建单位")
    private String contractor;
    @Excel(name = "起始高程(m)")
    private Double elevationStart;
    @Excel(name = "终止高程(m)")
    private Double elevationEnd;
    @Excel(name = "坝段高(m)")
    private Double height;
    @Excel(name = "桩号上")
    private Double stakeMarkUp;
    @Excel(name = "桩号下")
    private Double stakeMarkDown;
    @Excel(name = "桩号左")
    private Double stakeMarkLeft;
    @Excel(name = "桩号右")
    private Double stakeMarkRight;

    public String getDsNo() {
        return dsNo;
    }

    public void setDsNo(String dsNo) {
        this.dsNo = dsNo;
    }
    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getBsName() {
        return bsName;
    }

    public void setBsName(String bsName) {
        this.bsName = bsName;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getStakeMarkUp() {
        return stakeMarkUp;
    }

    public void setStakeMarkUp(Double stakeMarkUp) {
        this.stakeMarkUp = stakeMarkUp;
    }

    public Double getStakeMarkDown() {
        return stakeMarkDown;
    }

    public void setStakeMarkDown(Double stakeMarkDown) {
        this.stakeMarkDown = stakeMarkDown;
    }

    public Double getStakeMarkLeft() {
        return stakeMarkLeft;
    }

    public void setStakeMarkLeft(Double stakeMarkLeft) {
        this.stakeMarkLeft = stakeMarkLeft;
    }

    public Double getStakeMarkRight() {
        return stakeMarkRight;
    }

    public void setStakeMarkRight(Double stakeMarkRight) {
        this.stakeMarkRight = stakeMarkRight;
    }




}
