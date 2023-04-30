package com.example.dampouring.service;

import com.example.dampouring.model.pojo.MaterialsTempInfo;
import com.example.dampouring.model.pojo.MixingTempBc;
import com.example.dampouring.query.MaterialsTempInfoQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MaterialsTempInfoService {
    PageInfo orUserList(Integer pageNum, Integer pageSize);
    PageInfo orUserSelect(MaterialsTempInfoQue MaterialsTempInfoQue);

    List<MaterialsTempInfo> exportList();

    void insert(MixingTempBc mixingTempBc);

    void addAll(List<MaterialsTempInfo> list);

    List<MaterialsTempInfo> exportListByQue(MaterialsTempInfoQue materialsTempInfoQue);
}
