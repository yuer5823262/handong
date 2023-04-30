package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.PouringBaseMapper;
import com.example.dampouring.model.dao.PouringTempAlertMapper;
import com.example.dampouring.model.dao.PouringTempInfoMapper;
import com.example.dampouring.model.dao.SbTempNormMapper;
import com.example.dampouring.model.pojo.ExportMachineTempInfo;
import com.example.dampouring.model.pojo.MixingTempBc;
import com.example.dampouring.model.pojo.PouringBase;
import com.example.dampouring.model.pojo.PouringTempInfo;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.PouringTempAssessQue;
import com.example.dampouring.query.PouringTempInfoQue;
import com.example.dampouring.query.SelectNormQue;
import com.example.dampouring.service.PouringTempAlertService;
import com.example.dampouring.service.PouringTempInfoService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.copyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PouringTempInfoServiceImpl implements PouringTempInfoService {
    @Autowired
    PouringTempInfoMapper PouringTempInfoMapper;
    @Autowired
    PouringBaseMapper pouringBaseMapper;
    @Autowired
    PouringTempAlertService pouringTempAlertService;
    @Autowired
    PouringTempAlertMapper pouringTempAlertMapper;
    @Autowired
    SbTempNormMapper sbTempNormMapper;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PouringTempInfoVO> PouringTempInfo = PouringTempInfoMapper.List();
        PageInfo pageInfo = new PageInfo(PouringTempInfo);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(PouringTempInfoQue PouringTempInfoQue) {
        PageHelper.startPage(PouringTempInfoQue.getPageNum(), PouringTempInfoQue.getPageSize());
        List<PouringTempInfoVO> PouringTempInfo = PouringTempInfoMapper.selectList(PouringTempInfoQue);
        PageInfo pageInfo = new PageInfo(PouringTempInfo);
        return pageInfo;
    }

    @Override
    public PageInfo assess(PouringTempAssessQue pouringTempAssessQue) {
        PageHelper.startPage(pouringTempAssessQue.getPageNum(), pouringTempAssessQue.getPageSize());
        List<PouringTempAssessVO> PouringTempAssessVOS = PouringTempInfoMapper.assess(pouringTempAssessQue);
        for(PouringTempAssessVO PouringTempAssessVO: PouringTempAssessVOS)
        {
            PouringTempAssessVO.setExcessivePersent(
                    PouringTempAssessVO.getExcessiveCount()*100/PouringTempAssessVO.getRecordCount());
            Double TopExcessive = PouringTempAssessVO.getTopTemp()-PouringTempAssessVO.getNormTemp();
            PouringTempAssessVO.setTopExcessive(0.0);
            PouringTempAssessVO.setTopExcessivePersent(0);
            if(TopExcessive>0) {
                PouringTempAssessVO.setTopExcessive(TopExcessive);
                PouringTempAssessVO.setTopExcessivePersent((int) (TopExcessive*100/PouringTempAssessVO.getNormTemp()));
            }

        }
        PageInfo pageInfo = new PageInfo(PouringTempAssessVOS);
        return pageInfo;
    }

    @Override
    public List<PouringTempInfoVO> exportList() {
        List<PouringTempInfoVO> PouringTempInfo = PouringTempInfoMapper.List();

        return PouringTempInfo;
    }

    @Override
    public List<PouringTempMonitorVO> tempMonitor() {
        List<PouringTempMonitorVO> PouringTempInfo = PouringTempInfoMapper.tempMonitor();

        return PouringTempInfo;
    }


    @Override
    public void insert(MixingTempBc mixingTempBc) {
        String sbNo = mixingTempBc.getCw();
        try {
            PouringTempInfo pouringTempInfo = new PouringTempInfo();
            pouringTempInfo.setTemperature(mixingTempBc.getClwd().doubleValue());
            pouringTempInfo.setTime(mixingTempBc.getCwsj());
            PouringBaseVO pouringBase = pouringBaseMapper.selectBySbNo(sbNo);
            pouringTempInfo.setPouringBaseId(pouringBase.getId());
            pouringTempInfo.setOperator(mixingTempBc.getUserid().toString());
//            MaxTempNormVO maxTempNormVO = pouringTempAlertMapper.normInfo(pouringTempInfo.getPouringBaseId());
            SelectNormQue selectNormQue = new SelectNormQue();
            selectNormQue.setPbId(pouringTempInfo.getPouringBaseId());
            SbTempNormVO sbTempNormVO = sbTempNormMapper.selectNorm(selectNormQue);
            pouringTempInfo.setNorm(sbTempNormVO.getPouringTemp());
            PouringTempInfoMapper.insertSelective(pouringTempInfo);
            Double avgTemp = PouringTempInfoMapper.selectAvgTempByPbId(pouringBase.getId());
            ConnectionUtil.Send(pouringTempInfo.toMqStr(pouringBase,avgTemp));
            if (sbTempNormVO==null) return;
            pouringTempAlertService.pouringTempAlert(pouringTempInfo,sbTempNormVO);
        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
    }

    @Override
    public void addAll(List<PouringTempInfoVO> list) {
        for(PouringTempInfoVO pouringTempInfoVO:list)
        {
            PouringTempInfo pouringTempInfo = new PouringTempInfo();
            PouringBaseVO pouringBase = pouringBaseMapper.selectBySbNo(pouringTempInfoVO.getSmallNo());
            copyUtils.copyPropertiesIgnoreNull(pouringTempInfoVO,pouringTempInfo);
            pouringTempInfo.setPouringBaseId(pouringBase.getId());
            PouringTempInfoMapper.insertSelective(pouringTempInfo);
            Double avgTemp = PouringTempInfoMapper.selectAvgTempByPbId(pouringBase.getId());
            ConnectionUtil.Send(pouringTempInfo.toMqStr(pouringBase,avgTemp));
        }

    }

    @Override
    public List<PouringTempInfoVO> exportListByQue(PouringTempInfoQue pouringTempInfoQue) {
        return PouringTempInfoMapper.selectList(pouringTempInfoQue);
    }
}
