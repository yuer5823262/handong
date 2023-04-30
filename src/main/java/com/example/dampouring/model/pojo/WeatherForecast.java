package com.example.dampouring.model.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class WeatherForecast {
    private Integer id;
    @Excel(name = "第一天", width = 20)
    private String firstDay;
    @Excel(name = "第一天最高", width = 20)
    private Double firstDayHight;
    @Excel(name = "第一天最低", width = 20)
    private Double firstDayLow;
    @Excel(name = "第二天", width = 20)
    private String secondDay;
    @Excel(name = "第二天最高", width = 20)
    private Double secondDayHight;
    @Excel(name = "第二天最底", width = 20)
    private Double secondDayLow;
    @Excel(name = "第三天", width = 20)
    private String thirdDay;
    @Excel(name = "第三天最高", width = 20)
    private Double thirdDayHight;
    @Excel(name = "第三天最低", width = 20)
    private Double thirdDayLow;
    @Excel(name = "气温骤降", width = 20)
    private Double tempDifference;
    @Excel(name = "城市", width = 20)
    private String city;
    private Integer bl;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(String firstDay) {
        this.firstDay = firstDay == null ? null : firstDay.trim();
    }

    public Double getFirstDayHight() {
        return firstDayHight;
    }

    public void setFirstDayHight(Double firstDayHight) {
        this.firstDayHight = firstDayHight;
    }

    public Double getFirstDayLow() {
        return firstDayLow;
    }

    public void setFirstDayLow(Double firstDayLow) {
        this.firstDayLow = firstDayLow;
    }

    public String getSecondDay() {
        return secondDay;
    }

    public void setSecondDay(String secondDay) {
        this.secondDay = secondDay == null ? null : secondDay.trim();
    }

    public Double getSecondDayHight() {
        return secondDayHight;
    }

    public void setSecondDayHight(Double secondDayHight) {
        this.secondDayHight = secondDayHight;
    }

    public Double getSecondDayLow() {
        return secondDayLow;
    }

    public void setSecondDayLow(Double secondDayLow) {
        this.secondDayLow = secondDayLow;
    }

    public String getThirdDay() {
        return thirdDay;
    }

    public void setThirdDay(String thirdDay) {
        this.thirdDay = thirdDay == null ? null : thirdDay.trim();
    }

    public Double getThirdDayHight() {
        return thirdDayHight;
    }

    public void setThirdDayHight(Double thirdDayHight) {
        this.thirdDayHight = thirdDayHight;
    }

    public Double getThirdDayLow() {
        return thirdDayLow;
    }

    public void setThirdDayLow(Double thirdDayLow) {
        this.thirdDayLow = thirdDayLow;
    }

    public Double getTempDifference() {
        return tempDifference;
    }

    public void setTempDifference(Double tempDifference) {
        this.tempDifference = tempDifference;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getBl() {
        return bl;
    }

    public void setBl(Integer bl) {
        this.bl = bl;
    }
}