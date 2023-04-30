package com.example.dampouring.model.pojo;

public class SmartBwBwres {
    private Integer id;

    private String dsName;

    private String time;

    private Integer plies;

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

    public Integer getPlies() {
        return plies;
    }

    public void setPlies(Integer plies) {
        this.plies = plies;
    }
}