package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class MixingBetonInfo extends MixingTempInfo {
    private Integer id;
    @Excel(name = "拌合楼号",width = 20)
    private String buildingNo;
    @Excel(name = "温度",width = 20)
    private Double temp;
    @Excel(name = "备注",width = 20)
    private String remark;
    @Excel(name = "时间",width = 20)
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo == null ? null : buildingNo.trim();
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}