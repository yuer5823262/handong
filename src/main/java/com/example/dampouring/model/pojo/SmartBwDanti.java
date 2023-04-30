package com.example.dampouring.model.pojo;

public class SmartBwDanti {
    private Integer id;

    private String dsName;

    private Integer gk;

    private String time;

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

    public Integer getGk() {
        return gk;
    }

    public void setGk(Integer gk) {
        this.gk = gk;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}