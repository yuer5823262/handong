package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.ControlUnitMapper;
import com.example.dampouring.model.dao.TempGradometerMapper;
import com.example.dampouring.model.pojo.ControlUnit;
import com.example.dampouring.model.pojo.InnerTempSensor;
import com.example.dampouring.model.pojo.TempGradometer;
import com.example.dampouring.model.request.AddTempGradometerReq;
import com.example.dampouring.model.request.UpdateTempGradometerReq;
import com.example.dampouring.model.vo.TempGradometerVO;
import com.example.dampouring.query.TempGradometerQue;
import com.example.dampouring.service.TempGradometerService;
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
public class TempGradometerServiceImpl implements TempGradometerService {
    @Autowired
    TempGradometerMapper tempGradometerMapper;
    @Autowired
    ControlUnitMapper controlUnitMapper;
    private void checkData(Integer cuId,Integer channelNo)
    {
        List<TempGradometer> tempGradometerList = tempGradometerMapper.selectByCuIdCNo(cuId,channelNo);
        if(tempGradometerList.size()!=0)
            throw new DamPourException(30000,"不能使用同一测控单元下相同的通道号");
    }
    @Override
    public void add(AddTempGradometerReq addTempGradometerReq, String userName) {
//        checkData(addTempGradometerReq.getCuId(),addTempGradometerReq.getChannelNo());
        TempGradometer TempGradometerCheck = tempGradometerMapper.selectByTgmName(addTempGradometerReq.getTgmName());
        if (TempGradometerCheck != null) {
            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        TempGradometer tempGradometer = new TempGradometer();
        BeanUtils.copyProperties(addTempGradometerReq,tempGradometer);
        tempGradometer.setOperator(userName);
        tempGradometer.setCreateTime(TimeUtils.getNowTime());
        List<Integer> cList = updateChannel(tempGradometer);
        if(cList!=null)
        {
            StringBuffer test = new StringBuffer();
            cList.forEach(t->test.append(t+","));
            test.deleteCharAt(test.length()-1);
            tempGradometer.setChannel(test.toString());
        }
        int count = tempGradometerMapper.insertSelective(tempGradometer);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateTempGradometerReq updateTempGradometerReq){
//        checkData(updateTempGradometerReq.getCuId(),updateTempGradometerReq.getChannelNo());
        TempGradometer tempGradometer =
                tempGradometerMapper.selectByPrimaryKey(updateTempGradometerReq.getId());
        if (tempGradometer == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        TempGradometer tempGradometerCheck =
                tempGradometerMapper.selectByTgmName(updateTempGradometerReq.getTgmName());
        if (tempGradometerCheck != null &&
                !tempGradometerCheck.getTgmName().equals(tempGradometer.getTgmName()) ) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BeanUtils.copyProperties(updateTempGradometerReq,tempGradometer);
//        List<Integer> cList = updateChannel(tempGradometer);
//        if(cList!=null)
//        {
//            StringBuffer test = new StringBuffer();
//            cList.forEach(t->test.append(t+","));
//            test.deleteCharAt(test.length()-1);
//            tempGradometer.setChannel(test.toString());
//        }
        int count = tempGradometerMapper.updateByPrimaryKeySelective(tempGradometer);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = tempGradometerMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(TempGradometerQue tempGradometerQue) {
        PageHelper.startPage(tempGradometerQue.getPageNum(), tempGradometerQue.getPageSize());
        List<TempGradometerVO> tempGradometerList = tempGradometerMapper.selectList(tempGradometerQue);
        PageInfo pageInfo = new PageInfo(tempGradometerList);
        return pageInfo;
    }

    @Override
    public List<TempGradometerVO> listByIds(Integer[] ids) {
        List<TempGradometerVO> categoryList = tempGradometerMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<TempGradometerVO> exportList() {
        List<TempGradometerVO> tempGradometerList = tempGradometerMapper.selectList(new TempGradometerQue());
        return tempGradometerList;
    }

    public List<Integer> updateChannel(TempGradometer tempGradometer)
    {
        if(Constant.pSta!=0) return null;
        ControlUnit controlUnit=controlUnitMapper.selectByPrimaryKey(tempGradometer.getCuId());
        List<String> addr = new ArrayList<>();
        addr.add(tempGradometer.getAddr1());
        addr.add(tempGradometer.getAddr2());
        addr.add(tempGradometer.getAddr3());
        addr.add(tempGradometer.getAddr4());
        addr.add(tempGradometer.getAddr5());
        addr.add(tempGradometer.getAddr6());
        return Constant.DllUTILS.getTempSensorChannel(Integer.parseInt(controlUnit.getCuAddr()),tempGradometer.getChannelNo(),addr
        );
    }

    @Override
    public void updateChannelAll()
    {
        List<TempGradometer> tempGradometerList=tempGradometerMapper.listByUseful();
        for(TempGradometer tempGradometer:tempGradometerList)
        {
            List<Integer> cList = updateChannel(tempGradometer);
            if(cList!=null)
                System.out.println(cList.get(0));
            if(cList!=null)
            {
                StringBuffer test = new StringBuffer();
                cList.forEach(t->test.append(t+","));
                test.deleteCharAt(test.length()-1);
                tempGradometer.setChannel(test.toString());
            }
            tempGradometerMapper.updateByPrimaryKeySelective(tempGradometer);
        }
    }
}
