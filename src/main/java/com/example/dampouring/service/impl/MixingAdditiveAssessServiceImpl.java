package com.example.dampouring.service.impl;

import com.example.dampouring.model.pojo.MixingAdditiveAssess;
import com.example.dampouring.query.MixingWaterAssessQue;
import com.example.dampouring.service.MixingAdditiveAssessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingAdditiveAssessServiceImpl implements MixingAdditiveAssessService {
    @Autowired
    com.example.dampouring.model.dao.MixingAdditiveAssessMapper MixingAdditiveAssessMapper;
    @Override
    public PageInfo orUserSelect(MixingWaterAssessQue MixingAdditiveAssessQue) {
        PageHelper.startPage(MixingAdditiveAssessQue.getPageNum(), MixingAdditiveAssessQue.getPageSize());
        List<MixingAdditiveAssess> MixingAdditiveAssesses = MixingAdditiveAssessMapper.selectList(MixingAdditiveAssessQue);
        PageInfo pageInfo = new PageInfo(MixingAdditiveAssesses);
        return pageInfo;
    }

    @Override
    public void timingComputing() {
        List<MixingAdditiveAssess> mixingAssessList= MixingAdditiveAssessMapper.timingComputing();
        MixingWaterAssessQue MixingAdditiveAssessQue = new MixingWaterAssessQue();
        for(MixingAdditiveAssess mixingAssess:mixingAssessList)
        {
            MixingAdditiveAssessQue.setBuildingNo(mixingAssess.getBuildingNo());
            List<MixingAdditiveAssess> ls= MixingAdditiveAssessMapper.selectList(MixingAdditiveAssessQue);
            if(ls.size()!=0)
            {
                mixingAssess.setId(ls.get(0).getId());
                MixingAdditiveAssessMapper.updateByPrimaryKeySelective(mixingAssess);
            }
            else
            {
                MixingAdditiveAssessMapper.insertSelective(mixingAssess);
            }

        }
    }

    @Override
    public List<MixingAdditiveAssess> exportList() {
        List<MixingAdditiveAssess> MixingAdditiveAssesses = MixingAdditiveAssessMapper.selectList(new MixingWaterAssessQue());
        return MixingAdditiveAssesses;
    }
}
