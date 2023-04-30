package com.example.dampouring.model.request;

public class UpdateControlUnitReq {
    private Integer id;

    private String cuAddr;
    private String name;
    private String cuType;
    private Integer cbNo;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCuAddr() {
        return cuAddr;
    }

    public void setCuAddr(String cuAddr) {
        this.cuAddr = cuAddr;
    }

    public String getCuType() {
        return cuType;
    }

    public void setCuType(String cuType) {
        this.cuType = cuType;
    }

    public Integer getCbNo() {
        return cbNo;
    }

    public void setCbNo(Integer cbNo) {
        this.cbNo = cbNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
