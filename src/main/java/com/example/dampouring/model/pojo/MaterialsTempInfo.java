package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class MaterialsTempInfo {
    private Integer id;
    @Excel(name = "检测位置",width = 20)
    private String position;
    @Excel(name = "时间",width = 20)
    private String time;
    @Excel(name = "冷却类型",width = 20)
    private String type;
    @Excel(name = "骨料类型",width = 20)
    private String materials;
    @Excel(name = "骨料温度（℃）",width = 20)
    private Double temperature;
    @Excel(name = "操作人",width = 20)
    private String operator;
    private Integer bl;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials == null ? null : materials.trim();
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

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }

    public String toMqStr() {
        return "骨料温度"+","+position+","+materials+","+time+","+temperature;
    }
}
