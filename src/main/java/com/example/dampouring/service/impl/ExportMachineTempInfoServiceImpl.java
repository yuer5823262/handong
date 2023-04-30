package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.ExportMachineTempInfoMapper;
import com.example.dampouring.model.dao.OutletTempAlertMapper;
import com.example.dampouring.model.dao.PouringBaseMapper;
import com.example.dampouring.model.dao.SbTempNormMapper;
import com.example.dampouring.model.pojo.ExportMachineTempInfo;
import com.example.dampouring.model.pojo.InboundTempInfo;
import com.example.dampouring.model.pojo.MixingTempBc;
import com.example.dampouring.model.pojo.PouringBase;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.ExportMachineTempAssessQue;
import com.example.dampouring.query.ExportMachineTempInfoQue;
import com.example.dampouring.query.SelectNormQue;
import com.example.dampouring.service.ExportMachineTempInfoService;
import com.example.dampouring.service.OutletTempAlertService;
import com.example.dampouring.service.SmartMixingResultService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.copyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportMachineTempInfoServiceImpl implements ExportMachineTempInfoService {
    @Autowired
    ExportMachineTempInfoMapper exportMachineTempInfoMapper;
    @Autowired
    PouringBaseMapper pouringBaseMapper;
    @Autowired
    OutletTempAlertMapper OutletTempAlertMapper;
    @Autowired
    OutletTempAlertService outletTempAlertService;
    @Autowired
    SbTempNormMapper sbTempNormMapper;
    @Autowired
    SmartMixingResultService smartMixingResultService;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ExportMachineTempInfoVO> ExportMachineTempInfo = exportMachineTempInfoMapper.List();
        PageInfo pageInfo = new PageInfo(ExportMachineTempInfo);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(ExportMachineTempInfoQue ExportMachineTempInfoQue) {
        PageHelper.startPage(ExportMachineTempInfoQue.getPageNum(), ExportMachineTempInfoQue.getPageSize());
        List<ExportMachineTempInfoVO> ExportMachineTempInfo = exportMachineTempInfoMapper.selectList(ExportMachineTempInfoQue);
        PageInfo pageInfo = new PageInfo(ExportMachineTempInfo);
        return pageInfo;
    }

    @Override
    public PageInfo assess(ExportMachineTempAssessQue exportMachineTempAssessQue) {
        PageHelper.startPage(exportMachineTempAssessQue.getPageNum(), exportMachineTempAssessQue.getPageSize());
        List<ExportMachineTempAssessVO> exportMachineTempAssessVOS = exportMachineTempInfoMapper.assess(exportMachineTempAssessQue);
        for(ExportMachineTempAssessVO exportMachineTempAssessVO: exportMachineTempAssessVOS)
        {
            exportMachineTempAssessVO.setExcessivePersent(
                    exportMachineTempAssessVO.getExcessiveCount()*100/exportMachineTempAssessVO.getRecordCount());
            Double TopExcessive = exportMachineTempAssessVO.getTopTemp()-exportMachineTempAssessVO.getNormTemp();
            exportMachineTempAssessVO.setTopExcessive(0.0);
            exportMachineTempAssessVO.setTopExcessivePersent(0);
            if(TopExcessive>0) {
                exportMachineTempAssessVO.setTopExcessive(TopExcessive);
                exportMachineTempAssessVO.setTopExcessivePersent((int) (TopExcessive*100/exportMachineTempAssessVO.getNormTemp()));
            }

        }
        PageInfo pageInfo = new PageInfo(exportMachineTempAssessVOS);
        return pageInfo;
    }

    @Override
    public List<ExportMachineTempInfoVO> exportList() {
        List<ExportMachineTempInfoVO> ExportMachineTempInfo = exportMachineTempInfoMapper.List();
        return ExportMachineTempInfo;
    }

    @Override
    public void insert(MixingTempBc mixingTempBc) {
        String sbNo = mixingTempBc.getCw();
        try {
            ExportMachineTempInfo exportMachineTempInfo = new ExportMachineTempInfo();
            exportMachineTempInfo.setTemperature(mixingTempBc.getClwd().doubleValue());
            exportMachineTempInfo.setTime(mixingTempBc.getCwsj());
            PouringBaseVO pouringBase = pouringBaseMapper.selectBySbNo(sbNo);
            exportMachineTempInfo.setPouringBaseId(pouringBase.getId());
            exportMachineTempInfo.setOperator(mixingTempBc.getUserid().toString());
//            MaxTempNormVO maxTempNormVO = OutletTempAlertMapper.normInfo(exportMachineTempInfo.getPouringBaseId());
            SelectNormQue selectNormQue = new SelectNormQue();
            selectNormQue.setPbId(exportMachineTempInfo.getPouringBaseId());
            SbTempNormVO sbTempNormVO = sbTempNormMapper.selectNorm(selectNormQue);
            if(sbTempNormVO!=null)
                exportMachineTempInfo.setNorm(sbTempNormVO.getPortTemp());
            exportMachineTempInfo.setPosition(mixingTempBc.getBhlh());
            exportMachineTempInfoMapper.insertSelective(exportMachineTempInfo);
            ConnectionUtil.Send(exportMachineTempInfo.toMqStr(pouringBase));
            if (sbTempNormVO==null) return;
            outletTempAlertService.OutletTempAlerAlert(exportMachineTempInfo,sbTempNormVO);


        } catch (Exception e) {
            Constant.logger.error("错误:",e);
        }
    }

    @Override
    public void addAll(List<ExportMachineTempInfoVO> list) {
        for(ExportMachineTempInfoVO exportMachineTempInfoVO:list)
        {
            ExportMachineTempInfo exportMachineTempInfo = new ExportMachineTempInfo();
            PouringBaseVO pouringBase = pouringBaseMapper.selectBySbNo(exportMachineTempInfoVO.getSmallNo());
            copyUtils.copyPropertiesIgnoreNull(exportMachineTempInfoVO,exportMachineTempInfo);
            exportMachineTempInfo.setPouringBaseId(pouringBase.getId());
            ConnectionUtil.Send(exportMachineTempInfo.toMqStr(pouringBase));
            exportMachineTempInfoMapper.insertSelective(exportMachineTempInfo);
        }
    }

    @Override
    public List<ExportMachineTempInfoVO> exportListByQue(ExportMachineTempInfoQue exportMachineTempInfoQue) {
        return exportMachineTempInfoMapper.selectList(exportMachineTempInfoQue);
    }
}
