package com.example.dampouring.service.impl;
import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.PouringBaseMapper;
import com.example.dampouring.model.dao.StorageColdAlertMapper;
import com.example.dampouring.model.pojo.*;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.StorageColdAlertVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.PouringBaseService;
import com.example.dampouring.service.StorageColdAlertService;
import com.example.dampouring.service.TempControlCurveCommonService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageColdAlertServiceImpl implements StorageColdAlertService {
    @Autowired
    StorageColdAlertMapper StorageColdAlertMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Autowired
    PouringBaseService pouringBaseService;
    @Autowired
    TempControlCurveCommonService tempControlCurveCommonService;
    @Autowired
    PouringBaseMapper pouringBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<StorageColdAlertVO> InboundTempInfo = StorageColdAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = StorageColdAlertMapper.list(type);
        return result;
    }
    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            StorageColdAlert StorageColdAlert = StorageColdAlertMapper.selectByPrimaryKey(id);
            if(StorageColdAlert==null) continue;
            if(mark == 0)
            {
                StorageColdAlert.setHasDispose("0");
                StorageColdAlert.setOperator("");
                StorageColdAlert.setOpTime("");
            }
            else
            {
                if(StorageColdAlert.getOperator()==null||StorageColdAlert.getOperator().equals(""))
                {
                    StorageColdAlert.setOperator(username);
                    StorageColdAlert.setOpTime(TimeUtils.getNowTime());
                }
                StorageColdAlert.setHasDispose(type);
            }
            StorageColdAlertMapper.updateByPrimaryKeySelective(StorageColdAlert);
        }
    }


    @Override
    public void storageColdAlert(InnerTempSensorInfo innerTempSensorInfo,MaxTempNormVO maxTempNormVO)
    {
        PouringBase pouringBase =  pouringBaseMapper.selectBySbId(maxTempNormVO.getSbId());
        if (TimeUtils.getHourDifferentTime(TimeUtils.getNowTime(),pouringBase.getCloseTime()) < 72)
        {
            return;
        }
        int qs = pouringBaseService.getQS(maxTempNormVO.getSbId());
        TempControlCurveCommon tempControlCurveCommon = tempControlCurveCommonService.selectBySbId(maxTempNormVO.getSbId());
        Double norm =tempControlCurveCommon.getNormTargetTemp(qs) ;

        if(innerTempSensorInfo.getTemp()<norm-0.5)
        {
//            StorageColdAlert storageColdAlert = new StorageColdAlert();
//            storageColdAlert.setHasDispose("0");
//            storageColdAlert.setTempCurr(innerTempSensorInfo.getTemp());
//            storageColdAlert.setTempTarget(maxTempNormVO.getMinTemp());
//            storageColdAlert.setSbId(maxTempNormVO.getSbId());
//            storageColdAlert.setAlertTime(TimeUtils.getNowTime());
//            storageColdAlert.setAlertType("超冷预警");
//            storageColdAlert.setAlertContent("温度低于最低标准:"+maxTempNormVO.getMinTemp()+"°C,"+
//                    "达到:"+innerTempSensorInfo.getTemp()+"°C");
//            storageColdAlert.setColdAmount(maxTempNormVO.getMinTemp()-innerTempSensorInfo.getTemp());
//            StorageColdAlertMapper.insertSelective(storageColdAlert);
            AlertBase alertBase = new AlertBase();
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setState(0);
            alertBase.setTypeNo(13);
            alertBase.setContent("温度低于最低标准:"+String.format("%.2f",norm)+"°C,"+
                    "达到:"+String.format("%.2f",innerTempSensorInfo.getTemp())+"°C");
            alertBase.setType("超冷预警");
            alertBase.setPosition(maxTempNormVO.getSbNo());
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());

        }
    }
}
