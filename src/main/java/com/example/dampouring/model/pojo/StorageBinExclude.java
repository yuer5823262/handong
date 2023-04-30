package com.example.dampouring.model.pojo;

public class StorageBinExclude {
    private Integer id;

    private Integer smallSbId;

    private String time;

    private String remark;

    private String type;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSmallSbId() {
        return smallSbId;
    }

    public void setSmallSbId(Integer smallSbId) {
        this.smallSbId = smallSbId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}