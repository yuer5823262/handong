package com.example.dampouring.service;

import com.example.dampouring.model.request.AddStorageBinExcludeReq;
import com.example.dampouring.model.request.UpdateStorageBinExcludeReq;
import com.example.dampouring.model.vo.StorageBinExcludeVO;
import com.example.dampouring.query.StorageBinExcludeQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StorageBinExcludeService {
    void add(AddStorageBinExcludeReq addStorageBinExcludeReq, String userName);

    void update(UpdateStorageBinExcludeReq updateStorageBinExcludeReq);

    void delete(Integer[] ids);


    PageInfo orUserList(StorageBinExcludeQue storageBinExcludeQue);

    List<StorageBinExcludeVO> listByIds(Integer[] ids);
}
