package com.example.dampouring.model.request;

public class UpdateSwBataReq {
    private Integer id;

    private String time;

    private String srGc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSrGc() {
        return srGc;
    }

    public void setSrGc(String srGc) {
        this.srGc = srGc;
    }
}
