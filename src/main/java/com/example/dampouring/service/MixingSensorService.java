package com.example.dampouring.service;

import com.example.dampouring.model.request.AddMixingSensorReq;
import com.example.dampouring.model.request.UpdateMixingSensorReq;
import com.example.dampouring.model.vo.MixingSensorVO;
import com.example.dampouring.query.MixingSensorInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MixingSensorService {
    void add(AddMixingSensorReq addMixingSensorReq, String userName);

    void update(UpdateMixingSensorReq updateMixingSensorReq);

    void delete(Integer[] ids);


    PageInfo orUserList(MixingSensorInfoQue MixingSensorInfoQue);

    List<MixingSensorVO> listByIds(Integer[] ids);

    List<MixingSensorVO> exportList();

    void updateChannelAll();
}
