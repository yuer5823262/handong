package com.example.dampouring.query;

import java.util.List;

public class DamTempQue {
    String damNo;
    List<String> times;

    public String getDamNo() {
        return damNo;
    }

    public void setDamNo(String damNo) {
        this.damNo = damNo;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }
}
