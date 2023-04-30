package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.InWarehouseTempAlertMapper;
import com.example.dampouring.model.dao.InboundTempInfoMapper;
import com.example.dampouring.model.dao.PouringBaseMapper;
import com.example.dampouring.model.dao.SbTempNormMapper;
import com.example.dampouring.model.pojo.*;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.InboundTempAssessQue;
import com.example.dampouring.query.InboundTempInfoQue;
import com.example.dampouring.query.SelectNormQue;
import com.example.dampouring.service.InWarehouseTempAlertService;
import com.example.dampouring.service.InboundTempInfoService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.copyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboundTempInfoServiceImpl implements InboundTempInfoService {
    @Autowired
    InboundTempInfoMapper InboundTempInfoMapper;
    @Autowired
    PouringBaseMapper pouringBaseMapper;
    @Autowired
    InWarehouseTempAlertMapper InWarehouseTempAlertMapper;
    @Autowired
    InWarehouseTempAlertService inWarehouseTempAlertService;
    @Autowired
    SbTempNormMapper sbTempNormMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<InboundTempInfoVO> InboundTempInfo = InboundTempInfoMapper.List();
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(InboundTempInfoQue InboundTempInfoQue) {
        PageHelper.startPage(InboundTempInfoQue.getPageNum(), InboundTempInfoQue.getPageSize());
        List<InboundTempInfoVO> InboundTempInfo = InboundTempInfoMapper.selectList(InboundTempInfoQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }

    @Override
    public void insert(MixingTempBc mixingTempBc) {
        String sbNo = mixingTempBc.getCw();
        try {
            InboundTempInfo inboundTempInfo = new InboundTempInfo();
            inboundTempInfo.setTemperature(mixingTempBc.getClwd().doubleValue());
            inboundTempInfo.setTime(mixingTempBc.getCwsj());
            PouringBaseVO pouringBase = pouringBaseMapper.selectBySbNo(sbNo);
            inboundTempInfo.setPouringBaseId(pouringBase.getId());
            inboundTempInfo.setOperator(mixingTempBc.getUserid().toString());
//            MaxTempNormVO maxTempNormVO = InWarehouseTempAlertMapper.normInfo(inboundTempInfo.getPouringBaseId());
            SelectNormQue selectNormQue = new SelectNormQue();
            selectNormQue.setPbId(inboundTempInfo.getPouringBaseId());
            SbTempNormVO sbTempNormVO = sbTempNormMapper.selectNorm(selectNormQue);

            inboundTempInfo.setNorm(sbTempNormVO.getEntryTemp());
            InboundTempInfoMapper.insertSelective(inboundTempInfo);
            ConnectionUtil.Send(inboundTempInfo.toMqStr(pouringBase));
            if (sbTempNormVO==null) return;
            inWarehouseTempAlertService.inboundTempAlert(inboundTempInfo,sbTempNormVO);

        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
    }

    @Override
    public PageInfo assess(InboundTempAssessQue inboundTempAssessQue) {
        PageHelper.startPage(inboundTempAssessQue.getPageNum(), inboundTempAssessQue.getPageSize());
        List<InboundTempAssessVO> InboundTempAssessVOS = InboundTempInfoMapper.assess(inboundTempAssessQue);
        for(InboundTempAssessVO InboundTempAssessVO: InboundTempAssessVOS)
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

        }
        PageInfo pageInfo = new PageInfo(InboundTempAssessVOS);
        return pageInfo;
    }

    @Override
    public List<InboundTempInfoVO> exportList() {
        List<InboundTempInfoVO> InboundTempInfo = InboundTempInfoMapper.List();
        return InboundTempInfo;
    }

    @Override
    public List<InboundTempMonitorVO> tempMonitor() {
        List<InboundTempMonitorVO> InboundTempInfo = InboundTempInfoMapper.tempMonitor();
        return InboundTempInfo;
    }

    @Override
    public void addAll(List<InboundTempInfoVO> list) {
        for(InboundTempInfoVO inboundTempInfoVO:list)
        {
            InboundTempInfo inboundTempInfo = new InboundTempInfo();
            PouringBaseVO pouringBase = pouringBaseMapper.selectBySbNo(inboundTempInfoVO.getSmallNo());
            copyUtils.copyPropertiesIgnoreNull(inboundTempInfoVO,inboundTempInfo);
            inboundTempInfo.setPouringBaseId(pouringBase.getId());
            InboundTempInfoMapper.insertSelective(inboundTempInfo);
            ConnectionUtil.Send(inboundTempInfo.toMqStr(pouringBase));
        }
    }

    @Override
    public List<InboundTempInfoVO> exportListByque(InboundTempInfoQue inboundTempInfoQue) {
        return InboundTempInfoMapper.selectList(inboundTempInfoQue);
    }
}
