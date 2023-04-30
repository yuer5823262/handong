package com.example.dampouring.model.vo;

import com.example.dampouring.util.TimeUtils;
import org.jsoup.internal.StringUtil;

public class DataCountVO {
    Integer sbId;
    String sbNo;
    String openTime;
    String closeTime;
    Integer countInBound;
    Integer countExport;
    Integer countPouring;
    Integer innerCount;
    Integer gradCount;
    Integer waterCount;
    Integer tmCount;
    Integer sunCount;
    public boolean checkTime()
    {
        if(openTime == null || closeTime == null)
            return true;
        String time = TimeUtils.getNowTime();
        return time.compareTo(openTime) >0 && time.compareTo(closeTime) < 0;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getSbId() {
        return sbId;
    }

    public void setSbId(Integer sbId) {
        this.sbId = sbId;
    }

    public String getSbNo() {
        return sbNo;
    }

    public void setSbNo(String sbNo) {
        this.sbNo = sbNo;
    }

    public Integer getCountInBound() {
        return countInBound;
    }

    public void setCountInBound(Integer countInBound) {
        this.countInBound = countInBound;
    }

    public Integer getCountExport() {
        return countExport;
    }

    public void setCountExport(Integer countExport) {
        this.countExport = countExport;
    }

    public Integer getCountPouring() {
        return countPouring;
    }

    public void setCountPouring(Integer countPouring) {
        this.countPouring = countPouring;
    }

    public Integer getInnerCount() {
        return innerCount;
    }

    public void setInnerCount(Integer innerCount) {
        this.innerCount = innerCount;
    }

    public Integer getGradCount() {
        return gradCount;
    }

    public void setGradCount(Integer gradCount) {
        this.gradCount = gradCount;
    }

    public Integer getWaterCount() {
        return waterCount;
    }

    public void setWaterCount(Integer waterCount) {
        this.waterCount = waterCount;
    }

    public Integer getTmCount() {
        return tmCount;
    }

    public void setTmCount(Integer tmCount) {
        this.tmCount = tmCount;
    }

    public Integer getSunCount() {
        return sunCount;
    }

    public void setSunCount(Integer sunCount) {
        this.sunCount = sunCount;
    }
}
