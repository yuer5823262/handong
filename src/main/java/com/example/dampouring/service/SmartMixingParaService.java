package com.example.dampouring.service;

import com.example.dampouring.model.pojo.SmartMixingPara;
import com.example.dampouring.model.request.AddSmartMixingParaReq;
import com.example.dampouring.model.request.UpdateSmartMixingParaReq;

import java.util.List;

public interface SmartMixingParaService {
    void add(AddSmartMixingParaReq addSmartMixingParaReq, String userName);

    void update(UpdateSmartMixingParaReq updateSmartMixingParaReq);

    void delete(Integer[] ids);


    List<SmartMixingPara> orUserList();
}
