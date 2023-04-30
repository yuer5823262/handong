package com.example.dampouring.model.request;

import java.util.List;

public class RemoteDev {
    String device_id;
    Long time;
    Double vol;
    List<RemoteDevData> datas;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public List<RemoteDevData> getDatas() {
        return datas;
    }

    public void setDatas(List<RemoteDevData> datas) {
        this.datas = datas;
    }
}
