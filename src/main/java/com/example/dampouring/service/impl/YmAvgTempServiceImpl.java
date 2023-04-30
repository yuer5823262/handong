package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.YmAvgTempMapper;
import com.example.dampouring.model.pojo.YmAvgTemp;
import com.example.dampouring.model.request.UpdateYmReq;
import com.example.dampouring.model.vo.MmaTempVO;
import com.example.dampouring.service.YmAvgTempService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YmAvgTempServiceImpl implements YmAvgTempService {
    @Autowired
    YmAvgTempMapper ymAvgTempMapper;
    @Override
    public void update(UpdateYmReq updateBetonReq) {
        YmAvgTemp ymAvgTemp = new YmAvgTemp();
        BeanUtils.copyProperties(updateBetonReq,ymAvgTemp);
        ymAvgTempMapper.updateByPrimaryKeySelective(ymAvgTemp);
    }

    @Override
    public List<YmAvgTemp> orUserList() {
        List<YmAvgTemp> ymAvgTempList= ymAvgTempMapper.list();
        return ymAvgTempList;
    }

    @Override
    public MmaTempVO mmaTemp() {
        MmaTempVO mmaTempVO = ymAvgTempMapper.mmaTemp();
        return mmaTempVO;
    }
}
