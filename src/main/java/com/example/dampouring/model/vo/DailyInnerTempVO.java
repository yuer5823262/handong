package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class DailyInnerTempVO {
    private Integer id;
    @Excel(name = "时间",width = 20)
    private String time;

    private Integer sbId;
    @Excel(name = "单元",width = 20)
    private String sbNo;
    @Excel(name = "龄期",width = 20)
    private Integer age;
    @Excel(name = "最高温度",width = 20)
    private Double topTemp;
    @Excel(name = "最高温度标准",width = 20)
    private Double topNorm;
    @Excel(name = "是否达到温度峰值",width = 20)
    private String isFz;
    @Excel(name = "封供状态",width = 20)
    private String isFg;
    @Excel(name = "当前温度",width = 20)
    private Double innerTemp;
    @Excel(name = "超冷情况",width = 20)
    private String isCl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getTopTemp() {
        return topTemp;
    }

    public void setTopTemp(Double topTemp) {
        this.topTemp = topTemp;
    }

    public Double getTopNorm() {
        return topNorm;
    }

    public void setTopNorm(Double topNorm) {
        this.topNorm = topNorm;
    }

    public String getIsFz() {
        return isFz;
    }

    public void setIsFz(String isFz) {
        this.isFz = isFz;
    }

    public String getIsFg() {
        return isFg;
    }

    public void setIsFg(String isFg) {
        this.isFg = isFg;
    }

    public Double getInnerTemp() {
        return innerTemp;
    }

    public void setInnerTemp(Double innerTemp) {
        this.innerTemp = innerTemp;
    }

    public String getIsCl() {
        return isCl;
    }

    public void setIsCl(String isCl) {
        this.isCl = isCl;
    }
}
