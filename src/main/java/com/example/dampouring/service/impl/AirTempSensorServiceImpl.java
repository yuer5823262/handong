package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.AirTempSensorMapper;
import com.example.dampouring.model.dao.ControlUnitMapper;
import com.example.dampouring.model.pojo.AirTempSensor;
import com.example.dampouring.model.pojo.ControlUnit;
import com.example.dampouring.model.pojo.InnerTempSensor;
import com.example.dampouring.model.request.AddAirTempSensorReq;
import com.example.dampouring.model.request.UpdateAirTempSensorReq;
import com.example.dampouring.model.vo.AirTempSensorVO;
import com.example.dampouring.model.vo.WaterReversingDeviceVO;
import com.example.dampouring.query.AirTempSensorQue;
import com.example.dampouring.service.AirTempSensorService;
import com.example.dampouring.util.DllUtils;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirTempSensorServiceImpl implements AirTempSensorService {
    @Autowired
    AirTempSensorMapper airTempSensorMapper;

    @Autowired
    ControlUnitMapper controlUnitMapper;
    private void checkData(Integer cuId,Integer channelNo)
    {
        List<AirTempSensor> airTempSensors = airTempSensorMapper.selectByCuIdCNo(cuId,channelNo);
        if(airTempSensors.size()!=0)
            throw new DamPourException(30000,"不能使用同一测控单元下相同的通道号");
    }
    @Override
    public void add(AddAirTempSensorReq addAirTempSensorReq, String userName) {
//        checkData(addAirTempSensorReq.getCuId(),addAirTempSensorReq.getChannelNo());
        AirTempSensor airTempSensor = new AirTempSensor();
        BeanUtils.copyProperties(addAirTempSensorReq,airTempSensor);
        airTempSensor.setOperator(userName);
        airTempSensor.setCreateTime(TimeUtils.getNowTime());
        List<Integer> cList = updateChannel(airTempSensor);
        if(cList!=null&&cList.get(0)!=-1) airTempSensor.setChannel(cList.get(0));
        int count = airTempSensorMapper.insertSelective(airTempSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
    }

    public List<Integer> updateChannel(AirTempSensor airTempSensor)
    {
        if(Constant.pSta!=0) return null;
        ControlUnit controlUnit=controlUnitMapper.selectByPrimaryKey(airTempSensor.getCuId());
        List<String> addr = new ArrayList<>();
        addr.add(airTempSensor.getAddr());
        return Constant.DllUTILS.getTempSensorChannel(Integer.parseInt(controlUnit.getCuAddr()),airTempSensor.getChannelNo(),addr
                );
    }

    @Override
    public void updateChannelAll()
    {

        List<AirTempSensor> airTempSensors=airTempSensorMapper.list();
        for(AirTempSensor airTempSensor:airTempSensors)
        {
            List<Integer> cList = updateChannel(airTempSensor);
            if(cList!=null&&cList.get(0)!=-1) airTempSensor.setChannel(cList.get(0));
            airTempSensorMapper.updateByPrimaryKeySelective(airTempSensor);
        }
    }

    @Override
    public void update(UpdateAirTempSensorReq updateAirTempSensorReq){
//        checkData(updateAirTempSensorReq.getCuId(),updateAirTempSensorReq.getChannelNo());
        AirTempSensor airTempSensor =
                airTempSensorMapper.selectByPrimaryKey(updateAirTempSensorReq.getId());
        if (airTempSensor == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateAirTempSensorReq,airTempSensor);

        int count = airTempSensorMapper.updateByPrimaryKeySelective(airTempSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = airTempSensorMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AirTempSensorVO> airTempSensorList = airTempSensorMapper.selectList();
        PageInfo pageInfo = new PageInfo(airTempSensorList);
        return pageInfo;
    }

    @Override
    public List<AirTempSensorVO> listByIds(Integer[] ids) {
        List<AirTempSensorVO> categoryList = airTempSensorMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<AirTempSensorVO> exportList() {
        List<AirTempSensorVO> airTempSensorList = airTempSensorMapper.selectList();
        return airTempSensorList;
    }

    @Override
    public PageInfo select(AirTempSensorQue airTempSensorQue) {
        PageHelper.startPage(airTempSensorQue.getPageNum(), airTempSensorQue.getPageSize());
        List<AirTempSensorVO> airTempSensorList = airTempSensorMapper.selectListByQue(airTempSensorQue);
        PageInfo pageInfo = new PageInfo(airTempSensorList);
        return pageInfo;
    }
}
