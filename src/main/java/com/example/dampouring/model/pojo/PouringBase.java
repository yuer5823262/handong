package com.example.dampouring.model.pojo;

import com.example.dampouring.util.TimeUtils;

public class PouringBase {
    private Integer id;

    private Integer smallSbId;

    private String openTime;

    private String closeTime;

    private String coverTime;

    private Integer tempControlId;

    private Double workAmount;

    private Integer betonId;

    private Double designPouringTemp;

    private String interCoolingStartTime;

    private String secondCoolingStartTime;

    private String closureGroutTime;

    private String faceKeepWarm;

    private Double pouringTime;

    private Double pouringStrength;

    private Integer bataNo;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSmallSbId() {
        return smallSbId;
    }

    public void setSmallSbId(Integer smallSbId) {
        this.smallSbId = smallSbId;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime == null ? null : closeTime.trim();
    }

    public String getCoverTime() {
        return coverTime;
    }

    public void setCoverTime(String coverTime) {
        this.coverTime = coverTime == null ? null : coverTime.trim();
    }

    public Integer getTempControlId() {
        return tempControlId;
    }

    public void setTempControlId(Integer tempControlId) {
        this.tempControlId = tempControlId;
    }

    public Double getWorkAmount() {
        return workAmount;
    }

    public void setWorkAmount(Double workAmount) {
        this.workAmount = workAmount;
    }

    public Integer getBetonId() {
        return betonId;
    }

    public void setBetonId(Integer betonId) {
        this.betonId = betonId;
    }

    public Double getDesignPouringTemp() {
        return designPouringTemp;
    }

    public void setDesignPouringTemp(Double designPouringTemp) {
        this.designPouringTemp = designPouringTemp;
    }

    public String getInterCoolingStartTime() {
        return interCoolingStartTime;
    }

    public void setInterCoolingStartTime(String interCoolingStartTime) {
        this.interCoolingStartTime = interCoolingStartTime == null ? null : interCoolingStartTime.trim();
    }

    public String getSecondCoolingStartTime() {
        return secondCoolingStartTime;
    }

    public void setSecondCoolingStartTime(String secondCoolingStartTime) {
        this.secondCoolingStartTime = secondCoolingStartTime == null ? null : secondCoolingStartTime.trim();
    }

    public String getClosureGroutTime() {
        return closureGroutTime;
    }

    public void setClosureGroutTime(String closureGroutTime) {
        this.closureGroutTime = closureGroutTime == null ? null : closureGroutTime.trim();
    }

    public String getFaceKeepWarm() {
        return faceKeepWarm;
    }

    public void setFaceKeepWarm(String faceKeepWarm) {
        this.faceKeepWarm = faceKeepWarm == null ? null : faceKeepWarm.trim();
    }

    public Double getPouringTime() {
        return pouringTime;
    }

    public void setPouringTime(Double pouringTime) {
        this.pouringTime = pouringTime;
    }
    public void setPouringTimeByOCTime() {
        this.pouringTime = TimeUtils.getHourDifferentTime(openTime,closeTime);
    }
    public Double getPouringStrength() {
        return pouringStrength;
    }

    public void setPouringStrength(Double pouringStrength) {
        this.pouringStrength = pouringStrength;
    }
    public void setPouringStrengthBy() {
        this.pouringStrength = workAmount/pouringTime;
    }
    public Integer getBataNo() {
        return bataNo;
    }

    public void setBataNo(Integer bataNo) {
        this.bataNo = bataNo;
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