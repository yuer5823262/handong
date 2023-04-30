package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.pojo.InnerTempSensor;
import com.example.dampouring.model.pojo.MixingEgSensor;
import com.example.dampouring.model.request.AddMixingEgSensorReq;
import com.example.dampouring.model.request.UpdateMixingEgSensorReq;
import com.example.dampouring.model.vo.MixingEgSensorVO;
import com.example.dampouring.query.CheckMixingEgSensorQue;
import com.example.dampouring.query.MixingEgSensorQue;
import com.example.dampouring.service.MixingEgSensorService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingEgSensorServiceImpl implements MixingEgSensorService {
    @Autowired
    com.example.dampouring.model.dao.MixingEgSensorMapper MixingEgSensorMapper;
    private void checkData(String ip, Integer dkNo, Integer channelNo)
    {
        CheckMixingEgSensorQue checkMixingEgSensorQue = new CheckMixingEgSensorQue();
        checkMixingEgSensorQue.setChannelNo(channelNo);
        checkMixingEgSensorQue.setIp(ip);
        checkMixingEgSensorQue.setDkNo(dkNo);
        List<InnerTempSensor> innerTempSensorList = MixingEgSensorMapper.selectByIpCNo(checkMixingEgSensorQue);
        if(innerTempSensorList.size()!=0)
            throw new DamPourException(30000,"不能使用同一地址下相同的端口和通道号");
    }
    @Override
    public void add(AddMixingEgSensorReq addMixingEgSensorReq, String userName) {
        checkData(addMixingEgSensorReq.getIp(),addMixingEgSensorReq.getDkno(), addMixingEgSensorReq.getCno());
        MixingEgSensor MixingEgSensor = new MixingEgSensor();
        BeanUtils.copyProperties(addMixingEgSensorReq,MixingEgSensor);
        MixingEgSensor.setOperator(userName);
        MixingEgSensor.setCreateTime(TimeUtils.getNowTime());
        int count = MixingEgSensorMapper.insertSelective(MixingEgSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
    }
    @Override
    public void update(UpdateMixingEgSensorReq updateMixingEgSensorReq){
        checkData(updateMixingEgSensorReq.getIp(),updateMixingEgSensorReq.getDkno(), updateMixingEgSensorReq.getCno());
        MixingEgSensor MixingEgSensor = new MixingEgSensor();
        BeanUtils.copyProperties(updateMixingEgSensorReq,MixingEgSensor);
        int count = MixingEgSensorMapper.updateByPrimaryKeySelective(MixingEgSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = MixingEgSensorMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(MixingEgSensorQue MixingEgSensorInfoQue) {
        PageHelper.startPage(MixingEgSensorInfoQue.getPageNum(), MixingEgSensorInfoQue.getPageSize());
        List<MixingEgSensorVO> MixingEgSensorList = MixingEgSensorMapper.selectList(MixingEgSensorInfoQue);
        PageInfo pageInfo = new PageInfo(MixingEgSensorList);
        return pageInfo;
    }

    @Override
    public List<MixingEgSensorVO> listByIds(Integer[] ids) {
        List<MixingEgSensorVO> categoryList = MixingEgSensorMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<MixingEgSensorVO> exportList() {
        List<MixingEgSensorVO> MixingEgSensorList = MixingEgSensorMapper.selectList(new MixingEgSensorQue());
        return MixingEgSensorList;
    }
}
