package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class PouringTempAssessVO {
    private Integer id;

    @Excel(name = "仓号",width = 20)
    private String smallNo;

    private Integer pouringBaseId;
    @Excel(name = "温度标准(℃)",width = 20)
    private Double normTemp;
    @Excel(name = "平均温度(℃)",width = 20)
    private Double avgTemp;
    @Excel(name = "最高温度(℃)",width = 20)
    private Double topTemp;
    @Excel(name = "最低温度(℃)",width = 20)
    private Double bottomTemp;
    @Excel(name = "测量总数",width = 20)
    private Integer recordCount;
    @Excel(name = "超标次数",width = 20)
    private Integer excessiveCount;
    @Excel(name = "超标率(%)",width = 20)
    private Integer excessivePersent;
    @Excel(name = "最大超标量",width = 20)
    private Double topExcessive;
    @Excel(name = "最大超标率(%)",width = 20)
    private Integer topExcessivePersent;

    private Integer month;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(String smallNo) {
        this.smallNo = smallNo;
    }

    public Integer getPouringBaseId() {
        return pouringBaseId;
    }

    public void setPouringBaseId(Integer pouringBaseId) {
        this.pouringBaseId = pouringBaseId;
    }

    public Double getNormTemp() {
        return normTemp;
    }

    public void setNormTemp(Double normTemp) {
        this.normTemp = normTemp;
    }

    public Double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(Double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public Double getTopTemp() {
        return topTemp;
    }

    public void setTopTemp(Double topTemp) {
        this.topTemp = topTemp;
    }

    public Double getBottomTemp() {
        return bottomTemp;
    }

    public void setBottomTemp(Double bottomTemp) {
        this.bottomTemp = bottomTemp;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public Integer getExcessiveCount() {
        return excessiveCount;
    }

    public void setExcessiveCount(Integer excessiveCount) {
        this.excessiveCount = excessiveCount;
    }

    public Integer getExcessivePersent() {
        return excessivePersent;
    }

    public void setExcessivePersent(Integer excessivePersent) {
        this.excessivePersent = excessivePersent;
    }

    public Double getTopExcessive() {
        return topExcessive;
    }

    public void setTopExcessive(Double topExcessive) {
        this.topExcessive = topExcessive;
    }

    public Integer getTopExcessivePersent() {
        return topExcessivePersent;
    }

    public void setTopExcessivePersent(Integer topExcessivePersent) {
        this.topExcessivePersent = topExcessivePersent;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
