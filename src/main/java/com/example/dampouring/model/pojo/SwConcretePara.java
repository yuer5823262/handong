package com.example.dampouring.model.pojo;

public class SwConcretePara {
    private Integer id;

    private Double drxs;

    private Double br;

    private Double rl;

    private Double jrwsqxcs;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDrxs() {
        return drxs;
    }

    public void setDrxs(Double drxs) {
        this.drxs = drxs;
    }

    public Double getBr() {
        return br;
    }

    public void setBr(Double br) {
        this.br = br;
    }

    public Double getRl() {
        return rl;
    }

    public void setRl(Double rl) {
        this.rl = rl;
    }

    public Double getJrwsqxcs() {
        return jrwsqxcs;
    }

    public void setJrwsqxcs(Double jrwsqxcs) {
        this.jrwsqxcs = jrwsqxcs;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}