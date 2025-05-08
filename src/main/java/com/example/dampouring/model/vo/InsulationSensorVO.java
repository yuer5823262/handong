package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class InsulationSensorVO {
    private Integer id;
    @Excel(name="坝段",width = 20)
    private String dsNo;
    @Excel(name="分控站编号",width = 20)
    private String fkzNo;
    @Excel(name="控制箱编号",width = 20)
    private String kzxNo;
    @Excel(name="测控地址",width = 20)
    private String cuAddr;
    @Excel(name="温度计编号",width = 20)
    private String tempNo;
    @Excel(name="温度计地址",width = 20)
    private String addr;
    @Excel(name="通道号",width = 20)
    private Integer chanelNo;
    @Excel(name="通道",width = 20)
    private Integer chanel;
    @Excel(name="埋设位置",width = 20)
    private String position;
    @Excel(name="埋设类型",width = 20)
    private String positionType;

    private String createTime;
    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDsNo() {
        return dsNo;
    }

    public void setDsNo(String dsNo) {
        this.dsNo = dsNo;
    }

    public String getFkzNo() {
        return fkzNo;
    }

    public void setFkzNo(String fkzNo) {
        this.fkzNo = fkzNo;
    }

    public String getKzxNo() {
        return kzxNo;
    }

    public void setKzxNo(String kzxNo) {
        this.kzxNo = kzxNo;
    }

    public String getCuAddr() {
        return cuAddr;
    }

    public void setCuAddr(String cuAddr) {
        this.cuAddr = cuAddr;
    }

    public String getTempNo() {
        return tempNo;
    }

    public void setTempNo(String tempNo) {
        this.tempNo = tempNo;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getChanelNo() {
        return chanelNo;
    }

    public void setChanelNo(Integer chanelNo) {
        this.chanelNo = chanelNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getChanel() {
        return chanel;
    }

    public void setChanel(Integer chanel) {
        this.chanel = chanel;
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

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
}
