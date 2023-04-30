package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.SmartHeat3dayMapper;
import com.example.dampouring.model.vo.SmartHeat3dayVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.SmartHeat3dayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartHeat3dayServiceImpl implements SmartHeat3dayService {
    @Autowired
    SmartHeat3dayMapper SmartHeat3dayMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<SmartHeat3dayVO> InboundTempInfo = SmartHeat3dayMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
}
