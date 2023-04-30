package com.example.dampouring.service;

import com.example.dampouring.model.request.AddSbTempNormReq;
import com.example.dampouring.model.request.UpdateSbTempNormReq;
import com.example.dampouring.model.vo.SbTempNormVO;
import com.example.dampouring.query.SbTempNormQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SbTempNormService {
    void update(UpdateSbTempNormReq updateSbTempNormReq);

    PageInfo orUserList(SbTempNormQue sbTempNormQue);

    List<SbTempNormVO> listByIds(Integer[] ids);

    void add(AddSbTempNormReq addSbTempNormReq);

}
