package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.WaterPressureSensorMapper;
import com.example.dampouring.model.pojo.WaterPressureSensor;
import com.example.dampouring.model.pojo.WaterTempSensor;
import com.example.dampouring.model.request.AddWaterPressureSensorReq;
import com.example.dampouring.model.request.UpdateWaterPressureSensorReq;
import com.example.dampouring.model.vo.WaterPressureSensorVO;
import com.example.dampouring.query.WaterPressureSensorQue;
import com.example.dampouring.service.WaterPressureSensorService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterPressureSensorServiceImpl implements WaterPressureSensorService {
    @Autowired
    WaterPressureSensorMapper waterPressureSensorMapper;
    private void checkData(Integer cuId,Integer channelNo1,Integer channelNo2)
    {
        if(channelNo1==channelNo2)
            throw new DamPourException(30000,"不能使用同一测控单元下相同的通道号");
        List<WaterPressureSensor> waterPressureSensorList = waterPressureSensorMapper.selectListByCuId(cuId);
        if(waterPressureSensorList.size()!=0)
            throw new DamPourException(30000,"一个仓只有一根水管");
    }
    @Override
    public void add(AddWaterPressureSensorReq addWaterPressureSensorReq, String userName) {
//        checkData(addWaterPressureSensorReq.getCuId(),addWaterPressureSensorReq.getEnterChannelNo(),
//                addWaterPressureSensorReq.getExitChannelNo());
        WaterPressureSensor waterPressureSensor = new WaterPressureSensor();
        BeanUtils.copyProperties(addWaterPressureSensorReq,waterPressureSensor);
        waterPressureSensor.setOperator(userName);
        waterPressureSensor.setCreateTime(TimeUtils.getNowTime());
        int count = waterPressureSensorMapper.insertSelective(waterPressureSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateWaterPressureSensorReq updateWaterPressureSensorReq){
        checkData(updateWaterPressureSensorReq.getCuId(),updateWaterPressureSensorReq.getEnterChannelNo(),
                updateWaterPressureSensorReq.getExitChannelNo());
        WaterPressureSensor waterPressureSensor =
                waterPressureSensorMapper.selectByPrimaryKey(updateWaterPressureSensorReq.getId());
        if (waterPressureSensor == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }

        BeanUtils.copyProperties(updateWaterPressureSensorReq,waterPressureSensor);

        int count = waterPressureSensorMapper.updateByPrimaryKeySelective(waterPressureSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = waterPressureSensorMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WaterPressureSensorVO> waterPressureSensorList = waterPressureSensorMapper.selectList();
        PageInfo pageInfo = new PageInfo(waterPressureSensorList);
        return pageInfo;
    }

    @Override
    public List<WaterPressureSensorVO> listByIds(Integer[] ids) {
        List<WaterPressureSensorVO> categoryList = waterPressureSensorMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<WaterPressureSensorVO> exportList() {
        List<WaterPressureSensorVO> waterPressureSensorList = waterPressureSensorMapper.selectList();

        return waterPressureSensorList;
    }

    @Override
    public PageInfo select(WaterPressureSensorQue waterReversingDeviceQue) {
        PageHelper.startPage(waterReversingDeviceQue.getPageNum(), waterReversingDeviceQue.getPageSize());
        List<WaterPressureSensorVO> waterPressureSensorList = waterPressureSensorMapper.selectListByQue(waterReversingDeviceQue);
        PageInfo pageInfo = new PageInfo(waterPressureSensorList);
        return pageInfo;
    }
}
