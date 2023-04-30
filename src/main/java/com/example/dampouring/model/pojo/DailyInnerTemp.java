package com.example.dampouring.model.pojo;

public class DailyInnerTemp {
    private Integer id;

    private String time;

    private Integer sbId;

    private Integer age;

    private Double topTemp;

    private Double topNorm;

    private String isFz;

    private String isFg;

    private Double innerTemp;

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
        this.time = time == null ? null : time.trim();
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
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
        this.isFz = isFz == null ? null : isFz.trim();
    }

    public String getIsFg() {
        return isFg;
    }

    public void setIsFg(String isFg) {
        this.isFg = isFg == null ? null : isFg.trim();
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
        this.isCl = isCl == null ? null : isCl.trim();
    }
}