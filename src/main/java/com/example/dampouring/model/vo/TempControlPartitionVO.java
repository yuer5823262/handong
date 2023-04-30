package com.example.dampouring.model.vo;

import io.swagger.models.auth.In;

public class TempControlPartitionVO {
    private Integer id;

    private Integer dsStart;

    private Integer dsEnd;

    private Double elevationStart;

    private Double elevationEnd;

    private String name;

    private String tempControlTypeName;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDsStart() {
        return dsStart;
    }

    public void setDsStart(Integer dsStart) {
        this.dsStart = dsStart;
    }

    public Integer getDsEnd() {
        return dsEnd;
    }

    public void setDsEnd(Integer dsEnd) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTempControlTypeName() {
        return tempControlTypeName;
    }

    public void setTempControlTypeName(String tempControlTypeName) {
        this.tempControlTypeName = tempControlTypeName;
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
