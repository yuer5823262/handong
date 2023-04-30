package com.example.dampouring.model.vo;

public class PouringTempMonitorVO {
    String smallNo;
    Double temp;
    Double norm;
    String time;
    String isCb;
    Double pc; //浇筑胚层
    public void setIsCbByNorm()
    {
        if(!temp.isNaN()&&!norm.isNaN()){
            if(temp>norm) this.isCb = "是";
            else this.isCb = "否";
        }

    }

    public String getSmallNo() {
        return smallNo;
    }

    public void setSmallNo(String smallNo) {
        this.smallNo = smallNo;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getNorm() {
        return norm;
    }

    public void setNorm(Double norm) {
        this.norm = norm;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIsCb() {
        return isCb;
    }

    public void setIsCb(String isCb) {
        this.isCb = isCb;
    }

    public Double getPc() {
        return pc;
    }

    public void setPc(Double pc) {
        this.pc = pc;
    }
}
