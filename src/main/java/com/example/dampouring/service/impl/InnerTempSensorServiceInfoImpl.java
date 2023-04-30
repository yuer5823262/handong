package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.InnerTempSensorInfoMapper;
import com.example.dampouring.model.dao.InnerTempSensorMapper;
import com.example.dampouring.model.dao.MaxTempAlertMapper;
import com.example.dampouring.model.pojo.InnerTempSensor;
import com.example.dampouring.model.pojo.InnerTempSensorInfo;
import com.example.dampouring.model.request.InnerTempSensorInfoAdd;
import com.example.dampouring.model.request.RemoteDev;
import com.example.dampouring.model.request.RemoteDevData;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.DamTempQue;
import com.example.dampouring.query.InnerTempSensorInfoQue;
import com.example.dampouring.query.TopTempAssessQue;
import com.example.dampouring.service.InnerTempSensorInfoService;
import com.example.dampouring.service.MaxTempAlertService;
import com.example.dampouring.service.StorageColdAlertService;
import com.example.dampouring.util.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
@Service
public class InnerTempSensorServiceInfoImpl implements InnerTempSensorInfoService {
    @Autowired
    InnerTempSensorInfoMapper innerTempSensorInfoMapper;
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
        List<InnerTempSensorInfoVO> InnerTempSensorInfo = innerTempSensorInfoMapper.List();
        PageInfo pageInfo = new PageInfo(InnerTempSensorInfo);
        return pageInfo;
    }


    @Override
    public PageInfo orUserSelect(InnerTempSensorInfoQue InnerTempSensorInfoQue) {
        PageHelper.startPage(InnerTempSensorInfoQue.getPageNum(), InnerTempSensorInfoQue.getPageSize());
        List<InnerTempSensorInfoVO> InnerTempSensorInfo = innerTempSensorInfoMapper.selectList(InnerTempSensorInfoQue);
        PageInfo pageInfo = new PageInfo(InnerTempSensorInfo);
        return pageInfo;
    }

    @Override
    public PageInfo CoolingRate(InnerTempSensorInfoQue innerTempSensorInfoQue) {
        PageHelper.startPage(innerTempSensorInfoQue.getPageNum(), innerTempSensorInfoQue.getPageSize());
        List<CoolingRateVo> coolingRateVos = innerTempSensorInfoMapper.coolingRate(innerTempSensorInfoQue);
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
    public List<CoolingRateVo> CoolingRateExportList(InnerTempSensorInfoQue innerTempSensorInfoQue) {
        List<CoolingRateVo> coolingRateVos = innerTempSensorInfoMapper.coolingRate(innerTempSensorInfoQue);
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
        List<TopTempAssessVO> InnerTempSensorInfo = innerTempSensorInfoMapper.maxTemp(topTempAssessQue);
        PageInfo pageInfo = new PageInfo(InnerTempSensorInfo);
        return pageInfo;
    }

    @Override
    public List<InnerTempSensorInfoVO> exportList() {
        List<InnerTempSensorInfoVO> InnerTempSensorInfo = innerTempSensorInfoMapper.List();

        return InnerTempSensorInfo;
    }

    @Override
    public void add(InnerTempSensorInfoAdd innerTempSensorInfoAdd) {
        InnerTempSensorInfo innerTempSensorInfo = new InnerTempSensorInfo();
        BeanUtils.copyProperties(innerTempSensorInfoAdd,innerTempSensorInfo);
        innerTempSensorInfo.setTime(TimeUtils.getNowTime());
        int count = innerTempSensorInfoMapper.insertSelective(innerTempSensorInfo);
        MaxTempNormVO maxTempNormVO = MaxTempAlertMapper.normInfo(innerTempSensorInfo.getInnerTempSensorId());
        maxTempAlertService.maxTempAlert(innerTempSensorInfo,maxTempNormVO);
//        storageColdAlertService.storageColdAlert(innerTempSensorInfo,maxTempNormVO);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
    }

    @Override
    public List<DamTempVO> damTemp(DamTempQue damTempQue) {
        List<DamTempVO> damTempVOList = innerTempSensorInfoMapper.damTemp(damTempQue);
        return damTempVOList;
    }

    @Override
    public List<InnerTempMonitorVO> tempMonitor() {
        List<InnerTempMonitorVO> innerTempMonitorVOList = innerTempSensorInfoMapper.tempMonitor();
        return innerTempMonitorVOList;
    }

    @Override
    public void addAll(List<InnerTempSensorInfo> list) {
        for(InnerTempSensorInfo innerTempSensorInfo:list)
        {
            innerTempSensorInfoMapper.insertSelective(innerTempSensorInfo);
        }
    }

    @Override
    @Async
    public void timeAvgTemp(String time) {
        List<InnerTempSensorInfoVO> innerTempSensorInfoVOList = innerTempSensorInfoMapper.timeAvgTemp(time);

        for(InnerTempSensorInfoVO innerTempSensorInfoVO:innerTempSensorInfoVOList)
        {
            InnerTempSensorInfo innerTempSensorInfo = new InnerTempSensorInfo();
            innerTempSensorInfo.setId(innerTempSensorInfoVO.getId());
            ConnectionUtil.Send(innerTempSensorInfoVO.toMqStr());
            if(innerTempSensorInfoVO.getAvgTemp()==null) continue;
            innerTempSensorInfo.setAvgTemp(innerTempSensorInfoVO.getAvgTemp());
            innerTempSensorInfoMapper.updateByPrimaryKeySelective(innerTempSensorInfo);
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
                InnerTempSensorInfo innerTempSensorInfo = new InnerTempSensorInfo();
                innerTempSensorInfo.setTemp(remoteDevData.getData());
                innerTempSensorInfo.setTime(time);
                innerTempSensorInfo.setInnerTempSensorId(innerTempSensor.getId());
                MaxTempNormVO maxTempNormVO = MaxTempAlertMapper.normInfo(innerTempSensorInfo.getInnerTempSensorId());
                if(maxTempNormVO!=null)
                    innerTempSensorInfo.setNorm(maxTempNormVO.getMaxTemp());

                InnerTempSensorInfo innerTempSensorInfoTemp = innerTempSensorInfoMapper.selectBySIdAndTime(innerTempSensorInfo.getInnerTempSensorId(),innerTempSensorInfo.getTime());
                if(innerTempSensorInfoTemp!=null)
                {
                    innerTempSensorInfoTemp.setTemp(innerTempSensorInfo.getTemp());
                    innerTempSensorInfoMapper.updateByPrimaryKeySelective(innerTempSensorInfoTemp);
                    continue;
                }
                innerTempSensorInfoMapper.insertSelective(innerTempSensorInfo);
                Constant.print(innerTempSensor.getSmallNo()+"下测控装置为"+remoteDev.getDevice_id()+
                        ",通道号为"+innerTempSensor.getChannel()+",编号为"+innerTempSensor.getTempNo()+
                        "的内部温度计获取到温度数据:"+remoteDevData.getData());
                if (maxTempNormVO==null) continue;
                if(innerTempSensor.getCuAddr().charAt(0)=='1'&&maxTempNormVO!=null)
                {
                    maxTempAlertService.maxTempAlert(innerTempSensorInfo,maxTempNormVO);
//                    storageColdAlertService.storageColdAlert(innerTempSensorInfo,maxTempNormVO);
                }
            }

        }
        timeAvgTemp(time);
    }

    @Override
    public List<InnerTempSensorInfoVO> exportListByque(InnerTempSensorInfoQue innerTempSensorInfoQue) {
        return innerTempSensorInfoMapper.selectList(innerTempSensorInfoQue);
    }
}
