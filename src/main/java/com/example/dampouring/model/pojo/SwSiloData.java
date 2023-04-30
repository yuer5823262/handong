package com.example.dampouring.model.pojo;

public class SwSiloData {
    private Integer id;

    private String pouringTime;

    private Integer matType;

    private Integer sgId;

    private Integer bataId;

    private Double pouringTemp;

    private Double pouringPly;

    private String fgTime;

    private String gjTime;

    private Integer lxWkId;

    private String elTime;

    private Integer smallId;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPouringTime() {
        return pouringTime;
    }

    public void setPouringTime(String pouringTime) {
        this.pouringTime = pouringTime == null ? null : pouringTime.trim();
    }

    public Integer getMatType() {
        return matType;
    }

    public void setMatType(Integer matType) {
        this.matType = matType;
    }

    public Integer getSgId() {
        return sgId;
    }

    public void setSgId(Integer sgId) {
        this.sgId = sgId;
    }

    public Integer getBataId() {
        return bataId;
    }

    public void setBataId(Integer bataId) {
        this.bataId = bataId;
    }

    public Double getPouringTemp() {
        return pouringTemp;
    }

    public void setPouringTemp(Double pouringTemp) {
        this.pouringTemp = pouringTemp;
    }

    public Double getPouringPly() {
        return pouringPly;
    }

    public void setPouringPly(Double pouringPly) {
        this.pouringPly = pouringPly;
    }

    public String getFgTime() {
        return fgTime;
    }

    public void setFgTime(String fgTime) {
        this.fgTime = fgTime == null ? null : fgTime.trim();
    }

    public String getGjTime() {
        return gjTime;
    }

    public void setGjTime(String gjTime) {
        this.gjTime = gjTime == null ? null : gjTime.trim();
    }

    public Integer getLxWkId() {
        return lxWkId;
    }

    public void setLxWkId(Integer lxWkId) {
        this.lxWkId = lxWkId;
    }

    public String getElTime() {
        return elTime;
    }

    public void setElTime(String elTime) {
        this.elTime = elTime == null ? null : elTime.trim();
    }

    public Integer getSmallId() {
        return smallId;
    }

    public void setSmallId(Integer smallId) {
        this.smallId = smallId;
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