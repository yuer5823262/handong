package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.SmartHeat7dayMapper;
import com.example.dampouring.model.vo.SmartHeat7dayVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.SmartHeat7dayService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartHeat7dayServiceImpl implements SmartHeat7dayService {
    @Autowired
    com.example.dampouring.model.dao.SmartHeat7dayMapper SmartHeat7dayMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<SmartHeat7dayVO> InboundTempInfo = SmartHeat7dayMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
}
