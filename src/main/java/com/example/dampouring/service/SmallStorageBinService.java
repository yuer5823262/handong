package com.example.dampouring.service;

import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.request.AddSmallStorageBinReq;
import com.example.dampouring.model.request.UpdateSmallStorageBinReq;
import com.example.dampouring.query.StorageBinQue;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmallStorageBinService {
    void add(AddSmallStorageBinReq addSmallStorageBinReq, String userName);

    void update(UpdateSmallStorageBinReq updateSmallStorageBinReq);

    void delete(@Param("ids") Integer[] ids);

    PageInfo userVoList(Integer pageNum, Integer pageSize);
    List<SmallStorageBin> exportList();
    List<SmallStorageBin> listByIds(@Param("ids") Integer[] ids);

    SmallStorageBin listBybNo(String sbNo);

    PageInfo userVoListQue(StorageBinQue storageBinQue);
}
