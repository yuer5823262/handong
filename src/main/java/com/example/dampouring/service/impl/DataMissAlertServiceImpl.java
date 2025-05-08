package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.DataMissAlertMapper;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.pojo.DataMissAlert;
import com.example.dampouring.model.pojo.DataMissAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.DataCountVO;
import com.example.dampouring.model.vo.DataMissAlertVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.DataMissAlertQue;
import com.example.dampouring.service.DataMissAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.DatUtils;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataMissAlertServiceImpl implements DataMissAlertService {
    @Autowired
    DataMissAlertMapper DataMissAlertMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<DataMissAlertVO> InboundTempInfo = DataMissAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }

    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            DataMissAlert DataMissAlert = DataMissAlertMapper.selectByPrimaryKey(id);
            if(DataMissAlert==null) continue;
            if(mark == 0)
            {
                DataMissAlert.setHasDispose("0");
                DataMissAlert.setOperator("");
                DataMissAlert.setOpTime("");
            }
            else
            {
                if(DataMissAlert.getOperator()==null||DataMissAlert.getOperator().equals(""))
                {
                    DataMissAlert.setOperator(username);
                    DataMissAlert.setOpTime(TimeUtils.getNowTime());
                }
            }
            DataMissAlert.setHasDispose(type);
            DataMissAlertMapper.updateByPrimaryKeySelective(DataMissAlert);
        }
    }

//    @Override
//    public void dataMissAlert(Integer sbId, String type) {
//
//        String today = TimeUtils.getNextDay(0);
//        DataMissAlertQue dataMissAlertQue = new DataMissAlertQue();
//        dataMissAlertQue.setSbId(sbId);
//        dataMissAlertQue.setType(type);
//        DataMissAlert dataMissAlert = DataMissAlertMapper.selectAlert(dataMissAlertQue);
//        if(dataMissAlert!=null&&dataMissAlert.getAlertTime()!=today)
//        {
//            dataMissAlert.setMissDays(dataMissAlert.getMissDays()+1);
//            dataMissAlert.setAlertContent(type+"信息缺失"+dataMissAlert.getMissDays()+1+"天");
//            DataMissAlertMapper.updateByPrimaryKey(dataMissAlert);
//        }
//        if(dataMissAlert==null)
//        {
//            dataMissAlert = new DataMissAlert();
//            dataMissAlert.setMissDays(1);
//            if(sbId!=0)
//                dataMissAlert.setSbId(sbId);
//            dataMissAlert.setHasDispose("0");
//            dataMissAlert.setMissType(type);
//            dataMissAlert.setAlertTime(today);
//            dataMissAlert.setAlertContent(type+"信息缺失1天");
//            DataMissAlertMapper.insertSelective(dataMissAlert);
//        }
//    }
public void alert(DataMissAlertQue dataMissAlertQue)
{
    List<AlertBase> alertBaseList = alertBaseMapper.selectDataMissAlert(dataMissAlertQue);

    if(alertBaseList.size()==0)
    {
        AlertBase dataMissAlert = new AlertBase();
        if(dataMissAlertQue.getSbNo()!=null)
            dataMissAlert.setPosition(dataMissAlertQue.getSbNo());
        dataMissAlert.setState(0);
        dataMissAlert.setTypeNo(2);
        dataMissAlert.setTime(TimeUtils.getNowTime());
        dataMissAlert.setType(dataMissAlertQue.getType());
        dataMissAlert.setContent(dataMissAlertQue.getType()+"信息缺失1天");
        alertBaseMapper.insertSelective(dataMissAlert);
        ConnectionUtil.Send(dataMissAlert.toString());

    }
    else
    {
        AlertBase temp = alertBaseList.get(0);
        String content = temp.getContent();
        Integer missDays = DatUtils.getInt(content).get(0);
        missDays++;
        temp.setContent(dataMissAlertQue.getType()+"信息缺失"+missDays+"天");
        temp.setTime(TimeUtils.getNowTime());
        alertBaseMapper.updateByPrimaryKeySelective(temp);
    }
}
    @Override
    public void dataMissAlert() {
        List<DataCountVO> dataCountVOList = alertBaseMapper.todayDataCount();
        if(dataCountVOList.get(0).getTmCount()==null||dataCountVOList.get(0).getTmCount()==0)
        {
            DataMissAlertQue dataMissAlertQue = new DataMissAlertQue();
            dataMissAlertQue.setType("气温数据缺失");
            alert(dataMissAlertQue);
        }
        if(dataCountVOList.get(0).getSunCount()==null||dataCountVOList.get(0).getSunCount()==0)
        {
            DataMissAlertQue dataMissAlertQue = new DataMissAlertQue();
            dataMissAlertQue.setType("太阳辐射热数据缺失");
            alert(dataMissAlertQue);
        }
        for(DataCountVO dataCountVO:dataCountVOList)
        {
            DataMissAlertQue dataMissAlertQue = new DataMissAlertQue();
            dataMissAlertQue.setSbNo(dataCountVO.getSbNo());
            if((dataCountVO.getCountInBound()==null||dataCountVO.getCountInBound()==0)&&dataCountVO.checkTime())
            {
                dataMissAlertQue.setType("入仓温度数据缺失");
                alert(dataMissAlertQue);
            }

            if((dataCountVO.getCountExport()==null||dataCountVO.getCountExport()==0)&&dataCountVO.checkTime())
            {
                dataMissAlertQue.setType("出机口温度数据缺失");
                alert(dataMissAlertQue);
            }
            if((dataCountVO.getCountPouring()==null||dataCountVO.getCountPouring()==0)&&dataCountVO.checkTime())
            {
                dataMissAlertQue.setType("浇筑温度数据缺失");
                alert(dataMissAlertQue);
            }
//            if(dataCountVO.getGradCount()==null||dataCountVO.getGradCount()==0)
//            {
//                dataMissAlertQue.setType("温度梯度仪数据缺失");
//                alert(dataMissAlertQue);
//            }
            if(dataCountVO.getInnerCount()==null||dataCountVO.getInnerCount()==0)
            {
                dataMissAlertQue.setType("内部温度数据缺失");
                alert(dataMissAlertQue);
            }
            if(dataCountVO.getWaterCount()==null||dataCountVO.getWaterCount()==0)
            {
                dataMissAlertQue.setType("通水数据缺失");
                alert(dataMissAlertQue);
            }
        }
    }
    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = DataMissAlertMapper.list(type);
        return result;
    }
}
