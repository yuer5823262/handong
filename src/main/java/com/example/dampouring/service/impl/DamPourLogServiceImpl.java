package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.DamPourLogMapper;
import com.example.dampouring.model.pojo.DamPourLog;
import com.example.dampouring.query.DamPourLogQue;
import com.example.dampouring.service.DamPourLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamPourLogServiceImpl implements DamPourLogService {

    @Autowired
    DamPourLogMapper DamPourLogMapper;
    
    @Override
    public PageInfo orUserList(DamPourLogQue damPourLogQue) {
        PageHelper.startPage(damPourLogQue.getPageNum(), damPourLogQue.getPageSize());
        List<DamPourLog> DamPourLogList = DamPourLogMapper.selectList(damPourLogQue);
        PageInfo pageInfo = new PageInfo(DamPourLogList);
        return pageInfo;
    }
}
