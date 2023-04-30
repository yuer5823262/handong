package com.example.dampouring.service;

import com.example.dampouring.model.pojo.TempControlCurveSpecial;
import com.example.dampouring.model.request.AddTempControlCurveSpecialReq;
import com.example.dampouring.model.request.UpdateTempControlCurveSpecialReq;

import java.util.List;

public interface TempControlCurveSpecialService {
    void add(AddTempControlCurveSpecialReq addTempControlCurveSpecialReq, String userName);

    void update(UpdateTempControlCurveSpecialReq updateTempControlCurveSpecialReq);

    void delete(Integer[] ids);


    List<TempControlCurveSpecial> orUserList();

    List<TempControlCurveSpecial> listByIds(Integer[] ids);
}
