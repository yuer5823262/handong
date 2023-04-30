package com.example.dampouring.model.vo;

public class BwTempVO {
    String sbNo;
    Integer dsNo;
    String elevationStart;
    String elevationEnd;
    Double pouringTime;
    Double pouringTemp;
    Double innerTemp;
    public String toStr()
    {
        if(innerTemp==null) innerTemp=-9999.;
        if(pouringTime==null) pouringTime=-9999.;
        if(pouringTemp==null) pouringTemp=-9999.;
        if(innerTemp==null) innerTemp=-9999.;
        return sbNo+" "+elevationStart+" "+elevationEnd+" "+pouringTime.intValue()+" "+
                pouringTemp+" "+innerTemp;
    }
    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public Integer getDsNo() {
        return dsNo;
    }

    public void setDsNo(Integer dsNo) {
        this.dsNo = dsNo;
    }

    public String getElevationStart() {
        return elevationStart;
    }

    public void setElevationStart(String elevationStart) {
        this.elevationStart = elevationStart;
    }

    public String getElevationEnd() {
        return elevationEnd;
    }

    public void setElevationEnd(String elevationEnd) {
        this.elevationEnd = elevationEnd;
    }

    public Double getPouringTime() {
        return pouringTime;
    }

    public void setPouringTime(Double pouringTime) {
        this.pouringTime = pouringTime;
    }

    public Double getPouringTemp() {
        return pouringTemp;
    }

    public void setPouringTemp(Double pouringTemp) {
        this.pouringTemp = pouringTemp;
    }

    public Double getInnerTemp() {
        return innerTemp;
    }

    public void setInnerTemp(Double innerTemp) {
        this.innerTemp = innerTemp;
    }
}
