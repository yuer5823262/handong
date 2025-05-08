package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class StorageBinVO {
    private Integer s_id;
    @Excel(name = "仓号", width = 20)
    private String sbNo;
    @Excel(name = "起始坝段", width = 20)
    private String dsStart;
    @Excel(name = "终止坝段", width = 20)
    private String dsEnd;
    @Excel(name = "起始高程", width = 20)
    private Double elevationStart;
    @Excel(name = "终止高程", width = 20)
    private Double elevationEnd;
    @Excel(name = "桩号-上", width = 20)
    private String stakeMarkUp;
    @Excel(name = "桩号-下", width = 20)
    private String stakeMarkDown;
    @Excel(name = "桩号-左", width = 20)
    private String stakeMarkLeft;
    @Excel(name = "桩号-右", width = 20)
    private String stakeMarkRight;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public String getDsStart() {
        return dsStart;
    }

    public void setDsStart(String dsStart) {
        this.dsStart = dsStart;
    }

    public String getDsEnd() {
        return dsEnd;
    }

    public void setDsEnd(String dsEnd) {
        this.dsEnd = dsEnd;
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
        this.stakeMarkUp = stakeMarkUp;
    }

    public String getStakeMarkDown() {
        return stakeMarkDown;
    }

    public void setStakeMarkDown(String stakeMarkDown) {
        this.stakeMarkDown = stakeMarkDown;
    }

    public String getStakeMarkLeft() {
        return stakeMarkLeft;
    }

    public void setStakeMarkLeft(String stakeMarkLeft) {
        this.stakeMarkLeft = stakeMarkLeft;
    }

    public String getStakeMarkRight() {
        return stakeMarkRight;
    }

    public void setStakeMarkRight(String stakeMarkRight) {
        this.stakeMarkRight = stakeMarkRight;
    }
}
