package com.example.dampouring.model.pojo;

public class DamSegment {
    private Integer dsNo;

    private String dsName;

    private Integer bsNo;

    private Double elevationStart;

    private Double elevationEnd;

    private Double height;

    private Double stakeMarkUp;

    private Double stakeMarkDown;

    private Double stakeMarkLeft;

    private Double stakeMarkRight;

    private String createTime;

    private String operator;

    public Integer getDsNo() {
        return dsNo;
    }

    public void setDsNo(Integer dsNo) {
        this.dsNo = dsNo;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName == null ? null : dsName.trim();
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}