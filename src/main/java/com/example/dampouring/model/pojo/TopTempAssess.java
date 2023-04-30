package com.example.dampouring.model.pojo;

public class TopTempAssess {
    private Integer id;
    private Integer itsId;
    private Integer pouringBaseId;
    private Double topAvgTemp;
    private Double topTemp;

    private Double normTemp;

    private Double excessive;

    private String isExcessive;

    private String topTempTime;

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

    public Double getTopTemp() {
        return topTemp;
    }

    public void setTopTemp(Double topTemp) {
        this.topTemp = topTemp;
    }

    public Double getNormTemp() {
        return normTemp;
    }

    public void setNormTemp(Double normTemp) {
        this.normTemp = normTemp;
    }

    public Double getExcessive() {
        return excessive;
    }

    public void setExcessive(Double excessive) {
        this.excessive = excessive;
    }

    public String getIsExcessive() {
        return isExcessive;
    }

    public void setIsExcessive(String isExcessive) {
        this.isExcessive = isExcessive == null ? null : isExcessive.trim();
    }

    public void setTopAvgTemp(Double topAvgTemp) {
        this.topAvgTemp = topAvgTemp;
    }

    public Double getTopAvgTemp() {
        return topAvgTemp;
    }

    public String getTopTempTime() {
        return topTempTime;
    }

    public void setTopTempTime(String topTempTime) {
        this.topTempTime = topTempTime == null ? null : topTempTime.trim();
    }

    public Integer getItsId() {
        return itsId;
    }

    public void setItsId(Integer itsId) {
        this.itsId = itsId;
    }
}