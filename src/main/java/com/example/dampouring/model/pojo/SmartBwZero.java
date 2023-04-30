package com.example.dampouring.model.pojo;

public class SmartBwZero {
    private Integer id;

    private String dsName;

    private String time;

    private Integer piles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName == null ? null : dsName.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getPiles() {
        return piles;
    }

    public void setPiles(Integer piles) {
        this.piles = piles;
    }
}