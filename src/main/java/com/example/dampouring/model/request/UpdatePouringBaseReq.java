package com.example.dampouring.model.request;

public class UpdatePouringBaseReq {
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getCoverTime() {
        return coverTime;
    }

    public void setCoverTime(String coverTime) {
        this.coverTime = coverTime;
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
        this.interCoolingStartTime = interCoolingStartTime;
    }

    public String getSecondCoolingStartTime() {
        return secondCoolingStartTime;
    }

    public void setSecondCoolingStartTime(String secondCoolingStartTime) {
        this.secondCoolingStartTime = secondCoolingStartTime;
    }

    public String getClosureGroutTime() {
        return closureGroutTime;
    }

    public void setClosureGroutTime(String closureGroutTime) {
        this.closureGroutTime = closureGroutTime;
    }

    public String getFaceKeepWarm() {
        return faceKeepWarm;
    }

    public void setFaceKeepWarm(String faceKeepWarm) {
        this.faceKeepWarm = faceKeepWarm;
    }
}
