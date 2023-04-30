package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class DailyHeatVO {
    private Integer id;
    @Excel(name = "序号",width = 20)
    private Integer no;
    @Excel(name = "可揭开保温被时间",width = 20)
    private Integer openableTime;
    @Excel(name = "需要保温被厚度",width = 20)
    private Integer thickness;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getOpenableTime() {
        return openableTime;
    }

    public void setOpenableTime(Integer openableTime) {
        this.openableTime = openableTime;
    }

    public Integer getThickness() {
        return thickness;
    }

    public void setThickness(Integer thickness) {
        this.thickness = thickness;
    }
}
