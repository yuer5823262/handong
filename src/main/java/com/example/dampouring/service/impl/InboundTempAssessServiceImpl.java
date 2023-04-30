package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.InboundTempAssessMapper;
import com.example.dampouring.model.dao.InboundTempInfoMapper;
import com.example.dampouring.model.pojo.InboundTempAssess;
import com.example.dampouring.model.vo.ExportMachineTempAssessVO;
import com.example.dampouring.model.vo.InboundTempAssessVO;
import com.example.dampouring.query.ExportMachineTempAssessQue;
import com.example.dampouring.query.InboundTempAssessQue;
import com.example.dampouring.service.InboundTempAssessService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboundTempAssessServiceImpl implements InboundTempAssessService {
    @Autowired
    InboundTempAssessMapper InboundTempAssessMapper;
    @Autowired
    InboundTempInfoMapper inboundTempInfoMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<InboundTempAssessVO> InboundTempAssess = InboundTempAssessMapper.List();
        PageInfo pageInfo = new PageInfo(InboundTempAssess);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(InboundTempAssessQue InboundTempAssessQue) {
        PageHelper.startPage(InboundTempAssessQue.getPageNum(), InboundTempAssessQue.getPageSize());
        List<InboundTempAssessVO> InboundTempAssess = InboundTempAssessMapper.selectList(InboundTempAssessQue);
        PageInfo pageInfo = new PageInfo(InboundTempAssess);
        return pageInfo;
    }

    @Override
    public void timingComputing() {
        try {
            List<InboundTempAssess> inboundTempAssessList = inboundTempInfoMapper.timingComputing();
            InboundTempAssessQue inboundTempAssessQue = new InboundTempAssessQue();
            for(InboundTempAssess InboundTempAssessVO: inboundTempAssessList)
            {
                InboundTempAssessVO.setExcessivePersent(
                        InboundTempAssessVO.getExcessiveCount()*100/InboundTempAssessVO.getRecordCount());
                Double TopExcessive = InboundTempAssessVO.getTopTemp()-InboundTempAssessVO.getNormTemp();
                InboundTempAssessVO.setTopExcessive(0.0);
                InboundTempAssessVO.setTopExcessivePersent(0);
                if(TopExcessive>0) {
                    InboundTempAssessVO.setTopExcessive(TopExcessive);
                    InboundTempAssessVO.setTopExcessivePersent((int) (TopExcessive*100/InboundTempAssessVO.getNormTemp()));
                }
                inboundTempAssessQue.setPbId(InboundTempAssessVO.getPouringBaseId());
                List<InboundTempAssessVO> inboundTempAssess = InboundTempAssessMapper.selectList(inboundTempAssessQue);
                if(inboundTempAssess.size()!=0)
                {
                    InboundTempAssessVO.setId(inboundTempAssess.get(0).getId());
                    InboundTempAssessMapper.updateByPrimaryKey(InboundTempAssessVO);
                }
                else
                {
                    InboundTempAssessMapper.insertSelective(InboundTempAssessVO);
                }
            }
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
    }

    @Override
    public List<InboundTempAssessVO> exportList() {
        List<InboundTempAssessVO> InboundTempAssess = InboundTempAssessMapper.List();
        return InboundTempAssess;
    }
}
