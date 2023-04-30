package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.ControlUnitMapper;
import com.example.dampouring.model.dao.InsulationSensorMapper;
import com.example.dampouring.model.pojo.ControlUnit;
import com.example.dampouring.model.pojo.InsulationSensor;
import com.example.dampouring.model.request.AddInsulationSensorReq;
import com.example.dampouring.model.request.UpdateInsulationSensorReq;
import com.example.dampouring.model.vo.InsulationSensorVO;
import com.example.dampouring.query.InsulationSensorQue;
import com.example.dampouring.service.InsulationSensorService;
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
public class InsulationSensorServiceImpl implements InsulationSensorService {
    @Autowired
    InsulationSensorMapper InsulationSensorMapper;
    @Autowired
    ControlUnitMapper controlUnitMapper;
//    private void checkData(Integer cuId,Integer channelNo)
//    {
//        List<InsulationSensor> InsulationSensorList = InsulationSensorMapper.selectByCuIdCNo(cuId,channelNo);
//        if(InsulationSensorList.size()!=0)
//            throw new DamPourException(30000,"不能使用同一测控单元下相同的通道号");
//    }
    @Override
    public void add(AddInsulationSensorReq addInsulationSensorReq, String userName) {
        InsulationSensor InsulationSensorCheck = InsulationSensorMapper.selectByTempNo(addInsulationSensorReq.getTempNo());
        if (InsulationSensorCheck != null) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        InsulationSensor InsulationSensor = new InsulationSensor();
        BeanUtils.copyProperties(addInsulationSensorReq,InsulationSensor);
        InsulationSensor.setOperator(userName);
        InsulationSensor.setCreateTime(TimeUtils.getNowTime());
        List<Integer> cList = updateChannel(InsulationSensor);
        if(cList!=null&&cList.get(0)!=-1) InsulationSensor.setChanel(cList.get(0));
        int count = InsulationSensorMapper.insertSelective(InsulationSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
    }
    @Override
    public void update(UpdateInsulationSensorReq updateInsulationSensorReq){
//        if(updateInsulationSensorReq.getCuId()!=null&&updateInsulationSensorReq.getChannelNo()!=null)
//            checkData(updateInsulationSensorReq.getCuId(),updateInsulationSensorReq.getChannelNo());
        InsulationSensor InsulationSensor =
                InsulationSensorMapper.selectByPrimaryKey(updateInsulationSensorReq.getId());
        if (InsulationSensor == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        InsulationSensor InsulationSensorCheck =
                InsulationSensorMapper.selectByTempNo(updateInsulationSensorReq.getTempNo());
        if (InsulationSensorCheck != null &&
                !InsulationSensorCheck.getTempNo().equals(InsulationSensor.getTempNo()) ) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BeanUtils.copyProperties(updateInsulationSensorReq,InsulationSensor);
//        List<Integer> cList = updateChannel(InsulationSensor);
//        if(cList!=null&&cList.get(0)!=-1) InsulationSensor.setChanel(cList.get(0));
        int count = InsulationSensorMapper.updateByPrimaryKeySelective(InsulationSensor);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = InsulationSensorMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(InsulationSensorQue InsulationSensorQue) {
        PageHelper.startPage(InsulationSensorQue.getPageNum(), InsulationSensorQue.getPageSize());
        List<InsulationSensorVO> InsulationSensorList = InsulationSensorMapper.selectList(InsulationSensorQue);
        PageInfo pageInfo = new PageInfo(InsulationSensorList);
        return pageInfo;
    }

    @Override
    public List<InsulationSensorVO> listByIds(Integer[] ids) {
        List<InsulationSensorVO> categoryList = InsulationSensorMapper.selectListByIds(ids);
        return categoryList;
    }

    @Override
    public List<InsulationSensorVO> exportList() {
        List<InsulationSensorVO> InsulationSensorList = InsulationSensorMapper.selectList(new InsulationSensorQue());
        return InsulationSensorList;
    }

    public List<Integer> updateChannel(InsulationSensor InsulationSensor)
    {
        if(Constant.pSta!=0) return null;
        ControlUnit controlUnit=controlUnitMapper.selectByPrimaryKey(InsulationSensor.getCuId());
        List<String> addr = new ArrayList<>();
        addr.add(InsulationSensor.getAddr());
        return Constant.DllUTILS.getTempSensorChannel(Integer.parseInt(controlUnit.getCuAddr()),InsulationSensor.getChanelNo(),addr
        );
    }

    @Override
    public void updateChannelAll()
    {
        List<InsulationSensor> airTempSensors=InsulationSensorMapper.listByUseful();
        for(InsulationSensor InsulationSensor:airTempSensors)
        {
            List<Integer> cList = updateChannel(InsulationSensor);
            if(cList!=null)
                System.out.println(cList.get(0));
            if(cList!=null&&cList.get(0)!=-1) InsulationSensor.setChanel(cList.get(0));
            InsulationSensorMapper.updateByPrimaryKeySelective(InsulationSensor);
        }
    }
}
