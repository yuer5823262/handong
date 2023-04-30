package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.MixingSandAssessMapper;
import com.example.dampouring.model.pojo.MixingSandAssess;
import com.example.dampouring.query.MixingWaterAssessQue;
import com.example.dampouring.service.MixingSandAssessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingSandAssessServiceImpl implements MixingSandAssessService {
    @Autowired
    MixingSandAssessMapper MixingSandAssessMapper;
    @Override
    public PageInfo orUserSelect(MixingWaterAssessQue MixingSandAssessQue) {
        PageHelper.startPage(MixingSandAssessQue.getPageNum(), MixingSandAssessQue.getPageSize());
        List<MixingSandAssess> MixingSandAssesses = MixingSandAssessMapper.selectList(MixingSandAssessQue);
        PageInfo pageInfo = new PageInfo(MixingSandAssesses);
        return pageInfo;
    }

    @Override
    public void timingComputing() {
        List<MixingSandAssess> mixingAssessList= MixingSandAssessMapper.timingComputing();
        MixingWaterAssessQue MixingSandAssessQue = new MixingWaterAssessQue();
        for(MixingSandAssess mixingAssess:mixingAssessList)
        {
            MixingSandAssessQue.setBuildingNo(mixingAssess.getBuildingNo());
            List<MixingSandAssess> ls= MixingSandAssessMapper.selectList(MixingSandAssessQue);
            if(ls.size()!=0)
            {
                mixingAssess.setId(ls.get(0).getId());
                MixingSandAssessMapper.updateByPrimaryKeySelective(mixingAssess);
            }
            else
            {
                MixingSandAssessMapper.insertSelective(mixingAssess);
            }

        }
    }

    @Override
    public List<MixingSandAssess> exportList() {
        List<MixingSandAssess> MixingSandAssesses = MixingSandAssessMapper.selectList(new MixingWaterAssessQue());
        return MixingSandAssesses;
    }
}
