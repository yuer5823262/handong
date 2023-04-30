package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.TempControlStandardNormMapper;
import com.example.dampouring.model.pojo.*;
import com.example.dampouring.model.pojo.MixingAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MixingAlertVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.MixingAlertQue;
import com.example.dampouring.service.MixingAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingAlertServiceImpl implements MixingAlertService {
    @Autowired
    com.example.dampouring.model.dao.MixingAlertMapper MixingAlertMapper;
    @Autowired
    TempControlStandardNormMapper tempControlStandardNormMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(MixingAlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<MixingAlertVO> InboundTempInfo = MixingAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = MixingAlertMapper.list(type);
        return result;
    }
    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            MixingAlert MixingAlert = MixingAlertMapper.selectByPrimaryKey(id);
            if(MixingAlert==null) continue;
            if(mark == 0)
            {
                MixingAlert.setHasDispose("0");
                MixingAlert.setOperator("");
                MixingAlert.setOpTime("");
            }
            else
            {
                if(MixingAlert.getOperator()==null||MixingAlert.getOperator().equals(""))
                {
                    MixingAlert.setOperator(username);
                    MixingAlert.setOpTime(TimeUtils.getNowTime());
                }
                MixingAlert.setHasDispose(type);
            }
            MixingAlertMapper.updateByPrimaryKeySelective(MixingAlert);
        }
    }

    @Override
    public void mixingTempAlert(SmartMixingResult smartMixingResult) {
        if(smartMixingResult.getSf().equals("出机口温度不满足要求"))
        {
//            MixingAlert mixingAlert = new MixingAlert();
//            mixingAlert.setHasDispose("0");
//            mixingAlert.setBno(smartMixingResult.getMbNo());
//            mixingAlert.setTime(TimeUtils.getNowTime());
//            mixingAlert.setContent("初机口温度不满足标准，加冰率超过标准达到"+smartMixingResult.getΜ());
//            MixingAlertMapper.insertSelective(mixingAlert);
            AlertBase alertBase = new AlertBase();
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setState(0);
            alertBase.setTypeNo(9);
            alertBase.setContent("出机口温度不满足标准，加冰率超过标准达到"+String.format("%.2f",smartMixingResult.getΜ()));
            alertBase.setType("智能拌合报警");
            alertBase.setPosition(smartMixingResult.getMbNo());
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
        }


    }

}
