package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.ControlUnitMapper;
import com.example.dampouring.model.dao.MixingSensorMapper;
import com.example.dampouring.model.pojo.ControlUnit;
import com.example.dampouring.model.pojo.InnerTempSensor;
import com.example.dampouring.model.pojo.MixingSensor;
import com.example.dampouring.model.request.AddMixingSensorReq;
import com.example.dampouring.model.request.UpdateMixingSensorReq;
import com.example.dampouring.model.vo.MixingSensorVO;
import com.example.dampouring.query.MixingSensorInfoQue;
import com.example.dampouring.service.MixingSensorService;
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
public class MixingSensorServiceImpl implements MixingSensorService {
    @Autowired
    MixingSensorMapper MixingSensorMapper;
    @Autowired
    ControlUnitMapper controlUnitMapper;
    private void checkData(Integer cuId,Integer channelNo)
    {
        List<MixingSensor> mixingSensorList = MixingSensorMapper.selectByCuIdCNo(cuId,channelNo);
        if(mixingSensorList.size()!=0)
            throw new DamPourException(30000,"不能使用同一测控单元下相同的通道号");
    }
    @Override
    public void add(AddMixingSensorReq addMixingSensorReq, String userName) {
//        checkData(addMixingSensorReq.getCuId(),addMixingSensorReq.getChannelNo());
        MixingSensor MixingSensorCheck = MixingSensorMapper.selectByTempNo(addMixingSensorReq.getNo());
        if (MixingSensorCheck != null) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        MixingSensor MixingSensor = new MixingSensor();
        BeanUtils.copyProperties(addMixingSensorReq,MixingSensor);
        MixingSensor.setOperator(userName);
        MixingSensor.setCreateTime(TimeUtils.getNowTime());
        List<Integer> cList = updateChannel(MixingSensor);
        if(cList!=null)
            System.out.println(cList.get(0));
        if(cList!=null&&cList.get(0)!=-1) MixingSensor.setChannel(cList.get(0));
        int count = MixingSensorMapper.insertSelective(MixingSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateMixingSensorReq updateMixingSensorReq){
//        checkData(updateMixingSensorReq.getCuId(),updateMixingSensorReq.getChannelNo());
        MixingSensor MixingSensor =
                MixingSensorMapper.selectByPrimaryKey(updateMixingSensorReq.getId());
        if (MixingSensor == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        MixingSensor MixingSensorCheck =
                MixingSensorMapper.selectByTempNo(updateMixingSensorReq.getNo());
        if (MixingSensorCheck != null &&
                !MixingSensorCheck.getNo().equals(MixingSensor.getNo()) ) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BeanUtils.copyProperties(updateMixingSensorReq,MixingSensor);
//        List<Integer> cList = updateChannel(MixingSensor);
//        if(cList!=null)
//            System.out.println(cList.get(0));
//        if(cList!=null&&cList.get(0)!=-1) MixingSensor.setChannel(cList.get(0));
        int count = MixingSensorMapper.updateByPrimaryKeySelective(MixingSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = MixingSensorMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(MixingSensorInfoQue MixingSensorInfoQue) {
        PageHelper.startPage(MixingSensorInfoQue.getPageNum(), MixingSensorInfoQue.getPageSize());
        List<MixingSensorVO> MixingSensorList = MixingSensorMapper.selectList(MixingSensorInfoQue);
        PageInfo pageInfo = new PageInfo(MixingSensorList);
        return pageInfo;
    }

    @Override
    public List<MixingSensorVO> listByIds(Integer[] ids) {
        List<MixingSensorVO> categoryList = MixingSensorMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<MixingSensorVO> exportList() {
        List<MixingSensorVO> MixingSensorList = MixingSensorMapper.selectList(new MixingSensorInfoQue());
        return MixingSensorList;
    }

    public List<Integer> updateChannel(MixingSensor mixingSensor)
    {
        if(Constant.pSta!=0) return null;
        ControlUnit controlUnit=controlUnitMapper.selectByPrimaryKey(mixingSensor.getCuId());
        List<String> addr = new ArrayList<>();
        addr.add(mixingSensor.getAddr());
        return Constant.DllUTILS.getTempSensorChannel(Integer.parseInt(controlUnit.getCuAddr()),mixingSensor.getChannelNo(),addr
        );
    }

    @Override
    public void updateChannelAll()
    {
        List<MixingSensor> airTempSensors=MixingSensorMapper.list();
        for(MixingSensor mixingSensor:airTempSensors)
        {
            List<Integer> cList = updateChannel(mixingSensor);
            if(cList!=null)
                System.out.println(cList.get(0));
            if(cList!=null&&cList.get(0)!=-1) mixingSensor.setChannel(cList.get(0));
            MixingSensorMapper.updateByPrimaryKeySelective(mixingSensor);
        }
    }
}
