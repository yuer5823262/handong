package com.example.dampouring.service;

import com.example.dampouring.model.request.AddHeatPreservationReq;
import com.example.dampouring.model.request.UpdateHeatPreservationReq;
import com.example.dampouring.model.vo.HeatPreservationVO;
import com.example.dampouring.query.HeatPreservationQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HeatPreservationService {
    void add(AddHeatPreservationReq addHeatPreservationReq, String userName);

    void update(UpdateHeatPreservationReq updateHeatPreservationReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    PageInfo selectByQue(HeatPreservationQue heatPreservationQue);

    List<HeatPreservationVO> listByIds(Integer[] ids);

    List<HeatPreservationVO> exportList();
}
