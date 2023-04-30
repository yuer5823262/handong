package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.WaterPipeFlowInfoMapper;
import com.example.dampouring.model.dao.waterPipeFlowAssessMapper;
import com.example.dampouring.model.pojo.WaterPipeFlowInfo;
import com.example.dampouring.model.pojo.waterPipeFlowAssess;
import com.example.dampouring.model.vo.WaterPipeFlowAssessVO;
import com.example.dampouring.query.WaterPipeFlowAssessQue;
import com.example.dampouring.service.WaterPipeFlowAssessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterPipeFlowAssessServiceImpl implements WaterPipeFlowAssessService {
    @Autowired
    waterPipeFlowAssessMapper WaterPipeFlowAssessMapper;
    @Autowired
    WaterPipeFlowInfoMapper waterPipeFlowInfoMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WaterPipeFlowAssessVO> WaterPipeFlowAssess = WaterPipeFlowAssessMapper.List();
        PageInfo pageInfo = new PageInfo(WaterPipeFlowAssess);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(WaterPipeFlowAssessQue WaterPipeFlowAssessQue) {
        PageHelper.startPage(WaterPipeFlowAssessQue.getPageNum(), WaterPipeFlowAssessQue.getPageSize());
        List<WaterPipeFlowAssessVO> WaterPipeFlowAssess = WaterPipeFlowAssessMapper.selectList(WaterPipeFlowAssessQue);
        PageInfo pageInfo = new PageInfo(WaterPipeFlowAssess);
        return pageInfo;
    }

    @Override
    public void timingComputing() {
        try {
            WaterPipeFlowAssessQue waterPipeFlowAssessQue = new WaterPipeFlowAssessQue();
            List<waterPipeFlowAssess> waterPipeFlowAssessList = waterPipeFlowInfoMapper.timingComputing();
            for(waterPipeFlowAssess waterPipeFlowAssess:waterPipeFlowAssessList){
                waterPipeFlowAssessQue.setQs(waterPipeFlowAssess.getQi());
                waterPipeFlowAssessQue.setWpId(waterPipeFlowAssess.getWaterPipeId());
                List<WaterPipeFlowAssessVO> waterPipeFlowAssessVO = WaterPipeFlowAssessMapper.selectList(waterPipeFlowAssessQue);
                if(waterPipeFlowAssessVO.size()!=0)
                {
                    waterPipeFlowAssess.setId(waterPipeFlowAssessVO.get(0).getId());
                    WaterPipeFlowAssessMapper.updateByPrimaryKeySelective(waterPipeFlowAssess);

                }
                else
                    WaterPipeFlowAssessMapper.insertSelective(waterPipeFlowAssess);
            }
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }

    }

    @Override
    public List<WaterPipeFlowAssessVO> exportList() {
        List<WaterPipeFlowAssessVO> WaterPipeFlowAssess = WaterPipeFlowAssessMapper.List();
        return WaterPipeFlowAssess;
    }
}
