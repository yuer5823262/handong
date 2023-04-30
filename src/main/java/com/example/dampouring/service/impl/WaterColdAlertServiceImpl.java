package com.example.dampouring.service.impl;

import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.WaterColdAlertMapper;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.pojo.WaterColdAlert;
import com.example.dampouring.model.pojo.WaterPipeFlowInfo;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.WaterColdAlertVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.WaterColdAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterColdAlertServiceImpl implements WaterColdAlertService {
    @Autowired
    WaterColdAlertMapper WaterColdAlertMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<WaterColdAlertVO> InboundTempInfo = WaterColdAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = WaterColdAlertMapper.list(type);
        return result;
    }
    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            WaterColdAlert WaterColdAlert = WaterColdAlertMapper.selectByPrimaryKey(id);
            if(WaterColdAlert==null) continue;
            if(mark == 0)
            {
                WaterColdAlert.setHasDispose("0");
                WaterColdAlert.setOperator("");
                WaterColdAlert.setOpTime("");
            }
            else
            {
                if(WaterColdAlert.getOperator()==null||WaterColdAlert.getOperator().equals(""))
                {
                    WaterColdAlert.setOperator(username);
                    WaterColdAlert.setOpTime(TimeUtils.getNowTime());
                }
                WaterColdAlert.setHasDispose(type);
            }
            WaterColdAlertMapper.updateByPrimaryKeySelective(WaterColdAlert);
        }
    }

    @Override
    public void WaterColdAlert(WaterPipeFlowInfo waterPipeFlowInfo)
    {
        MaxTempNormVO maxTempNormVO = WaterColdAlertMapper.normInfo(waterPipeFlowInfo.getWaterPipeId());
        if(maxTempNormVO==null) return;
        Double maxTemp = waterPipeFlowInfo.getMaxTemp();
        Double minTemp = waterPipeFlowInfo.getMinTemp();
        if(maxTemp>maxTempNormVO.getMaxTemp())
        {
//            WaterColdAlert waterColdAlert = new WaterColdAlert();
//            waterColdAlert.setHasDispose("0");
//            waterColdAlert.setInwhTemp(maxTemp);
//            waterColdAlert.setSbId(maxTempNormVO.getSbId());
//            waterColdAlert.setAlertTime(TimeUtils.getNowTime());
//            waterColdAlert.setAlertType("水温超高预警");
//            waterColdAlert.setAlertContent("水温超过温度标准:"+maxTempNormVO.getMaxTemp()+"°C,"+
//                    "达到"+maxTemp+"°C");
//            WaterColdAlertMapper.insertSelective(waterColdAlert);
            AlertBase alertBase = new AlertBase();
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setState(0);
            alertBase.setTypeNo(16);
            alertBase.setContent("水温超过温度标准:"+maxTempNormVO.getMaxTemp()+"°C,"+
                    "达到"+String.format("%.2f",maxTemp)+"°C");
            alertBase.setType("水温超高报警");
            alertBase.setPosition(maxTempNormVO.getSbNo());
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
        }
        if(minTemp<=maxTempNormVO.getMinTemp())
        {
//            WaterColdAlert waterColdAlert = new WaterColdAlert();
//            waterColdAlert.setHasDispose("0");
//            waterColdAlert.setInwhTemp(minTemp);
//            waterColdAlert.setSbId(maxTempNormVO.getSbId());
//            waterColdAlert.setAlertTime(TimeUtils.getNowTime());
//            waterColdAlert.setAlertType("水温超冷预警");
//            waterColdAlert.setAlertContent("水温低于温度标准:"+maxTempNormVO.getMinTemp()+"°C,"+
//                    "达到"+minTemp+"°C");
//            WaterColdAlertMapper.insertSelective(waterColdAlert);
            AlertBase alertBase = new AlertBase();
            alertBase.setTime(TimeUtils.getNowTime());
            alertBase.setState(0);
            alertBase.setTypeNo(16);
            alertBase.setContent("水温低于温度标准:"+maxTempNormVO.getMinTemp()+"°C,"+
                    "达到"+String.format("%.2f",minTemp)+"°C");
            alertBase.setType("水温超冷预警");
            alertBase.setPosition(maxTempNormVO.getSbNo());
            alertBaseMapper.insertSelective(alertBase);
            ConnectionUtil.Send(alertBase.toString());
        }
    }
}
