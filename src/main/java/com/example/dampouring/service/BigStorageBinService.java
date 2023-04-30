package com.example.dampouring.service;

import com.example.dampouring.model.pojo.BigStorageBin;
import com.example.dampouring.model.request.AddBigStorageBinReq;
import com.example.dampouring.model.request.UpdateBigStorageBinReq;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BigStorageBinService {
    void add(AddBigStorageBinReq addBigStorageBinReq, String userName);

    void update(UpdateBigStorageBinReq updateBigStorageBinReq);

    void delete(Integer id);


    PageInfo userVoList(Integer pageNum, Integer pageSize);

    List<BigStorageBin> listByIds(Integer[] ids);
}
