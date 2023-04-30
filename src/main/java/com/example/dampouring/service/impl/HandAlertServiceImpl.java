package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.HandAlertMapper;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.pojo.HandAlert;
import com.example.dampouring.model.request.AddHandAlertReq;
import com.example.dampouring.model.request.UpdateHandAlertReq;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.query.HandAlertQue;
import com.example.dampouring.service.HandAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandAlertServiceImpl implements HandAlertService {
    @Autowired
    HandAlertMapper HandAlertMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public void add(AddHandAlertReq addHandAlertReq, String userName) {
//        HandAlert HandAlert = new HandAlert();
//        BeanUtils.copyProperties(addHandAlertReq,HandAlert);
//        HandAlert.setCreateOp(userName);
//        HandAlert.setAlertTime(TimeUtils.getNowTime());
//        HandAlert.setHasDispose("0");
//        int count = HandAlertMapper.insertSelective(HandAlert);
//        if (count == 0){
//            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
//        }
        AlertBase alertBase = new AlertBase();
        alertBase.setTime(TimeUtils.getNowTime());
        alertBase.setState(0);
        alertBase.setTypeNo(5);
        alertBase.setContent(addHandAlertReq.getAlertContent());
        alertBase.setType(addHandAlertReq.getAlertType());
        alertBase.setPosition(addHandAlertReq.getEqNo());
        alertBaseMapper.insertSelective(alertBase);
        ConnectionUtil.Send(alertBase.toString());
    }
    @Override
    public void update(UpdateHandAlertReq updateHandAlertReq){
        HandAlert HandAlert =
                HandAlertMapper.selectByPrimaryKey(updateHandAlertReq.getId());
        if (HandAlert == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateHandAlertReq,HandAlert);
        int count = HandAlertMapper.updateByPrimaryKeySelective(HandAlert);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = HandAlertMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }

    @Override
    public PageInfo orUserList(HandAlertQue handAlertQue) {
        PageHelper.startPage(handAlertQue.getPageNum(), handAlertQue.getPageSize());
        List<HandAlert> handAlerts = HandAlertMapper.selectList(handAlertQue);
        PageInfo pageInfo = new PageInfo(handAlerts);
        return pageInfo;
    }

    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            HandAlert HandAlert = HandAlertMapper.selectByPrimaryKey(id);
            if(HandAlert==null) continue;
            if(mark == 0)
            {
                HandAlert.setHasDispose("0");
                HandAlert.setOperator("");
                HandAlert.setOpTime("");
            }
            else
            {
                if(HandAlert.getOperator()==null||HandAlert.getOperator().equals(""))
                {
                    HandAlert.setOperator(username);
                    HandAlert.setOpTime(TimeUtils.getNowTime());
                }
                HandAlert.setHasDispose(type);
            }
            HandAlertMapper.updateByPrimaryKeySelective(HandAlert);
        }
    }
    @Override
    public List<AlertBaseVO> list(Integer type, Integer role) {
        List<AlertBaseVO> result = HandAlertMapper.list(type,role);
        return result;
    }
}
