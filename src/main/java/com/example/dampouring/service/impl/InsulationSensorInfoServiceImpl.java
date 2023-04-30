package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.InsulationSensorInfoMapper;
import com.example.dampouring.model.vo.InsulationSensorInfoVO;
import com.example.dampouring.query.InsulationSensorInfoQue;
import com.example.dampouring.service.InsulationSensorInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsulationSensorInfoServiceImpl implements InsulationSensorInfoService {
    @Autowired
    InsulationSensorInfoMapper InsulationSensorInfoMapper;

    @Override
    public PageInfo orUserSelect(InsulationSensorInfoQue InsulationSensorInfoQue) {
        PageHelper.startPage(InsulationSensorInfoQue.getPageNum(), InsulationSensorInfoQue.getPageSize());
        List<InsulationSensorInfoVO> InsulationSensorInfo = InsulationSensorInfoMapper.selectList(InsulationSensorInfoQue);
        PageInfo pageInfo = new PageInfo(InsulationSensorInfo);
        return pageInfo;
    }

    @Override
    public List<InsulationSensorInfoVO> exportList() {
        List<InsulationSensorInfoVO> InsulationSensorInfo = InsulationSensorInfoMapper.List();

        return InsulationSensorInfo;
    }

    @Override
    public List<InsulationSensorInfoVO> exportListByQue(InsulationSensorInfoQue insulationSensorInfoQue) {
        return InsulationSensorInfoMapper.selectList(insulationSensorInfoQue);
    }
}
