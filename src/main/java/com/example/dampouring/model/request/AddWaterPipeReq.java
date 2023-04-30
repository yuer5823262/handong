package com.example.dampouring.model.request;

public class AddWaterPipeReq {

    private Integer cuId;
    private Integer sbId;
    private String wpNo;

    private String wpType;

    private String waterBeginTime;

    private Integer channelNo;

    private Integer branchNum;

    private Double horizontalSpacing;

    private Double verticalSpacing;

    private Double pipeLen;

    private Double maxFlow;

    private Double waterDensity;

    private Double waterSpecificHeat;

    private Double pipeSpecificHeat;

    private Double outerDiameter;

    private Double innerDiameter;

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
    }

    public String getWpNo() {
        return wpNo;
    }

    public void setWpNo(String wpNo) {
        this.wpNo = wpNo;
    }

    public String getWpType() {
        return wpType;
    }

    public void setWpType(String wpType) {
        this.wpType = wpType;
    }

    public String getWaterBeginTime() {
        return waterBeginTime;
    }

    public void setWaterBeginTime(String waterBeginTime) {
        this.waterBeginTime = waterBeginTime;
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public Integer getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(Integer branchNum) {
        this.branchNum = branchNum;
    }

    public Double getHorizontalSpacing() {
        return horizontalSpacing;
    }

    public void setHorizontalSpacing(Double horizontalSpacing) {
        this.horizontalSpacing = horizontalSpacing;
    }

    public Double getVerticalSpacing() {
        return verticalSpacing;
    }

    public void setVerticalSpacing(Double verticalSpacing) {
        this.verticalSpacing = verticalSpacing;
    }

    public Double getPipeLen() {
        return pipeLen;
    }

    public void setPipeLen(Double pipeLen) {
        this.pipeLen = pipeLen;
    }

    public Double getMaxFlow() {
        return maxFlow;
    }

    public void setMaxFlow(Double maxFlow) {
        this.maxFlow = maxFlow;
    }

    public Double getWaterDensity() {
        return waterDensity;
    }

    public void setWaterDensity(Double waterDensity) {
        this.waterDensity = waterDensity;
    }

    public Double getWaterSpecificHeat() {
        return waterSpecificHeat;
    }

    public void setWaterSpecificHeat(Double waterSpecificHeat) {
        this.waterSpecificHeat = waterSpecificHeat;
    }

    public Double getPipeSpecificHeat() {
        return pipeSpecificHeat;
    }

    public void setPipeSpecificHeat(Double pipeSpecificHeat) {
        this.pipeSpecificHeat = pipeSpecificHeat;
    }

    public Double getOuterDiameter() {
        return outerDiameter;
    }

    public void setOuterDiameter(Double outerDiameter) {
        this.outerDiameter = outerDiameter;
    }

    public Double getInnerDiameter() {
        return innerDiameter;
    }

    public void setInnerDiameter(Double innerDiameter) {
        this.innerDiameter = innerDiameter;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }
}
