package com.example.dampouring.service;

import com.example.dampouring.model.pojo.ControlUnit;
import com.example.dampouring.model.request.AddControlUnitReq;
import com.example.dampouring.model.request.UpdateControlUnitReq;
import com.example.dampouring.model.vo.ControlUnitVO;
import com.example.dampouring.query.ControlUnitQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ControlUnitService {
    void add(AddControlUnitReq addControlUnitReq, String userName);

    void update(UpdateControlUnitReq updateControlUnitReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<ControlUnitVO> listByIds(Integer[] ids);

//    List<ControlUnit> listBySmallSbId(Integer[] smallSbNo);

    List<ControlUnitVO> controlUnitState(Integer kzxId);

    List<ControlUnitVO> flowState(Integer sbId);

    PageInfo select(ControlUnitQue controlUnitQue);

    List<ControlUnitVO> exportList();
}
