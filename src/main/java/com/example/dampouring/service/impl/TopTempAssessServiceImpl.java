package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.InnerTempSensorInfoMapper;
import com.example.dampouring.model.dao.MaxTempAlertMapper;
import com.example.dampouring.model.dao.TopTempAssessMapper;
import com.example.dampouring.model.pojo.TopTempAssess;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.TopTempAssessVO;
import com.example.dampouring.query.TopTempAssessQue;
import com.example.dampouring.service.TopTempAssessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopTempAssessServiceImpl implements TopTempAssessService {
    @Autowired
    TopTempAssessMapper TopTempAssessMapper;
    @Autowired
    InnerTempSensorInfoMapper innerTempSensorInfoMapper;
    @Autowired
    MaxTempAlertMapper MaxTempAlertMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TopTempAssessVO> TopTempAssess = TopTempAssessMapper.List();
        PageInfo pageInfo = new PageInfo(TopTempAssess);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(TopTempAssessQue TopTempAssessQue) {
        PageHelper.startPage(TopTempAssessQue.getPageNum(), TopTempAssessQue.getPageSize());
        List<TopTempAssessVO> TopTempAssess = TopTempAssessMapper.selectList(TopTempAssessQue);
        PageInfo pageInfo = new PageInfo(TopTempAssess);
        return pageInfo;
    }

    @Override
    public void timingComputing() {
        try {
            TopTempAssessQue topTempAssessQue = new TopTempAssessQue();
            List<TopTempAssess> topTempAssesses = innerTempSensorInfoMapper.timingComputing();
            for (TopTempAssess topTempAssess:topTempAssesses){
                topTempAssessQue.setPbId(topTempAssess.getPouringBaseId());
                List<TopTempAssessVO> topTempAssessVOS = TopTempAssessMapper.selectList(topTempAssessQue);
                if(topTempAssessVOS.size()!=0)
                {
                    topTempAssess.setId(topTempAssessVOS.get(0).getId());
                    TopTempAssessMapper.updateByPrimaryKeySelective(topTempAssess);
                }
                else
                {
                    TopTempAssessMapper.insertSelective(topTempAssess);
                }

            }
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }

    }

    @Override
    public List<TopTempAssessVO> exportList() {
        List<TopTempAssessVO> TopTempAssess = TopTempAssessMapper.List();
        return TopTempAssess;
    }
}
