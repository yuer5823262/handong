package com.example.dampouring.service;

import com.example.dampouring.model.pojo.Beton;
import com.example.dampouring.model.pojo.YmAvgTemp;
import com.example.dampouring.model.request.UpdateYmReq;
import com.example.dampouring.model.vo.MmaTempVO;

import java.util.List;

public interface YmAvgTempService {
    void update(UpdateYmReq updateBetonReq);

    List<YmAvgTemp> orUserList();

    MmaTempVO mmaTemp();
}
