package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.ControlProcessMapper;
import com.example.dampouring.model.pojo.ControlProcess;
import com.example.dampouring.query.ControlProcessQue;
import com.example.dampouring.service.ControlProcessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlProcessServiceImpl implements ControlProcessService {
    @Autowired
    ControlProcessMapper ControlProcessMapper;
    
    @Override
    public PageInfo orUserSelect(ControlProcessQue controlProcessQue) {
        PageHelper.startPage(controlProcessQue.getPageNum(), controlProcessQue.getPageSize());
        List<ControlProcess> ControlProcessVOS = ControlProcessMapper.selectList(controlProcessQue);
        PageInfo pageInfo = new PageInfo(ControlProcessVOS);
        return pageInfo;
    }

    @Override
    public List<ControlProcess> exportList() {
        List<ControlProcess> ControlProcessVOS = ControlProcessMapper.selectList(new ControlProcessQue());
        return ControlProcessVOS;
    }

    @Override
    public List<ControlProcess> exportListByQue(ControlProcessQue controlProcessQue) {
        return ControlProcessMapper.selectList(controlProcessQue);
    }
}
