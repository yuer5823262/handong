package com.example.dampouring.model.vo;

public class PouringMonitorVO {
    String dsName;
    Double elevationStart;
    Double elevationEnd;
    Double MaxElevationEnd;
    String sbNo;

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public Double getElevationStart() {
        return elevationStart;
    }

    public void setElevationStart(Double elevationStart) {
        this.elevationStart = elevationStart;
    }

    public Double getElevationEnd() {
        return elevationEnd;
    }

    public void setElevationEnd(Double elevationEnd) {
        this.elevationEnd = elevationEnd;
    }

    public Double getMaxElevationEnd() {
        return MaxElevationEnd;
    }

    public void setMaxElevationEnd(Double maxElevationEnd) {
        MaxElevationEnd = maxElevationEnd;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }
}
