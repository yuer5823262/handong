package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.OutletTempAlertMapper;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.pojo.OutletTempAlert;
import com.example.dampouring.model.pojo.ExportMachineTempInfo;
import com.example.dampouring.model.pojo.OutletTempAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.OutletTempAlertVO;
import com.example.dampouring.model.vo.SbTempNormVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.OutletTempAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutletTempAlertServiceImpl implements OutletTempAlertService {
    @Autowired
    OutletTempAlertMapper OutletTempAlertMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<OutletTempAlertVO> InboundTempInfo = OutletTempAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = OutletTempAlertMapper.list(type);
        return result;
    }
    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            OutletTempAlert OutletTempAlert = OutletTempAlertMapper.selectByPrimaryKey(id);
            if(OutletTempAlert==null) continue;
            if(mark == 0)
            {
                OutletTempAlert.setHasDispose("0");
                OutletTempAlert.setOperator("");
                OutletTempAlert.setOpTime("");
            }
            else
            {
                if(OutletTempAlert.getOperator()==null||OutletTempAlert.getOperator().equals(""))
                {
                    OutletTempAlert.setOperator(username);
                    OutletTempAlert.setOpTime(TimeUtils.getNowTime());
                }
                OutletTempAlert.setHasDispose(type);
            }
            OutletTempAlertMapper.updateByPrimaryKeySelective(OutletTempAlert);
        }
    }

    @Override
    public void OutletTempAlerAlert(ExportMachineTempInfo exportMachineTempInfo, SbTempNormVO sbTempNormVO)
    {
//        MaxTempNormVO maxTempNormVO = OutletTempAlertMapper.normInfo(exportMachineTempInfo.getPouringBaseId());
        Double norm = exportMachineTempInfo.getNorm();
        if(exportMachineTempInfo.getTemperature()>norm)
        {
//            OutletTempAlert outletTempAlert = new OutletTempAlert();
//            outletTempAlert.setHasDispose("0");
//            outletTempAlert.setOutletTemp(exportMachineTempInfo.getTemperature());
//            outletTempAlert.setSbId(sbId);
//            outletTempAlert.setAlertContent("温度达到"+exportMachineTempInfo.getTemperature()+
//                    "°C，超过温度标准"+norm+"°C");
//            outletTempAlert.setAlertTime(TimeUtils.getNowTime());
//            outletTempAlert.setExceedAmount(exportMachineTempInfo.getTemperature()-norm);
//            outletTempAlert.setTempNorm(norm);
//            OutletTempAlertMapper.insert(outletTempAlert);
            AlertBase alertBase = new AlertBase();
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setState(0);
            alertBase.setTypeNo(10);
            alertBase.setContent("温度达到"+String.format("%.2f",exportMachineTempInfo.getTemperature())+
                    "°C，超过温度标准"+norm+"°C");
            alertBase.setType("出机口温度报警");
            alertBase.setPosition(sbTempNormVO.getSbNo());
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
        }
    }
}
