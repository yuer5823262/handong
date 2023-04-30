package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.WaterReversingDeviceMapper;
import com.example.dampouring.model.pojo.InnerTempSensor;
import com.example.dampouring.model.pojo.WaterReversingDevice;
import com.example.dampouring.model.request.AddWaterReversingDeviceReq;
import com.example.dampouring.model.request.UpdateWaterReversingDeviceReq;
import com.example.dampouring.model.vo.WaterReversingDeviceVO;
import com.example.dampouring.query.WaterReversingDeviceQue;
import com.example.dampouring.service.WaterReversingDeviceService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterReversingDeviceServiceImpl implements WaterReversingDeviceService {
    @Autowired
    WaterReversingDeviceMapper waterReversingDeviceMapper;
    private void checkData(Integer cuId,Integer channelNo)
    {
        List<WaterReversingDevice> waterReversingDevices = waterReversingDeviceMapper.selectByCuIdCNo(cuId,channelNo);
        if(waterReversingDevices.size()!=0)
            throw new DamPourException(30000,"不能使用同一测控单元下相同的通道号");
    }
    @Override
    public void add(AddWaterReversingDeviceReq addWaterReversingDeviceReq, String userName) {
//        checkData(addWaterReversingDeviceReq.getCuId(),addWaterReversingDeviceReq.getChannelNo());
        WaterReversingDevice waterReversingDevice = new WaterReversingDevice();
        BeanUtils.copyProperties(addWaterReversingDeviceReq,waterReversingDevice);
        waterReversingDevice.setOperator(userName);
        waterReversingDevice.setCreateTime(TimeUtils.getNowTime());
        int count = waterReversingDeviceMapper.insertSelective(waterReversingDevice);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateWaterReversingDeviceReq updateWaterReversingDeviceReq){
        checkData(updateWaterReversingDeviceReq.getCuId(),updateWaterReversingDeviceReq.getChannelNo());
        WaterReversingDevice waterReversingDevice =
                waterReversingDeviceMapper.selectByPrimaryKey(updateWaterReversingDeviceReq.getId());
        if (waterReversingDevice == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateWaterReversingDeviceReq,waterReversingDevice);

        int count = waterReversingDeviceMapper.updateByPrimaryKeySelective(waterReversingDevice);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = waterReversingDeviceMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WaterReversingDeviceVO> waterReversingDeviceList = waterReversingDeviceMapper.selectList();
        PageInfo pageInfo = new PageInfo(waterReversingDeviceList);
        return pageInfo;
    }

    @Override
    public List<WaterReversingDeviceVO> listByIds(Integer[] ids) {
        List<WaterReversingDeviceVO> categoryList = waterReversingDeviceMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<WaterReversingDeviceVO> exportList() {
        List<WaterReversingDeviceVO> waterReversingDeviceList = waterReversingDeviceMapper.selectList();
        return waterReversingDeviceList;
    }

    @Override
    public PageInfo select(WaterReversingDeviceQue waterReversingDeviceQue) {
        PageHelper.startPage(waterReversingDeviceQue.getPageNum(), waterReversingDeviceQue.getPageSize());
        List<WaterReversingDeviceVO> waterReversingDeviceList = waterReversingDeviceMapper.selectListByQue(waterReversingDeviceQue);
        PageInfo pageInfo = new PageInfo(waterReversingDeviceList);
        return pageInfo;
    }
}
