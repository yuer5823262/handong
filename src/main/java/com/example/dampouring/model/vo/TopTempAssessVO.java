package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class TopTempAssessVO {
    private Integer id;
    @Excel(name = "仓号",width = 20)
    private String smallNo;
    @Excel(name = "最高温度（℃）",width = 20)
    private Double topTemp;
    @Excel(name = "平均最高温度（℃）",width = 20)
    private Double topAvgTemp;
    @Excel(name = "标准（℃）",width = 20)
    private Double normTemp;
    @Excel(name = "超标量（℃）",width = 20)
    private Double excessive;
    @Excel(name = "是否超标",width = 20)
    private String isExcessive;
    @Excel(name = "最高温度发生时间",width = 20)
    private String topTempTime;

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
        this.isExcessive = isExcessive;
    }

    public String getTopTempTime() {
        return topTempTime;
    }

    public void setTopTempTime(String topTempTime) {
        this.topTempTime = topTempTime;
    }

    public Double getTopAvgTemp() {
        return topAvgTemp;
    }

    public void setTopAvgTemp(Double topAvgTemp) {
        this.topAvgTemp = topAvgTemp;
    }
}
