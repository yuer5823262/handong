package com.example.dampouring.model.pojo;

import com.example.dampouring.model.vo.PouringBaseVO;

public class ExportMachineTempInfo {
    private Integer id;

    private Integer pouringBaseId;

    private String time;

    private String position;

    private Double temperature;

    private Double norm;

    private String operator;
    private Integer bl;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPouringBaseId() {
        return pouringBaseId;
    }

    public void setPouringBaseId(Integer pouringBaseId) {
        this.pouringBaseId = pouringBaseId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Double getNorm() {
        return norm;
    }

    public void setNorm(Double norm) {
        this.norm = norm;
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }

    public String toMqStr(PouringBaseVO pouringBase) {
        String iscb="否";
        if(temperature>=norm)
            iscb="是";
        return "出机口温度"+","+position+","+time+","+temperature+","+norm+","+iscb+","+pouringBase.getMarkNumber();

    }
}