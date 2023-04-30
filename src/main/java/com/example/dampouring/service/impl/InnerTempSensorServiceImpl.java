package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.ControlUnitMapper;
import com.example.dampouring.model.dao.InnerTempSensorMapper;
import com.example.dampouring.model.pojo.AirTempSensor;
import com.example.dampouring.model.pojo.ControlUnit;
import com.example.dampouring.model.pojo.InnerTempSensor;
import com.example.dampouring.model.request.AddInnerTempSensorReq;
import com.example.dampouring.model.request.UpdateInnerTempSensorReq;
import com.example.dampouring.model.vo.InnerTempSensorVO;
import com.example.dampouring.query.InnerTempSensorInfoQue;
import com.example.dampouring.query.InnerTempSensorQue;
import com.example.dampouring.service.InnerTempSensorService;
import com.example.dampouring.util.DllUtils;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InnerTempSensorServiceImpl implements InnerTempSensorService {
    @Autowired
    InnerTempSensorMapper innerTempSensorMapper;
    @Autowired
    ControlUnitMapper controlUnitMapper;
    private void checkData(Integer cuId,Integer channelNo)
    {
        List<InnerTempSensor> innerTempSensorList = innerTempSensorMapper.selectByCuIdCNo(cuId,channelNo);
        if(innerTempSensorList.size()!=0)
            throw new DamPourException(30000,"不能使用同一测控单元下相同的通道号");
    }
    @Override
    public void add(AddInnerTempSensorReq addInnerTempSensorReq, String userName) {
        InnerTempSensor innerTempSensorCheck = innerTempSensorMapper.selectByTempNo(addInnerTempSensorReq.getTempNo());
        if (innerTempSensorCheck != null) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        InnerTempSensor innerTempSensor = new InnerTempSensor();
        BeanUtils.copyProperties(addInnerTempSensorReq,innerTempSensor);
        innerTempSensor.setOperator(userName);
        innerTempSensor.setCreateTime(TimeUtils.getNowTime());
        if(innerTempSensor.getChannelNo()!=null)
        {
            List<Integer> cList = updateChannel(innerTempSensor);
            if(cList!=null&&cList.get(0)!=-1) innerTempSensor.setChannel(cList.get(0));
        }
        int count = innerTempSensorMapper.insertSelective(innerTempSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
    }
    @Override
    public void update(UpdateInnerTempSensorReq updateInnerTempSensorReq){
//        if(updateInnerTempSensorReq.getCuId()!=null&&updateInnerTempSensorReq.getChannelNo()!=null)
//            checkData(updateInnerTempSensorReq.getCuId(),updateInnerTempSensorReq.getChannelNo());
        InnerTempSensor innerTempSensor =
                innerTempSensorMapper.selectByPrimaryKey(updateInnerTempSensorReq.getId());
        if (innerTempSensor == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        InnerTempSensor innerTempSensorCheck =
                innerTempSensorMapper.selectByTempNo(updateInnerTempSensorReq.getTempNo());
        if (innerTempSensorCheck != null &&
                !innerTempSensorCheck.getTempNo().equals(innerTempSensor.getTempNo()) ) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BeanUtils.copyProperties(updateInnerTempSensorReq,innerTempSensor);
//        if(innerTempSensor.getChannelNo()!=null)
//        {
//            List<Integer> cList = updateChannel(innerTempSensor);
//            if(cList!=null&&cList.get(0)!=-1) innerTempSensor.setChannel(cList.get(0));
//        }
        int count = innerTempSensorMapper.updateByPrimaryKeySelective(innerTempSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = innerTempSensorMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(InnerTempSensorQue innerTempSensorQue) {
        PageHelper.startPage(innerTempSensorQue.getPageNum(), innerTempSensorQue.getPageSize());
        List<InnerTempSensorVO> InnerTempSensorList = innerTempSensorMapper.selectList(innerTempSensorQue);
        PageInfo pageInfo = new PageInfo(InnerTempSensorList);
        return pageInfo;
    }

    @Override
    public List<InnerTempSensorVO> listByIds(Integer[] ids) {
        List<InnerTempSensorVO> categoryList = innerTempSensorMapper.selectListByIds(ids);
        return categoryList;
    }

    @Override
    public List<InnerTempSensorVO> exportList() {
        List<InnerTempSensorVO> InnerTempSensorList = innerTempSensorMapper.selectList(new InnerTempSensorQue());

        return InnerTempSensorList;
    }

    public List<Integer> updateChannel(InnerTempSensor innerTempSensor)
    {
        Constant.print("pSta"+Constant.pSta);
        if(Constant.pSta!=0) return null;
        ControlUnit controlUnit=controlUnitMapper.selectByPrimaryKey(innerTempSensor.getCuId());
        List<String> addr = new ArrayList<>();
        addr.add(innerTempSensor.getTempAddr());
        return Constant.DllUTILS.getTempSensorChannel(Integer.parseInt(controlUnit.getCuAddr()),innerTempSensor.getChannelNo(),addr
        );
    }

    @Override
    public void updateChannelAll()
    {
        Constant.print("updateChannelAll");
        List<InnerTempSensor> airTempSensors=innerTempSensorMapper.listByUseful();
        for(InnerTempSensor innerTempSensor:airTempSensors)
        {
            List<Integer> cList = updateChannel(innerTempSensor);
            Constant.print("cList:"+cList.get(0));
            if(cList!=null)
                System.out.println(cList.get(0));
            if(cList!=null&&cList.get(0)!=-1) innerTempSensor.setChannel(cList.get(0));
            innerTempSensorMapper.updateByPrimaryKeySelective(innerTempSensor);
        }
    }
}
