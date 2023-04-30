package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.LayerTdiffAlertMapper;
import com.example.dampouring.model.dao.SbTempNormMapper;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.pojo.LayerTdiffAlert;
import com.example.dampouring.model.pojo.LayerTdiffAlert;
import com.example.dampouring.model.vo.*;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.SelectNormQue;
import com.example.dampouring.service.LayerTdiffAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LayerTdiffAlertServiceImpl implements LayerTdiffAlertService {
    @Autowired
    LayerTdiffAlertMapper LayerTdiffAlertMapper;
    @Autowired
    SbTempNormMapper sbTempNormMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<LayerTdiffAlertVO> InboundTempInfo = LayerTdiffAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }

    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            LayerTdiffAlert LayerTdiffAlert = LayerTdiffAlertMapper.selectByPrimaryKey(id);
            if(LayerTdiffAlert==null) continue;
            if(mark == 0)
            {
                LayerTdiffAlert.setHasDispose("0");
                LayerTdiffAlert.setOperator("");
                LayerTdiffAlert.setOpTime("");
            }
            else
            {
                if(LayerTdiffAlert.getOperator()==null||LayerTdiffAlert.getOperator().equals(""))
                {
                    LayerTdiffAlert.setOperator(username);
                    LayerTdiffAlert.setOpTime(TimeUtils.getNowTime());
                }
                LayerTdiffAlert.setHasDispose(type);
            }
            LayerTdiffAlertMapper.updateByPrimaryKeySelective(LayerTdiffAlert);
        }
    }
    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = LayerTdiffAlertMapper.list(type);
        return result;
    }
    @Override
    public void layerTdiffAlert(String time) {
        List<SbTempNo> sbTempNoList = LayerTdiffAlertMapper.sbTemp(time);
        for(int i = 0;i<sbTempNoList.size()-1;i++)
        {
            Double eEnd=sbTempNoList.get(i).getElevationEnd();
            Double eStart=sbTempNoList.get(i+1).getElevationStart();
            Double eDiff = Math.abs(eStart-eEnd);
            if(sbTempNoList.get(i).getDsStart().equals(sbTempNoList.get(i+1).getDsStart())&&
                    eDiff<=1){
                SelectNormQue selectNormQue = new SelectNormQue();
                selectNormQue.setSbId(sbTempNoList.get(i).getId());
                SbTempNormVO sbTempNormVO = sbTempNormMapper.selectNorm(selectNormQue);
                if(sbTempNormVO==null) continue;
//                MaxTempNormVO maxTempNormVO = LayerTdiffAlertMapper.normInfo(sbTempNoList.get(i).getId());
                Double temp1 = sbTempNoList.get(i).getTemp();
                Double temp2 = sbTempNoList.get(i+1).getTemp();
                Double norm = sbTempNormVO.getUpperLowTenpDiff();
                Double tempDiff = Math.abs(temp1-temp2);
                if(tempDiff>=norm)
                {
//                    LayerTdiffAlert layerTdiffAlert = new LayerTdiffAlert();
//                    layerTdiffAlert.setTempDiff(tempDiff);
//                    layerTdiffAlert.setAlertTime(time);
//                    layerTdiffAlert.setHasDispose("0");
//                    layerTdiffAlert.setSbId(sbTempNoList.get(i).getId());
//                    layerTdiffAlert.setTempLower(temp1);
//                    layerTdiffAlert.setAlertContent("上下层温度分别为"+temp1+"°C,"+temp2+"°C,"+"温差达到"
//                            +tempDiff+"°C,"+"超过设定的上下层温差标准:"+norm+"°C");
//                    layerTdiffAlert.setTempUpper(temp2);
//                    layerTdiffAlert.setTempNorm(norm);
//                    layerTdiffAlert.setExceedAmount(tempDiff-norm);
//                    LayerTdiffAlertMapper.insertSelective(layerTdiffAlert);
                    AlertBase alertBase = new AlertBase();
                    alertBase.setTime(TimeUtils.getNowTime());
                    alertBase.setState(0);
                    alertBase.setTypeNo(7);
                    alertBase.setContent("上下层温度分别为"+String.format("%.2f",temp1)+"°C,"+String.format("%.2f",temp2)+"°C,"+"温差达到"
                            +String.format("%.2f",tempDiff)+"°C,"+"超过设定的上下层温差标准:"+norm+"°C");
                    alertBase.setType("上下层温差报警");
                    alertBase.setPosition(sbTempNormVO.getSbNo());
                    alertBaseMapper.insertSelective(alertBase);
                    ConnectionUtil.Send(alertBase.toString());
                }
            }
        }
    }
}
