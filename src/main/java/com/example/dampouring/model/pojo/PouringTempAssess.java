package com.example.dampouring.model.pojo;

public class PouringTempAssess {
    private Integer id;

    private Integer pouringBaseId;

    private Double normTemp;

    private Double avgTemp;

    private Double bottomTemp;

    private Double topTemp;

    private Integer recordCount;

    private Integer excessiveCount;

    private Integer excessivePersent;

    private Double topExcessive;

    private Integer topExcessivePersent;

    private Integer month;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getBottomTemp() {
        return bottomTemp;
    }

    public void setBottomTemp(Double bottomTemp) {
        this.bottomTemp = bottomTemp;
    }

    public Double getTopTemp() {
        return topTemp;
    }

    public void setTopTemp(Double topTemp) {
        this.topTemp = topTemp;
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