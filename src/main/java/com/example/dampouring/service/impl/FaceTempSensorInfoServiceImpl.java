package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.FaceTempSensorInfoMapper;
import com.example.dampouring.model.dao.InnerTempSensorMapper;
import com.example.dampouring.model.pojo.FaceTempSensorInfo;

import com.example.dampouring.model.request.InnerTempSensorInfoAdd;
import com.example.dampouring.model.request.RemoteDev;
import com.example.dampouring.model.request.RemoteDevData;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.DamTempQue;
import com.example.dampouring.query.InnerTempSensorInfoQue;
import com.example.dampouring.query.TopTempAssessQue;
import com.example.dampouring.service.FaceTempSensorInfoService;
import com.example.dampouring.service.MaxTempAlertService;
import com.example.dampouring.service.StorageColdAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.DoubleUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaceTempSensorInfoServiceImpl implements FaceTempSensorInfoService {
    @Autowired
    FaceTempSensorInfoMapper FaceTempSensorInfoMapper;
    @Autowired
    InnerTempSensorMapper innerTempSensorMapper;
    @Autowired
    MaxTempAlertService maxTempAlertService;
    @Autowired
    com.example.dampouring.model.dao.MaxTempAlertMapper MaxTempAlertMapper;
    @Autowired
    StorageColdAlertService storageColdAlertService;
    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<InnerTempSensorInfoVO> FaceTempSensorInfo = FaceTempSensorInfoMapper.List();
        PageInfo pageInfo = new PageInfo(FaceTempSensorInfo);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(InnerTempSensorInfoQue FaceTempSensorInfoQue) {
        PageHelper.startPage(FaceTempSensorInfoQue.getPageNum(), FaceTempSensorInfoQue.getPageSize());
        List<InnerTempSensorInfoVO> FaceTempSensorInfo = FaceTempSensorInfoMapper.selectList(FaceTempSensorInfoQue);
        PageInfo pageInfo = new PageInfo(FaceTempSensorInfo);
        return pageInfo;
    }

    @Override
    public PageInfo CoolingRate(InnerTempSensorInfoQue FaceTempSensorInfoQue) {
        PageHelper.startPage(FaceTempSensorInfoQue.getPageNum(), FaceTempSensorInfoQue.getPageSize());
        List<CoolingRateVo> coolingRateVos = FaceTempSensorInfoMapper.coolingRate(FaceTempSensorInfoQue);
        for(int i=coolingRateVos.size()-1;i>0;i--){
            Double a1 = coolingRateVos.get(i-1).getTemp();
            Double a2 = coolingRateVos.get(i).getTemp();
            if(a1==null || a2==null) continue;
            double temp = a1-a2;
            temp = DoubleUtil.bl2w(temp);
            coolingRateVos.get(i).setTemp(temp);
        }
        if(coolingRateVos.size()!=0)
            coolingRateVos.remove(0);
        PageInfo pageInfo = new PageInfo(coolingRateVos);
        return pageInfo;
    }

    @Override
    public List<CoolingRateVo> CoolingRateExportList(InnerTempSensorInfoQue FaceTempSensorInfoQue) {
        List<CoolingRateVo> coolingRateVos = FaceTempSensorInfoMapper.coolingRate(FaceTempSensorInfoQue);
        for(int i=coolingRateVos.size()-1;i>0;i--){
            double temp = coolingRateVos.get(i-1).getTemp()-coolingRateVos.get(i).getTemp();
            temp = DoubleUtil.bl2w(temp);
            coolingRateVos.get(i).setTemp(temp);
        }
        if(coolingRateVos.size()!=0)
            coolingRateVos.remove(0);
        return coolingRateVos;
    }

    @Override
    public PageInfo maxTemp(TopTempAssessQue topTempAssessQue) {
        PageHelper.startPage(topTempAssessQue.getPageNum(), topTempAssessQue.getPageSize());
        List<TopTempAssessVO> FaceTempSensorInfo = FaceTempSensorInfoMapper.maxTemp(topTempAssessQue);
        PageInfo pageInfo = new PageInfo(FaceTempSensorInfo);
        return pageInfo;
    }

    @Override
    public List<InnerTempSensorInfoVO> exportList() {
        List<InnerTempSensorInfoVO> FaceTempSensorInfo = FaceTempSensorInfoMapper.List();

        return FaceTempSensorInfo;
    }

    @Override
    public void add(InnerTempSensorInfoAdd FaceTempSensorInfoAdd) {
        FaceTempSensorInfo FaceTempSensorInfo = new FaceTempSensorInfo();
        BeanUtils.copyProperties(FaceTempSensorInfoAdd,FaceTempSensorInfo);
        FaceTempSensorInfo.setTime(TimeUtils.getNowTime());
        int count = FaceTempSensorInfoMapper.insertSelective(FaceTempSensorInfo);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
    }

    @Override
    public List<DamTempVO> damTemp(DamTempQue damTempQue) {
        List<DamTempVO> damTempVOList = FaceTempSensorInfoMapper.damTemp(damTempQue);
        return damTempVOList;
    }

    @Override
    public List<InnerTempMonitorVO> tempMonitor() {
        List<InnerTempMonitorVO> innerTempMonitorVOList = FaceTempSensorInfoMapper.tempMonitor();
        return innerTempMonitorVOList;
    }

    @Override
    public void addAll(List<FaceTempSensorInfo> list) {
        for(FaceTempSensorInfo FaceTempSensorInfo:list)
        {
            FaceTempSensorInfoMapper.insertSelective(FaceTempSensorInfo);
        }
    }

    @Override
    @Async
    public void timeAvgTemp(String time) {
        List<InnerTempSensorInfoVO> FaceTempSensorInfoVOList = FaceTempSensorInfoMapper.timeAvgTemp(time);

        for(InnerTempSensorInfoVO FaceTempSensorInfoVO:FaceTempSensorInfoVOList)
        {
            FaceTempSensorInfo FaceTempSensorInfo = new FaceTempSensorInfo();
            FaceTempSensorInfo.setId(FaceTempSensorInfoVO.getId());
            ConnectionUtil.Send(FaceTempSensorInfoVO.toMqStr());
            if(FaceTempSensorInfoVO.getAvgTemp()==null) continue;
            FaceTempSensorInfo.setAvgtemp(FaceTempSensorInfoVO.getAvgTemp());
            FaceTempSensorInfoMapper.updateByPrimaryKeySelective(FaceTempSensorInfo);
        }
    }

    @Override
    public void addByRemoteDev(RemoteDev remoteDev) {
        List<RemoteDevData> remoteDevDataList = remoteDev.getDatas();
        String time = TimeUtils.LongTOTime(remoteDev.getTime()*1000);
        for(RemoteDevData remoteDevData:remoteDevDataList)
        {
            List<InnerTempSensorVO> innerTempSensorList = innerTempSensorMapper.selectByRemoteDev(remoteDev.getDevice_id(),remoteDevData.getCh());
            for(InnerTempSensorVO innerTempSensor:innerTempSensorList)
            {
                if(remoteDevData.getData()==0) continue;
                FaceTempSensorInfo FaceTempSensorInfo = new FaceTempSensorInfo();
                FaceTempSensorInfo.setTemp(remoteDevData.getData());
                FaceTempSensorInfo.setTime(time);
                FaceTempSensorInfo.setInnerTempSensorId(innerTempSensor.getId());
                FaceTempSensorInfo FaceTempSensorInfoTemp = FaceTempSensorInfoMapper.selectBySIdAndTime(FaceTempSensorInfo.getInnerTempSensorId(),FaceTempSensorInfo.getTime());
                if(FaceTempSensorInfoTemp!=null)
                {
                    FaceTempSensorInfoTemp.setTemp(FaceTempSensorInfo.getTemp());
                    FaceTempSensorInfoMapper.updateByPrimaryKeySelective(FaceTempSensorInfoTemp);
                    continue;
                }
                FaceTempSensorInfoMapper.insertSelective(FaceTempSensorInfo);
                Constant.print(innerTempSensor.getSmallNo()+"下测控装置为"+remoteDev.getDevice_id()+
                        ",通道号为"+innerTempSensor.getChannel()+",编号为"+innerTempSensor.getTempNo()+
                        "的内部温度计获取到温度数据:"+remoteDevData.getData());
            }

        }
        timeAvgTemp(time);
    }

    @Override
    public List<InnerTempSensorInfoVO> exportListByque(InnerTempSensorInfoQue FaceTempSensorInfoQue) {
        return FaceTempSensorInfoMapper.selectList(FaceTempSensorInfoQue);
    }
    
}
