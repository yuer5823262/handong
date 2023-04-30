package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.dampouring.util.TimeUtils;

public class HeatPreservationVO {
    private Integer id;
    @Excel(name = "仓号",width = 20)
    private String smallNo;
    @Excel(name = "开始时间",width = 20)
    private String warmStartTime;
    @Excel(name = "结束时间",width = 20)
    private String warmEndTime;
    @Excel(name = "揭露开始时间",width = 20)
    private String exposeStartTime;
    @Excel(name = "揭露结束时间",width = 20)
    private String exposeEndTime;
    @Excel(name = "保温部位",width = 20)
    private String position;
    @Excel(name = "孬闻材料",width = 20)
    private String materials;
    @Excel(name = "保温层厚度",width = 20)
    private Integer thickness;
    @Excel(name = "备注",width = 20)
    private String remark;
    @Excel(name = "保温间隔",width = 20)
    private Integer warmInterval;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(String smallNo) {
        this.smallNo = smallNo;
    }

    public String getWarmStartTime() {
        return warmStartTime;
    }

    public void setWarmStartTime(String warmStartTime) {
        this.warmStartTime = warmStartTime;
    }

    public String getWarmEndTime() {
        return warmEndTime;
    }

    public void setWarmEndTime(String warmEndTime) {
        this.warmEndTime = warmEndTime;
    }

    public String getExposeStartTime() {
        return exposeStartTime;
    }

    public void setExposeStartTime(String exposeStartTime) {
        this.exposeStartTime = exposeStartTime;
    }

    public String getExposeEndTime() {
        return exposeEndTime;
    }

    public void setExposeEndTime(String exposeEndTime) {
        this.exposeEndTime = exposeEndTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public Integer getThickness() {
        return thickness;
    }

    public void setThickness(Integer thickness) {
        this.thickness = thickness;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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


    public Integer getWarmInterval() {
        return warmInterval;
    }

    public void setWarmInterval(Integer warmInterval) {
        this.warmInterval = warmInterval;
    }
    public void setWarmIntervalByWarmTime() {
        this.warmInterval = (int) TimeUtils.getHourDifferentTime(warmStartTime,warmEndTime);
    }
}
