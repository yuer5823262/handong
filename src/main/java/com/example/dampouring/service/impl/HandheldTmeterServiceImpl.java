package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.FaceDiapauseAlertMapper;
import com.example.dampouring.model.dao.HandheldTmeterMapper;
import com.example.dampouring.model.vo.FaceDiapauseAlertVO;
import com.example.dampouring.model.vo.HandheldTmeterVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.HandheldTmeterQue;
import com.example.dampouring.service.HandheldTmeterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandheldTmeterServiceImpl implements HandheldTmeterService {
    @Autowired
    HandheldTmeterMapper handheldTmeterMapper;
    @Override
    public PageInfo orUserSelect(HandheldTmeterQue handheldTmeterQue) {
        PageHelper.startPage(handheldTmeterQue.getPageNum(), handheldTmeterQue.getPageSize());
        List<HandheldTmeterVO> handheldTmeterVOS = handheldTmeterMapper.selectList(handheldTmeterQue);
        PageInfo pageInfo = new PageInfo(handheldTmeterVOS);
        return pageInfo;
    }
}
