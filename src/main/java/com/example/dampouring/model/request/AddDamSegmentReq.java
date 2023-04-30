package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddDamSegmentReq {
    @NotNull
    @Size(min=1,max = 20)
    private String dsName;
    @NotNull
    private Integer bsNo;
    @NotNull
    private Double elevationStart;
    @NotNull
    private Double elevationEnd;
    private Double height;
    private Double stakeMarkUp;
    private Double stakeMarkDown;
    private Double stakeMarkLeft;
    private Double stakeMarkRight;

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public Integer getBsNo() {
        return bsNo;
    }

    public void setBsNo(Integer bsNo) {
        this.bsNo = bsNo;
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


    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
