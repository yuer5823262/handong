package com.example.dampouring.model.pojo;

public class BigStorageBin {
    private Integer id;

    private String bigSbNo;

    private String dsStart;

    private String dsEnd;

    private Double elevationStart;

    private Double elevationEnd;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBigSbNo() {
        return bigSbNo;
    }

    public void setBigSbNoByDs() {
        this.bigSbNo = dsStart+"-"+dsEnd+"#"+"-"+elevationStart;
    }

    public String getDsStart() {
        return dsStart;
    }

    public void setDsStart(String dsStart) {
        this.dsStart = dsStart == null ? null : dsStart.trim();
    }

    public String getDsEnd() {
        return dsEnd;
    }

    public void setDsEnd(String dsEnd) {
        this.dsEnd = dsEnd == null ? null : dsEnd.trim();
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

    public void setBigSbNo(String bigSbNo) {
        this.bigSbNo = bigSbNo;
    }
}