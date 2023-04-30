package com.example.dampouring.model.vo;

public class SwSiloDataVO {
    private Integer id;

    private String pouringTime;

    private Integer matType;

    private Integer sgId;

    private Integer bataId;

    private Double pouringTemp;

    private Double pouringPly;

    private String fgTime;
    private String zlTime;
    private String elTime;
    private String gjTime;

    private Integer lxWkId;

    private String sbNo;

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
        this.pouringTime = pouringTime;
    }

    public String getZlTime() {
        return zlTime;
    }

    public void setZlTime(String zlTime) {
        this.zlTime = zlTime;
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
        this.fgTime = fgTime;
    }

    public String getGjTime() {
        return gjTime;
    }

    public void setGjTime(String gjTime) {
        this.gjTime = gjTime;
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
        this.elTime = elTime;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
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
