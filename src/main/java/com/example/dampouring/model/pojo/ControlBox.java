package com.example.dampouring.model.pojo;

public class ControlBox {
    private Integer id;

    private String cbNo;

    private Integer scsId;

    private String remark;

    private String createTime;

    private String operator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCbNo() {
        return cbNo;
    }

    public void setCbNo(String cbNo) {
        this.cbNo = cbNo == null ? null : cbNo.trim();
    }

    public Integer getScsId() {
        return scsId;
    }

    public void setScsId(Integer scsId) {
        this.scsId = scsId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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