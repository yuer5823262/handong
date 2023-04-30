package com.example.dampouring.model.request;

import javax.validation.constraints.NotNull;

public class UpdateBigStorageBinReq {
    @NotNull
    private Integer id;

    private String dsStart;

    private String dsEnd;

    private Double elevationStart;

    private Double elevationEnd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDsStart() {
        return dsStart;
    }

    public void setDsStart(String dsStart) {
        this.dsStart = dsStart;
    }

    public String getDsEnd() {
        return dsEnd;
    }

    public void setDsEnd(String dsEnd) {
        this.dsEnd = dsEnd;
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
}
