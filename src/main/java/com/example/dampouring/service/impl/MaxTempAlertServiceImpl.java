package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.MaxTempAlertMapper;
import com.example.dampouring.model.pojo.*;
import com.example.dampouring.model.pojo.MaxTempAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempAlertVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.MaxTempAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaxTempAlertServiceImpl implements MaxTempAlertService {
    @Autowired
    MaxTempAlertMapper MaxTempAlertMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<MaxTempAlertVO> InboundTempInfo = MaxTempAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = MaxTempAlertMapper.list(type);
        return result;
    }
    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            MaxTempAlert MaxTempAlert = MaxTempAlertMapper.selectByPrimaryKey(id);
            if(MaxTempAlert==null) continue;
            if(mark == 0)
            {
                MaxTempAlert.setHasDispose("0");
                MaxTempAlert.setOperator("");
                MaxTempAlert.setOpTime("");
            }
            else
            {
                if(MaxTempAlert.getOperator()==null||MaxTempAlert.getOperator().equals(""))
                {
                    MaxTempAlert.setOperator(username);
                    MaxTempAlert.setOpTime(TimeUtils.getNowTime());
                }
                MaxTempAlert.setHasDispose(type);
            }
            MaxTempAlertMapper.updateByPrimaryKeySelective(MaxTempAlert);
        }
    }
    @Override
    public void maxTempAlert(InnerTempSensorInfo innerTempSensorInfo,MaxTempNormVO maxTempNormVO)
    {
        if(innerTempSensorInfo.getTemp()>maxTempNormVO.getMaxTemp()-1)
        {
//            MaxTempAlert maxTempAlert = new MaxTempAlert();
//            maxTempAlert.setHasDispose("0");
//            maxTempAlert.setTempMax(innerTempSensorInfo.getTemp());
//            maxTempAlert.setSbId(maxTempNormVO.getSbId());
//            maxTempAlert.setAlertTime(TimeUtils.getNowTime());
//            maxTempAlert.setAlertType("最高温度预警");
//            if(innerTempSensorInfo.getTemp()>maxTempNormVO.getMaxTemp())
//                maxTempAlert.setAlertContent(maxTempNormVO.getSbNo()+"仓内最高温度已经达到"+innerTempSensorInfo.getTemp()
//                        +",超过温度标准"+(innerTempSensorInfo.getTemp()-maxTempNormVO.getMaxTemp())+"°C。");
//            else
//                maxTempAlert.setAlertContent(maxTempNormVO.getSbNo()+"仓内最高温度已经达到"+innerTempSensorInfo.getTemp()
//                        +",距离设计要求的最高温度"+maxTempNormVO.getMaxTemp()+"不到1°C。");
//            maxTempAlert.setTempNorm(maxTempNormVO.getMaxTemp());
//            MaxTempAlertMapper.insert(maxTempAlert);
            AlertBase alertBase = new AlertBase();
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setState(0);
            alertBase.setTypeNo(8);
            if(innerTempSensorInfo.getTemp()>maxTempNormVO.getMaxTemp())
                alertBase.setContent(maxTempNormVO.getSbNo()+"仓内最高温度已经达到"+String.format("%.2f",innerTempSensorInfo.getTemp())
                        +",超过温度标准"+String.format("%.2f",(innerTempSensorInfo.getTemp()-maxTempNormVO.getMaxTemp()))+"°C。");
            else
                alertBase.setContent(maxTempNormVO.getSbNo()+"仓内最高温度已经达到"+String.format("%.2f",innerTempSensorInfo.getTemp())
                        +",距离设计要求的最高温度"+maxTempNormVO.getMaxTemp()+"不到1°C。");
            alertBase.setType("最高温度报警");
            alertBase.setPosition(maxTempNormVO.getSbNo());
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
        }
    }
}
