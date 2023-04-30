package com.example.dampouring.model.pojo;

public class AlertBase {
    private Integer id;

    private String position;

    private String type;

    private Integer typeNo;

    private String content;

    private String time;

    private Integer state;

    private String remark1;

    private String remark2;

    private String remark3;

    private String opTime1;

    private String operator1;

    private String opTime2;

    private String operator2;

    private String opTime3;

    private String operator3;

    private String standby1;

    private String standby2;

    private String standby3;

    private String standby4;

    private String standby5;

    private String standby6;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(Integer typeNo) {
        this.typeNo = typeNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getOpTime1() {
        return opTime1;
    }

    public void setOpTime1(String opTime1) {
        this.opTime1 = opTime1 == null ? null : opTime1.trim();
    }

    public String getOperator1() {
        return operator1;
    }

    public void setOperator1(String operator1) {
        this.operator1 = operator1 == null ? null : operator1.trim();
    }

    public String getOpTime2() {
        return opTime2;
    }

    public void setOpTime2(String opTime2) {
        this.opTime2 = opTime2 == null ? null : opTime2.trim();
    }

    public String getOperator2() {
        return operator2;
    }

    public void setOperator2(String operator2) {
        this.operator2 = operator2 == null ? null : operator2.trim();
    }

    public String getOpTime3() {
        return opTime3;
    }

    public void setOpTime3(String opTime3) {
        this.opTime3 = opTime3 == null ? null : opTime3.trim();
    }

    public String getOperator3() {
        return operator3;
    }

    public void setOperator3(String operator3) {
        this.operator3 = operator3 == null ? null : operator3.trim();
    }

    public String getStandby1() {
        return standby1;
    }

    public void setStandby1(String standby1) {
        this.standby1 = standby1 == null ? null : standby1.trim();
    }

    public String getStandby2() {
        return standby2;
    }

    public void setStandby2(String standby2) {
        this.standby2 = standby2 == null ? null : standby2.trim();
    }

    public String getStandby3() {
        return standby3;
    }

    public void setStandby3(String standby3) {
        this.standby3 = standby3 == null ? null : standby3.trim();
    }

    public String getStandby4() {
        return standby4;
    }

    public void setStandby4(String standby4) {
        this.standby4 = standby4 == null ? null : standby4.trim();
    }

    public String getStandby5() {
        return standby5;
    }

    public void setStandby5(String standby5) {
        this.standby5 = standby5 == null ? null : standby5.trim();
    }

    public String getStandby6() {
        return standby6;
    }

    public void setStandby6(String standby6) {
        this.standby6 = standby6 == null ? null : standby6.trim();
    }


    @Override
    public String toString() {
        String level = "1";
        return "温控"+","+level+","+typeNo+","+position+","+type+","+content.replace(',','，')+","+content.replace(',','，')+","+time;
    }
}