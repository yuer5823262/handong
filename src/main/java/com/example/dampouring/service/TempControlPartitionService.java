package com.example.dampouring.service;

import com.example.dampouring.model.request.AddTempControlPartitionReq;
import com.example.dampouring.model.request.UpdateTempControlPartitionReq;
import com.example.dampouring.model.vo.TempControlPartitionVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TempControlPartitionService {
    void add(AddTempControlPartitionReq addTempControlPartitionReq, String userName);

    void update(UpdateTempControlPartitionReq updateTempControlPartitionReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<TempControlPartitionVO> listByIds(Integer[] ids);
}
