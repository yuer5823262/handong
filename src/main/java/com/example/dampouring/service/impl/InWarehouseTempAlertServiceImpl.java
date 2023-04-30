package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.InWarehouseTempAlertMapper;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.pojo.InWarehouseTempAlert;
import com.example.dampouring.model.pojo.InWarehouseTempAlert;
import com.example.dampouring.model.pojo.InboundTempInfo;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.InWarehouseTempAlertVO;
import com.example.dampouring.model.vo.SbTempNormVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.InWarehouseTempAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InWarehouseTempAlertServiceImpl implements InWarehouseTempAlertService {
    @Autowired
    InWarehouseTempAlertMapper InWarehouseTempAlertMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<InWarehouseTempAlertVO> InboundTempInfo = InWarehouseTempAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }

    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            InWarehouseTempAlert InWarehouseTempAlert = InWarehouseTempAlertMapper.selectByPrimaryKey(id);
            if(InWarehouseTempAlert==null) continue;
            if(mark == 0)
            {
                InWarehouseTempAlert.setHasDispose("0");
                InWarehouseTempAlert.setOperator("");
                InWarehouseTempAlert.setOpTime("");
            }
            else
            {
                if(InWarehouseTempAlert.getOperator()==null||InWarehouseTempAlert.getOperator().equals(""))
                {
                    InWarehouseTempAlert.setOperator(username);
                    InWarehouseTempAlert.setOpTime(TimeUtils.getNowTime());
                }
                InWarehouseTempAlert.setHasDispose(type);
            }
            InWarehouseTempAlertMapper.updateByPrimaryKeySelective(InWarehouseTempAlert);
        }
    }


    @Override
    public void inboundTempAlert(InboundTempInfo inboundTempInfo, SbTempNormVO sbTempNormVO)
    {
        Double norm = inboundTempInfo.getNorm();
//        MaxTempNormVO maxTempNormVO = InWarehouseTempAlertMapper.normInfo(inboundTempInfo.getPouringBaseId());
        if(inboundTempInfo.getTemperature()>norm)
        {
//            InWarehouseTempAlert inWarehouseTempAlert = new InWarehouseTempAlert();
//            inWarehouseTempAlert.setHasDispose("0");
//            inWarehouseTempAlert.setInwhTemp(inboundTempInfo.getTemperature());
//            inWarehouseTempAlert.setSbId(sbId);
//            inWarehouseTempAlert.setAlertContent("温度达到"+inboundTempInfo.getTemperature()+
//                    "°C，超过温度标准"+norm+"°C");
//            inWarehouseTempAlert.setAlertTime(TimeUtils.getNowTime());
//            inWarehouseTempAlert.setExceedAmount(inboundTempInfo.getTemperature()-norm);
//            inWarehouseTempAlert.setTempNorm(norm);
//            InWarehouseTempAlertMapper.insert(inWarehouseTempAlert);
            AlertBase alertBase = new AlertBase();
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setState(0);
            alertBase.setTypeNo(6);

            alertBase.setContent("温度达到"+String.format("%.2f",inboundTempInfo.getTemperature())+
                    "°C，超过温度标准"+norm+"°C");
            alertBase.setType("入仓温度报警");
            alertBase.setPosition(sbTempNormVO.getSbNo());
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
        }
    }

    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = InWarehouseTempAlertMapper.list(type);
        return result;
    }
}

