package com.example.dampouring.model.vo;

public class ProcessComplianceVO {
    String typeName;
    Integer violation;
    Integer accountability;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getViolation() {
        return violation;
    }

    public void setViolation(Integer violation) {
        this.violation = violation;
    }

    public Integer getAccountability() {
        return accountability;
    }

    public void setAccountability(Integer accountability) {
        this.accountability = accountability;
    }
}
