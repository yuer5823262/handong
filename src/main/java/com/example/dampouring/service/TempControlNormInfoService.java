package com.example.dampouring.service;

import com.example.dampouring.model.request.AddTempControlNormInfoReq;
import com.example.dampouring.model.request.UpdateTempControlNormInfoReq;
import com.example.dampouring.model.vo.TempControlNormInfoVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TempControlNormInfoService {
    void add(AddTempControlNormInfoReq addTempControlNormInfoReq, String userName);

    void update(UpdateTempControlNormInfoReq updateTempControlNormInfoReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<TempControlNormInfoVO> listByIds(Integer[] ids);
}
