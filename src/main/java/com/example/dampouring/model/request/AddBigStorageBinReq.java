package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;

public class AddBigStorageBinReq {
    @NotNull
    private String dsStart;
    @NotNull
    private String dsEnd;
    @NotNull
    private Double elevationStart;
    @NotNull
    private Double elevationEnd;

    private String stakeMarkUp;

    private String stakeMarkDown;

    private String stakeMarkLeft;

    private String stakeMarkRight;

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
