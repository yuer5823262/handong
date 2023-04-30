package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.TempGradometerInfoMapper;
import com.example.dampouring.model.pojo.TempGradometerInfo;
import com.example.dampouring.model.vo.TempGradometerInfoVO;
import com.example.dampouring.query.TempGradometerInfoQue;
import com.example.dampouring.service.TempGradAlertService;
import com.example.dampouring.service.TempGradometerInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempGradometerInfoServiceImpl implements TempGradometerInfoService {
    @Autowired
    TempGradometerInfoMapper TempGradometerInfoMapper;
    @Autowired
    TempGradAlertService tempGradAlertService;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TempGradometerInfoVO> TempGradometerInfo = TempGradometerInfoMapper.List();
        PageInfo pageInfo = new PageInfo(TempGradometerInfo);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(TempGradometerInfoQue TempGradometerInfoQue) {
        PageHelper.startPage(TempGradometerInfoQue.getPageNum(), TempGradometerInfoQue.getPageSize());
        List<TempGradometerInfoVO> TempGradometerInfo = TempGradometerInfoMapper.selectList(TempGradometerInfoQue);
        PageInfo pageInfo = new PageInfo(TempGradometerInfo);
        return pageInfo;
    }

    @Override
    public List<TempGradometerInfoVO> exportList() {
        List<TempGradometerInfoVO> TempGradometerInfo = TempGradometerInfoMapper.List();

        return TempGradometerInfo;
    }

    @Override
    public void add(TempGradometerInfo tempGradometerInfo) {
        TempGradometerInfoMapper.insertSelective(tempGradometerInfo);
//        tempGradAlertService.TempGradTempAlert(tempGradometerInfo);
    }

    @Override
    public void addAll(List<TempGradometerInfo> list) {
        for(TempGradometerInfo tempGradometerInfo:list)
        {
            TempGradometerInfoMapper.insertSelective(tempGradometerInfo);
        }
    }

    @Override
    public List<TempGradometerInfoVO> exportListByQue(TempGradometerInfoQue tempGradometerInfoQue) {
        return TempGradometerInfoMapper.selectList(tempGradometerInfoQue);
    }

}
