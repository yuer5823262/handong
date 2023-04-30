package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class TempGradometerVO {
    private Integer id;
    @Excel(name = "仓号",width = 20)
    private String smallNo;
    @Excel(name = "通道号",width = 20)
    private Integer channelNo;
    private String channel;
    @Excel(name = "分控站编号",width = 20)
    private String fkzNo;
    @Excel(name = "控制箱编号",width = 20)
    private String kzxNo;
    @Excel(name = "测控地址",width = 20)
    private String cuAddr;
    @Excel(name = "名称",width = 20)
    private String tgmName;
    @Excel(name = "地址1",width = 20)
    private String addr1;
    @Excel(name = "地址2",width = 20)
    private String addr2;
    @Excel(name = "地址3",width = 20)
    private String addr3;
    @Excel(name = "地址4",width = 20)
    private String addr4;
    @Excel(name = "地址5",width = 20)
    private String addr5;
    @Excel(name = "地址6",width = 20)
    private String addr6;
    @Excel(name = "长度",width = 20)
    private Double length;
    @Excel(name = "位置",width = 20)
    private String position;
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

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
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

    public String getTgmName() {
        return tgmName;
    }

    public void setTgmName(String tgmName) {
        this.tgmName = tgmName;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3;
    }

    public String getAddr4() {
        return addr4;
    }

    public void setAddr4(String addr4) {
        this.addr4 = addr4;
    }

    public String getAddr5() {
        return addr5;
    }

    public void setAddr5(String addr5) {
        this.addr5 = addr5;
    }

    public String getAddr6() {
        return addr6;
    }

    public void setAddr6(String addr6) {
        this.addr6 = addr6;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public boolean checkChanel()
    {
        String[] cList = channel.split(",");
        for(String s:cList)
        {
            if(!s.equals("-1")) return true;
        }
        return false;
    }
}
