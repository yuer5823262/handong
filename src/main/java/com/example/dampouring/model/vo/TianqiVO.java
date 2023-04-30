package com.example.dampouring.model.vo;

public class TianqiVO {
    String id;
    String cityName;
    String cityKey;
    String cityParent;
    String humidity;
    Integer pm25;
    Integer pm10;
    String date;
    Double temperature;
    Double maxTemperature;
    Double minTemperature;
    String week;
    String sunrise;
    String sunset;
    String aqi;
    String quality;
    String windDirection;
    String windForce;
    String type;
    String wcode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    public String getCityParent() {
        return cityParent;
    }

    public void setCityParent(String cityParent) {
        this.cityParent = cityParent;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Integer getPm25() {
        return pm25;
    }

    public void setPm25(Integer pm25) {
        this.pm25 = pm25;
    }

    public Integer getPm10() {
        return pm10;
    }

    public void setPm10(Integer pm10) {
        this.pm10 = pm10;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindForce() {
        return windForce;
    }

    public void setWindForce(String windForce) {
        this.windForce = windForce;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TianqiVO{" +
                "id='" + id + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityKey='" + cityKey + '\'' +
                ", cityParent='" + cityParent + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pm25=" + pm25 +
                ", pm10=" + pm10 +
                ", date='" + date + '\'' +
                ", temperature=" + temperature +
                ", maxTemperature=" + maxTemperature +
                ", minTemperature=" + minTemperature +
                ", week='" + week + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", aqi='" + aqi + '\'' +
                ", quality='" + quality + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", windForce='" + windForce + '\'' +
                ", type='" + type + '\'' +
                ", wcode='" + wcode + '\'' +
                '}';
    }

    public String getWcode() {
        return wcode;
    }

    public void setWcode(String wcode) {
        this.wcode = wcode;
    }
}
