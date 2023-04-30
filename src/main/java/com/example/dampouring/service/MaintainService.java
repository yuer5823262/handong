package com.example.dampouring.service;

import com.example.dampouring.model.request.AddMaintainReq;
import com.example.dampouring.model.request.UpdateMaintainReq;
import com.example.dampouring.model.vo.MaintainVO;
import com.example.dampouring.query.MaintainQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MaintainService {
    void add(AddMaintainReq addMaintainReq, String userName);

    void update(UpdateMaintainReq updateMaintainReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<MaintainVO> listByIds(Integer[] ids);

    PageInfo selectByQue(MaintainQue maintainQue);

    List<MaintainVO> exportList();
}
