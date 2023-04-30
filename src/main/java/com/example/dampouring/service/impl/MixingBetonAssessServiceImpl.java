package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.ExportMachineTempAssessMapper;
import com.example.dampouring.model.dao.MixingBetonAssessMapper;
import com.example.dampouring.model.pojo.MixingBetonAssess;
import com.example.dampouring.model.vo.ExportMachineTempAssessVO;
import com.example.dampouring.query.MixingBetonAssessQue;
import com.example.dampouring.service.MixingBetonAssessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingBetonAssessServiceImpl implements MixingBetonAssessService {
    @Autowired
    MixingBetonAssessMapper mixingBetonAssessMapper;
    @Override
    public PageInfo orUserSelect(MixingBetonAssessQue mixingBetonAssessQue) {
        PageHelper.startPage(mixingBetonAssessQue.getPageNum(), mixingBetonAssessQue.getPageSize());
        List<MixingBetonAssess> mixingBetonAssesses = mixingBetonAssessMapper.selectList(mixingBetonAssessQue);
        PageInfo pageInfo = new PageInfo(mixingBetonAssesses);
        return pageInfo;
    }

    @Override
    public void timingComputing() {
        List<MixingBetonAssess> mixingAssessList= mixingBetonAssessMapper.timingComputing();
        MixingBetonAssessQue mixingBetonAssessQue = new MixingBetonAssessQue();
        for(MixingBetonAssess mixingAssess:mixingAssessList)
        {
            mixingBetonAssessQue.setBuildingNo(mixingAssess.getBuildingNo());
            List<MixingBetonAssess> ls= mixingBetonAssessMapper.selectList(mixingBetonAssessQue);
            if(ls.size()!=0)
            {
                mixingAssess.setId(ls.get(0).getId());
                mixingBetonAssessMapper.updateByPrimaryKeySelective(mixingAssess);
            }
            else
            {
                mixingBetonAssessMapper.insertSelective(mixingAssess);
            }

        }
    }

    @Override
    public List<MixingBetonAssess> exportList() {
        List<MixingBetonAssess> mixingBetonAssesses = mixingBetonAssessMapper.selectList(new MixingBetonAssessQue());
        return mixingBetonAssesses;
    }
}
