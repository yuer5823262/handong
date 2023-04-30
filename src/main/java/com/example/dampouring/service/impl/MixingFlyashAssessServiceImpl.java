package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.MixingFlyashAssessMapper;
import com.example.dampouring.model.pojo.MixingFlyashAssess;
import com.example.dampouring.model.pojo.MixingFlyashAssess;
import com.example.dampouring.query.MixingFlyashAssessQue;
import com.example.dampouring.query.MixingFlyashAssessQue;
import com.example.dampouring.query.MixingFlyashAssessQue;
import com.example.dampouring.service.MixingFlyashAssessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingFlyashAssessServiceImpl implements MixingFlyashAssessService {
    @Autowired
    MixingFlyashAssessMapper MixingFlyashAssessMapper;
    @Override
    public PageInfo orUserSelect(MixingFlyashAssessQue MixingFlyashAssessQue) {
        PageHelper.startPage(MixingFlyashAssessQue.getPageNum(), MixingFlyashAssessQue.getPageSize());
        List<MixingFlyashAssess> MixingFlyashAssesses = MixingFlyashAssessMapper.selectList(MixingFlyashAssessQue);
        PageInfo pageInfo = new PageInfo(MixingFlyashAssesses);
        return pageInfo;
    }

    @Override
    public void timingComputing() {
        List<MixingFlyashAssess> mixingAssessList= MixingFlyashAssessMapper.timingComputing();
        MixingFlyashAssessQue MixingFlyashAssessQue = new MixingFlyashAssessQue();
        for(MixingFlyashAssess mixingAssess:mixingAssessList)
        {
            MixingFlyashAssessQue.setBuildingNo(mixingAssess.getBuildingNo());
            List<MixingFlyashAssess> ls= MixingFlyashAssessMapper.selectList(MixingFlyashAssessQue);
            if(ls.size()!=0)
            {
                mixingAssess.setId(ls.get(0).getId());
                MixingFlyashAssessMapper.updateByPrimaryKeySelective(mixingAssess);
            }
            else
            {
                MixingFlyashAssessMapper.insertSelective(mixingAssess);
            }

        }
    }

    @Override
    public List<MixingFlyashAssess> exportList() {
        List<MixingFlyashAssess> MixingFlyashAssesses = MixingFlyashAssessMapper.selectList(new MixingFlyashAssessQue());
        return MixingFlyashAssesses;
    }
}
