package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.example.dampouring.util.TimeUtils;

public class MaintainVO {
    private Integer id;
    @Excel(name = "仓号",width = 20)
    private String smallNo;
    @Excel(name = "开始时间",width = 20)
    private String startTime;
    @Excel(name = "结束时间",width = 20)
    private String endTime;
    @Excel(name = "位置",width = 20)
    private String position;
    @Excel(name = "类型",width = 20)
    private String type;
    @Excel(name = "间隔时间",width = 20)
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setWarmIntervalByWarmTime() {
        this.warmInterval = (int) TimeUtils.getHourDifferentTime(startTime,endTime);
    }

    public Integer getWarmInterval() {
        return warmInterval;
    }

    public void setWarmInterval(Integer warmInterval) {
        this.warmInterval = warmInterval;
    }
}
