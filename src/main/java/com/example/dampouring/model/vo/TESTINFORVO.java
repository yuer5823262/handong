package com.example.dampouring.model.vo;

import java.text.DecimalFormat;

public class TESTINFORVO {
    String dsNo;
    String eSta;
    String eEnd;
    String pouringTime;
    Integer betonId;
    Double pouringTemp;
    Double innerTemp;
    public boolean checkData()
    {
        if(dsNo==null||eSta==null||eEnd==null||pouringTime==null)
            return true;
        return false;
    }
    public String getDsNo() {
        return dsNo;
    }

    public void setDsNo(String dsNo) {
        this.dsNo = dsNo;
    }

    public String geteSta() {
        return eSta;
    }

    public void seteSta(String eSta) {
        this.eSta = eSta;
    }

    public String geteEnd() {
        return eEnd;
    }

    public void seteEnd(String eEnd) {
        this.eEnd = eEnd;
    }

    public String getPouringTime() {
        return pouringTime;
    }

    public void setPouringTime(String pouringTime) {
        this.pouringTime = pouringTime;
    }

    public Integer getBetonId() {
        return betonId;
    }

    public void setBetonId(Integer betonId) {
        this.betonId = betonId;
    }

    public Double getPouringTemp() {
        return pouringTemp;
    }

    public void setPouringTemp(Double pouringTemp) {
        this.pouringTemp = pouringTemp;
    }

    public Double getInnerTemp() {
        return innerTemp;
    }

    public void setInnerTemp(Double innerTemp) {
        this.innerTemp = innerTemp;
    }
    public String toStr()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        return eSta+" "+eEnd+" "+pouringTime+" "+df.format(pouringTemp)+" "+df.format(innerTemp)+" "+ betonId;
    }
}
