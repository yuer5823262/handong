package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.*;
import com.example.dampouring.model.pojo.*;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.SelectNormQue;
import com.example.dampouring.service.FaceDiapauseAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaceDiapauseAlertServiceImpl implements FaceDiapauseAlertService {
    @Autowired
    FaceDiapauseAlertMapper FaceDiapauseAlertMapper;
    @Autowired
    PouringBaseMapper pouringBaseMapper;
    @Autowired
    SmallStorageBinMapper smallStorageBinMapper;
    @Autowired
    SbTempNormMapper sbTempNormMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<FaceDiapauseAlertVO> InboundTempInfo = FaceDiapauseAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }

    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            FaceDiapauseAlert FaceDiapauseAlert = FaceDiapauseAlertMapper.selectByPrimaryKey(id);
            if(FaceDiapauseAlert==null) continue;
            if(mark == 0)
            {
                FaceDiapauseAlert.setHasDispose("0");
                FaceDiapauseAlert.setOperator("");
                FaceDiapauseAlert.setOpTime("");
            }
            else
            {
                if(FaceDiapauseAlert.getOperator()==null||FaceDiapauseAlert.getOperator().equals(""))
                {
                    FaceDiapauseAlert.setOperator(username);
                    FaceDiapauseAlert.setOpTime(TimeUtils.getNowTime());
                }
                FaceDiapauseAlert.setHasDispose(type);
            }
            FaceDiapauseAlertMapper.updateByPrimaryKeySelective(FaceDiapauseAlert);
        }
    }
    @Override
    public void upFaceDiapauseAlert(PouringBase pouringBase)
    {
        String time = TimeUtils.getNowTime();

        Double days;
        SelectNormQue selectNormQue = new SelectNormQue();
        selectNormQue.setPbId(pouringBase.getId());
        SbTempNormVO sbTempNorm = sbTempNormMapper.selectNorm(selectNormQue);
        if(sbTempNorm==null) return;
        String norm = sbTempNorm.getIntervals();
        String[] norms = norm.split("-");
        days = TimeUtils.getHourDifferentTime(pouringBase.getCloseTime(), pouringBase.getCoverTime()) / 24;
        if((days<Integer.parseInt(norms[0])&&days>=0)||days>Integer.parseInt(norms[1]))
        {
//            FaceDiapauseAlert faceDiapauseAlert = new FaceDiapauseAlert();
//            faceDiapauseAlert.setAlertTime(time);
//            faceDiapauseAlert.setHasDispose("0");
//            faceDiapauseAlert.setDiapauseDays((double) days.intValue());
//            faceDiapauseAlert.setAlertContent("仓面间歇期为"+days.intValue()+",不满足标准的"+norm+"天");
//            faceDiapauseAlert.setAlertType("仓面间歇期预警");
//            faceDiapauseAlert.setTimeClose(pouringBase.getCloseTime());
//            faceDiapauseAlert.setTimeCurr(TimeUtils.getNowTime());
//            faceDiapauseAlert.setSbId(sbTempNorm.getSbId());
//            FaceDiapauseAlertMapper.insertSelective(faceDiapauseAlert);
            AlertBase alertBase = new AlertBase();
            alertBase.setTime(time);
            alertBase.setState(0);
            alertBase.setTypeNo(4);
            alertBase.setContent("仓面间歇期为"+days.intValue()+",不满足标准的"+norm+"天");
            alertBase.setType("仓面间歇期预警");
            alertBase.setPosition(sbTempNorm.getSbNo());
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
        }
    }

    @Override
    public void upOpenTimeFaceDiapauseAlert(PouringBase pouringBase) {
        try {
            String upTime = pouringBase.getOpenTime();
            if(upTime==null) return;
            SmallStorageBin smallStorageBin = smallStorageBinMapper.selectByPrimaryKey(pouringBase.getSmallSbId());
            SelectNormQue selectNormQue = new SelectNormQue();
            selectNormQue.setSbId(pouringBase.getSmallSbId());
            SbTempNormVO sbTempNorm = sbTempNormMapper.selectNorm(selectNormQue);
            if(sbTempNorm==null) return;
            String norm = sbTempNorm.getIntervals();
            String[] norms = norm.split("-");
            List<PouringBase> pouringBaseList = pouringBaseMapper.selectByUpSb(smallStorageBin.getElevationStart(),
                    Integer.parseInt(smallStorageBin.getDsStart()),
                    Integer.parseInt(smallStorageBin.getDsEnd()));
            for(PouringBase pb:pouringBaseList)
            {
                try {
                    Double days = TimeUtils.getHourDifferentTime(pb.getCloseTime(), upTime) / 24;
                    if((days<Integer.parseInt(norms[0])&&days>=0)||days>Integer.parseInt(norms[1]))
                    {
                        AlertBase alertBase = new AlertBase();
                        alertBase.setTime(TimeUtils.getNowTime());
                        alertBase.setState(0);
                        alertBase.setTypeNo(4);
                        alertBase.setContent("仓面间歇期为"+days.intValue()+",不满足标准的"+norm+"天");
                        alertBase.setType("仓面间歇期预警");
                        alertBase.setPosition(sbTempNorm.getSbNo());
                        alertBaseMapper.insertSelective(alertBase);
                        ConnectionUtil.Send(alertBase.toString());
                    }
                } catch (Exception e) {
                    Constant.logger.error("错误:",e);
                }
            }

        } catch (NumberFormatException e) {
            Constant.logger.error("错误:",e);
        }

    }

    @Override
    public void faceDiapauseAlert()
    {
        String time = TimeUtils.getNowTime();
        List<PouringBaseVO> pouringBaseList = pouringBaseMapper.selectList();
        for(PouringBaseVO pouringBase:pouringBaseList) {
            try {
                Double days;
                SelectNormQue selectNormQue = new SelectNormQue();
                selectNormQue.setPbId(pouringBase.getId());
                SbTempNormVO sbTempNorm = sbTempNormMapper.selectNorm(selectNormQue);
                if(sbTempNorm==null) continue;
                String norm = sbTempNorm.getIntervals();
                String[] norms = norm.split("-");
                if(pouringBase.getCoverTime()==null) {
                    days = TimeUtils.getHourDifferentTime(pouringBase.getCloseTime(), time) / 24;
                    if(days>Integer.parseInt(norms[1]))
                    {
//                        FaceDiapauseAlert faceDiapauseAlert = new FaceDiapauseAlert();
//                        faceDiapauseAlert.setAlertTime(time);
//                        faceDiapauseAlert.setHasDispose("0");
//                        faceDiapauseAlert.setDiapauseDays((double) days.intValue());
//                        faceDiapauseAlert.setAlertContent("仓面间歇期已经高于标准的"+norm+"天,"+"达到"+days.intValue()+"天");
//                        faceDiapauseAlert.setAlertType("仓面间歇期预警");
//                        faceDiapauseAlert.setTimeClose(pouringBase.getCloseTime());
//                        faceDiapauseAlert.setTimeCurr(TimeUtils.getNowTime());
//                        faceDiapauseAlert.setSbId(sbTempNorm.getSbId());
//                        FaceDiapauseAlertMapper.insertSelective(faceDiapauseAlert);
                        AlertBase alertBase = new AlertBase();
                        alertBase.setTime(TimeUtils.getNowTime());
                        alertBase.setState(0);
                        alertBase.setTypeNo(4);
                        alertBase.setContent("仓面间歇期为"+days.intValue()+",不满足标准的"+norm+"天");
                        alertBase.setType("仓面间歇期预警");
                        alertBase.setPosition(sbTempNorm.getSbNo());
                        alertBaseMapper.insertSelective(alertBase);
                        ConnectionUtil.Send(alertBase.toString());
                    }
                }
            } catch (NumberFormatException e) {
                Constant.logger.error("错误:",e);
            }
        }

    }

    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = FaceDiapauseAlertMapper.list(type);
        return result;
    }
}
