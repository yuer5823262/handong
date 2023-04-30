package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.ControlUnitMapper;
import com.example.dampouring.model.dao.WaterTempSensorMapper;
import com.example.dampouring.model.pojo.ControlUnit;
import com.example.dampouring.model.pojo.InnerTempSensor;
import com.example.dampouring.model.pojo.WaterTempSensor;
import com.example.dampouring.model.request.AddWaterTempSensorReq;
import com.example.dampouring.model.request.UpdateWaterTempSensorReq;
import com.example.dampouring.model.vo.WaterPressureSensorVO;
import com.example.dampouring.model.vo.WaterTempSensorVO;
import com.example.dampouring.query.WaterPressureSensorQue;
import com.example.dampouring.service.WaterTempSensorService;
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
public class WaterTempSensorServiceImpl implements WaterTempSensorService {
    @Autowired
    WaterTempSensorMapper waterTempSensorMapper;
    @Autowired
    ControlUnitMapper controlUnitMapper;
    private void checkData(Integer cuId,Integer channelNo1,Integer channelNo2)
    {
        if(channelNo1==channelNo2)
            throw new DamPourException(30000,"不能使用同一测控单元下相同的通道号");
        List<WaterTempSensor> waterTempSensorList = waterTempSensorMapper.selectListByCuId(cuId);
        if(waterTempSensorList.size()!=0)
            throw new DamPourException(30000,"一个仓只有一根水管");
    }


    @Override
    public void add(AddWaterTempSensorReq addWaterTempSensorReq, String userName) {
        WaterTempSensor WaterTempSensor = new WaterTempSensor();
        BeanUtils.copyProperties(addWaterTempSensorReq,WaterTempSensor);
        WaterTempSensor.setOperator(userName);
        WaterTempSensor.setCreateTime(TimeUtils.getNowTime());

        List<Integer> cList = updateChannel(WaterTempSensor,1);
        if(cList!=null)
            System.out.println(cList.get(0));
        if(cList!=null&&cList.get(0)!=-1) WaterTempSensor.setEnterChannel(cList.get(0));
        cList = updateChannel(WaterTempSensor,2);
        if(cList!=null)
            System.out.println(cList.get(0));
        if(cList!=null&&cList.get(0)!=-1) WaterTempSensor.setExitChannel(cList.get(0));

        int count = waterTempSensorMapper.insertSelective(WaterTempSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateWaterTempSensorReq updateWaterTempSensorReq){
//        checkData(updateWaterTempSensorReq.getCuId(),updateWaterTempSensorReq.getEnterChannelNo(),
//                updateWaterTempSensorReq.getExitChannelNo());
        WaterTempSensor WaterTempSensor =
                waterTempSensorMapper.selectByPrimaryKey(updateWaterTempSensorReq.getId());
        if (WaterTempSensor == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }

        BeanUtils.copyProperties(updateWaterTempSensorReq,WaterTempSensor);
//        List<Integer> cList = updateChannel(WaterTempSensor,1);
//        if(cList!=null)
//            System.out.println(cList.get(0));
//        if(cList!=null&&cList.get(0)!=-1) WaterTempSensor.setEnterChannel(cList.get(0));
//        cList = updateChannel(WaterTempSensor,2);
//        if(cList!=null)
//            System.out.println(cList.get(0));
//        if(cList!=null&&cList.get(0)!=-1) WaterTempSensor.setExitChannel(cList.get(0));
        int count = waterTempSensorMapper.updateByPrimaryKeySelective(WaterTempSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = waterTempSensorMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WaterTempSensorVO> waterTempSensorList = waterTempSensorMapper.selectList();
        PageInfo pageInfo = new PageInfo(waterTempSensorList);
        return pageInfo;
    }

    @Override
    public List<WaterTempSensorVO> listByIds(Integer[] ids) {
        List<WaterTempSensorVO> categoryList = waterTempSensorMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<WaterTempSensorVO> exportList() {
        List<WaterTempSensorVO> waterTempSensorList = waterTempSensorMapper.selectList();
        return waterTempSensorList;
    }

    public List<Integer> updateChannel(WaterTempSensor waterTempSensor,Integer t)
    {
        if(Constant.pSta!=0) return null;
        ControlUnit controlUnit=controlUnitMapper.selectByPrimaryKey(waterTempSensor.getCuId());
        List<String> addr = new ArrayList<>();
        if(t==1)
        {
            addr.add(waterTempSensor.getEnterAddr());
            return Constant.DllUTILS.getTempSensorChannel(Integer.parseInt(controlUnit.getCuAddr()),waterTempSensor.getEnterChannelNo(),addr
            );
        }
        else
        {
            addr.add(waterTempSensor.getExitAddr());
            return Constant.DllUTILS.getTempSensorChannel(Integer.parseInt(controlUnit.getCuAddr()),waterTempSensor.getExitChannelNo(),addr
            );
        }


    }

    @Override
    public void updateChannelAll()
    {
        List<WaterTempSensor> airTempSensors=waterTempSensorMapper.listByUseful();
        for(WaterTempSensor waterTempSensor:airTempSensors)
        {
            List<Integer> cList = updateChannel(waterTempSensor,1);
            if(cList!=null)
                System.out.println(cList.get(0));
            if(cList!=null&&cList.get(0)!=-1) waterTempSensor.setEnterChannel(cList.get(0));
            cList = updateChannel(waterTempSensor,2);
            if(cList!=null)
                System.out.println(cList.get(0));
            if(cList!=null&&cList.get(0)!=-1) waterTempSensor.setExitChannel(cList.get(0));
            waterTempSensorMapper.updateByPrimaryKeySelective(waterTempSensor);
        }
    }

    @Override
    public PageInfo select(WaterPressureSensorQue waterReversingDeviceQue) {
        PageHelper.startPage(waterReversingDeviceQue.getPageNum(), waterReversingDeviceQue.getPageSize());
        List<WaterTempSensor> waterPressureSensorList = waterTempSensorMapper.selectListByQue(waterReversingDeviceQue);
        PageInfo pageInfo = new PageInfo(waterPressureSensorList);
        return pageInfo;
    }
}
