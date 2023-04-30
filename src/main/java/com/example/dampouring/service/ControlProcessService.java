package com.example.dampouring.service;

import com.example.dampouring.model.pojo.ControlProcess;
import com.example.dampouring.query.ControlProcessQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ControlProcessService {
    PageInfo orUserSelect(ControlProcessQue controlProcessQue);

    List<ControlProcess> exportList();

    List<ControlProcess> exportListByQue(ControlProcessQue controlProcessQue);
}
