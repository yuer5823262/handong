package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class WaterPipeVO {
    private Integer id;
    private Integer cuId;
    private Integer sbId;
    @Excel(name = "仓号",width = 20)
    private String smallNo;
    @Excel(name = "分控站编号",width = 20)
    private String fkzNo;
    @Excel(name = "控制箱编号",width = 20)
    private String kzxNo;
    @Excel(name = "测控地址",width = 20)
    private String cuAddr;
    @Excel(name = "水管编号",width = 20)
    private String wpNo;
    @Excel(name = "类型",width = 20)
    private String wpType;
    @Excel(name = "开始通水时间",width = 20)
    private String waterBeginTime;
    @Excel(name = "通道号",width = 20)
    private Integer channelNo;
    @Excel(name = "支管数量",width = 20)
    private Integer branchNum;
    @Excel(name = "水平间距",width = 20)
    private Double horizontalSpacing;
    @Excel(name = "竖直间距",width = 20)
    private Double verticalSpacing;
    @Excel(name = "管长",width = 20)
    private Double pipeLen;
    @Excel(name = "最大流量",width = 20)
    private Double maxFlow;
    @Excel(name = "水的密度",width = 20)
    private Double waterDensity;
    @Excel(name = "水比热",width = 20)
    private Double waterSpecificHeat;
    @Excel(name = "管材的比热",width = 20)
    private Double pipeSpecificHeat;
    @Excel(name = "管外径",width = 20)
    private Double outerDiameter;
    @Excel(name = "管内径",width = 20)
    private Double innerDiameter;
    private String createTime;

    private String operator;

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCuId() {
        return cuId;
    }

    public void setCuId(Integer cuId) {
        this.cuId = cuId;
    }

    public String getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(String smallNo) {
        this.smallNo = smallNo;
    }

    public String getFkzNo() {
        return fkzNo;
    }

    public void setFkzNo(String fkzNo) {
        this.fkzNo = fkzNo;
    }

    public String getKzxNo() {
        return kzxNo;
    }

    public void setKzxNo(String kzxNo) {
        this.kzxNo = kzxNo;
    }

    public String getCuAddr() {
        return cuAddr;
    }

    public void setCuAddr(String cuAddr) {
        this.cuAddr = cuAddr;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
