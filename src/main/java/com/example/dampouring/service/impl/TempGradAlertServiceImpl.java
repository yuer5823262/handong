package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.TempGradAlertMapper;
import com.example.dampouring.model.pojo.*;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.TempGradAlertVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.TempGradAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.Constant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempGradAlertServiceImpl implements TempGradAlertService {
    @Autowired
    TempGradAlertMapper TempGradAlertMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<TempGradAlertVO> InboundTempInfo = TempGradAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = TempGradAlertMapper.list(type);
        return result;
    }
    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            TempGradAlert TempGradAlert = TempGradAlertMapper.selectByPrimaryKey(id);
            if(TempGradAlert==null) continue;
            if(mark == 0)
            {
                TempGradAlert.setHasDispose("0");
                TempGradAlert.setOperator("");
                TempGradAlert.setOpTime("");
            }
            else
            {
                if(TempGradAlert.getOperator()==null||TempGradAlert.getOperator().equals(""))
                {
                    TempGradAlert.setOperator(username);
                    TempGradAlert.setOpTime(TimeUtils.getNowTime());
                }
                TempGradAlert.setHasDispose(type);
            }
            TempGradAlertMapper.updateByPrimaryKeySelective(TempGradAlert);
        }
    }

    @Override
    public void TempGradTempAlert(TempGradometerInfo tempGradometerInfo)
    {
        MaxTempNormVO maxTempNormVO = TempGradAlertMapper.normInfo(tempGradometerInfo.getTempGradometerId());
        if(maxTempNormVO==null) return;
        Double gradMaxTemp = tempGradometerInfo.getMaxTemp();
        if(gradMaxTemp>maxTempNormVO.getMaxTemp())
        {
//            TempGradAlert tempGradAlert = new TempGradAlert();
//            tempGradAlert.setHasDispose("0");
//            tempGradAlert.setTempMax(gradMaxTemp);
//            tempGradAlert.setSbId(maxTempNormVO.getSbId());
//            tempGradAlert.setAlertTime(TimeUtils.getNowTime());
//            tempGradAlert.setAlertType("温度梯度预警");
//            if(gradMaxTemp>maxTempNormVO.getMaxTemp())
//                tempGradAlert.setAlertContent(maxTempNormVO.getSbNo()+"温度梯度最高温度已经达到"+gradMaxTemp
//                        +",超过温度标准"+(gradMaxTemp-maxTempNormVO.getMaxTemp())+"°C。");
//            else
//                tempGradAlert.setAlertContent(maxTempNormVO.getSbNo()+"温度梯度最高温度已经达到"+gradMaxTemp
//                        +",距离设计要求的最高温度"+maxTempNormVO.getMaxTemp()+"不到1°C。");
//            tempGradAlert.setTempNorm(maxTempNormVO.getMaxTemp());
//            TempGradAlertMapper.insertSelective(tempGradAlert);

            AlertBase alertBase = new AlertBase();
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setState(0);
            alertBase.setTypeNo(14);
            if(gradMaxTemp>maxTempNormVO.getMaxTemp())
                alertBase.setContent(maxTempNormVO.getSbNo()+"温度梯度最高温度已经达到"+String.format("%.2f",gradMaxTemp)
                        +",超过温度标准"+String.format("%.2f",gradMaxTemp-maxTempNormVO.getMaxTemp())+"°C。");
            else
                alertBase.setContent(maxTempNormVO.getSbNo()+"温度梯度最高温度已经达到"+String.format("%.2f",gradMaxTemp)
                        +",距离设计要求的最高温度"+String.format("%.2f",maxTempNormVO.getMaxTemp())+"不到1°C。");
            alertBase.setType("温度梯度预警");
            alertBase.setPosition(maxTempNormVO.getSbNo());
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
        }
    }
}
