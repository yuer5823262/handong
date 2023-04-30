package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.PouringTempAlertMapper;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.pojo.PouringTempAlert;
import com.example.dampouring.model.pojo.PouringTempInfo;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.PouringTempAlertVO;
import com.example.dampouring.model.vo.SbTempNormVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.PouringTempAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PouringTempAlertServiceImpl implements PouringTempAlertService {
    @Autowired
    PouringTempAlertMapper PouringTempAlertMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<PouringTempAlertVO> InboundTempInfo = PouringTempAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = PouringTempAlertMapper.list(type);
        return result;
    }
    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            PouringTempAlert PouringTempAlert = PouringTempAlertMapper.selectByPrimaryKey(id);
            if(PouringTempAlert==null) continue;
            if(mark == 0)
            {
                PouringTempAlert.setHasDispose("0");
                PouringTempAlert.setOperator("");
                PouringTempAlert.setOpTime("");
            }
            else
            {
                if(PouringTempAlert.getOperator()==null||PouringTempAlert.getOperator().equals(""))
                {
                    PouringTempAlert.setOperator(username);
                    PouringTempAlert.setOpTime(TimeUtils.getNowTime());
                }
                PouringTempAlert.setHasDispose(type);
            }
            PouringTempAlertMapper.updateByPrimaryKeySelective(PouringTempAlert);
        }
    }

    @Override
    public void pouringTempAlert(PouringTempInfo pouringTempInfo, SbTempNormVO sbTempNormVO)
    {
//        MaxTempNormVO maxTempNormVO = PouringTempAlertMapper.normInfo(pouringTempInfo.getPouringBaseId());
        Double norm = pouringTempInfo.getNorm();
        if(pouringTempInfo.getTemperature()>norm)
        {
//            PouringTempAlert pouringTempAlert = new PouringTempAlert();
//            pouringTempAlert.setHasDispose("0");
//            pouringTempAlert.setOutletTemp(pouringTempInfo.getTemperature());
//            pouringTempAlert.setSbId(sbId);
//            pouringTempAlert.setAlertContent("温度达到"+pouringTempInfo.getTemperature()+
//                    "°C，超过温度标准"+norm+"°C");
//            pouringTempAlert.setAlertTime(TimeUtils.getNowTime());
//            pouringTempAlert.setExceedAmount(pouringTempInfo.getTemperature()-norm);
//            pouringTempAlert.setTempNorm(norm);
//            PouringTempAlertMapper.insert(pouringTempAlert);
            AlertBase alertBase = new AlertBase();
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setState(0);
            alertBase.setTypeNo(11);
            alertBase.setContent("温度达到"+String.format("%.2f",pouringTempInfo.getTemperature())+
                    "°C，超过温度标准"+norm+"°C");
            alertBase.setType("浇筑温度报警");
            alertBase.setPosition(sbTempNormVO.getSbNo());
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
        }
    }
}
