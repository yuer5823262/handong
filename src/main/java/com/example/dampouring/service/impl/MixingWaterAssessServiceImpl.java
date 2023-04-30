package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.MixingWaterAssessMapper;
import com.example.dampouring.model.dao.MixingWaterAssessMapper;
import com.example.dampouring.model.pojo.MixingBetonAssess;
import com.example.dampouring.model.pojo.MixingWaterAssess;
import com.example.dampouring.model.pojo.MixingWaterAssess;
import com.example.dampouring.query.MixingBetonAssessQue;
import com.example.dampouring.query.MixingWaterAssessQue;
import com.example.dampouring.query.MixingWaterAssessQue;
import com.example.dampouring.service.MixingWaterAssessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingWaterAssessServiceImpl implements MixingWaterAssessService {
    @Autowired
    MixingWaterAssessMapper MixingWaterAssessMapper;
    @Override
    public PageInfo orUserSelect(MixingWaterAssessQue MixingWaterAssessQue) {
        PageHelper.startPage(MixingWaterAssessQue.getPageNum(), MixingWaterAssessQue.getPageSize());
        List<MixingWaterAssess> MixingWaterAssesses = MixingWaterAssessMapper.selectList(MixingWaterAssessQue);
        PageInfo pageInfo = new PageInfo(MixingWaterAssesses);
        return pageInfo;
    }

    @Override
    public void timingComputing() {
        List<MixingWaterAssess> mixingAssessList= MixingWaterAssessMapper.timingComputing();
        MixingWaterAssessQue mixingBetonAssessQue = new MixingWaterAssessQue();
        for(MixingWaterAssess mixingAssess:mixingAssessList)
        {
            mixingBetonAssessQue.setBuildingNo(mixingAssess.getBuildingNo());
            List<MixingWaterAssess> ls= MixingWaterAssessMapper.selectList(mixingBetonAssessQue);
            if(ls.size()!=0)
            {
                mixingAssess.setId(ls.get(0).getId());
                MixingWaterAssessMapper.updateByPrimaryKeySelective(mixingAssess);
            }
            else
            {
                MixingWaterAssessMapper.insertSelective(mixingAssess);
            }

        }
    }

    @Override
    public List<MixingWaterAssess> exportList() {
        List<MixingWaterAssess> MixingWaterAssesses = MixingWaterAssessMapper.selectList(new MixingWaterAssessQue());
        return MixingWaterAssesses;
    }
}
