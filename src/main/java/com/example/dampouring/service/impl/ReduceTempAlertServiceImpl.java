package com.example.dampouring.service.impl;
import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.ReduceTempAlertMapper;
import com.example.dampouring.model.dao.TempRiseAlertMapper;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.pojo.ReduceTempAlert;
import com.example.dampouring.model.pojo.ReduceTempAlert;
import com.example.dampouring.model.pojo.TempRiseAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.ReduceTempAlertVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.PouringBaseService;
import com.example.dampouring.service.ReduceTempAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReduceTempAlertServiceImpl implements ReduceTempAlertService {
    @Autowired
    ReduceTempAlertMapper ReduceTempAlertMapper;
    @Autowired
    PouringBaseService pouringBaseService;
    @Autowired
    TempRiseAlertMapper tempRiseAlertMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<ReduceTempAlertVO> InboundTempInfo = ReduceTempAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = ReduceTempAlertMapper.list(type);
        return result;
    }
    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            ReduceTempAlert ReduceTempAlert = ReduceTempAlertMapper.selectByPrimaryKey(id);
            if(ReduceTempAlert==null) continue;
            if(mark == 0)
            {
                ReduceTempAlert.setHasDispose("0");
                ReduceTempAlert.setOperator("");
                ReduceTempAlert.setOpTime("");
            }
            else
            {
                if(ReduceTempAlert.getOperator()==null||ReduceTempAlert.getOperator().equals(""))
                {
                    ReduceTempAlert.setOperator(username);
                    ReduceTempAlert.setOpTime(TimeUtils.getNowTime());
                }
                ReduceTempAlert.setHasDispose(type);
            }
            ReduceTempAlertMapper.updateByPrimaryKeySelective(ReduceTempAlert);
        }
    }

    @Override
    public void reduceTempAlert() {
        String today = TimeUtils.getNextDay(0);
        String yesterday = TimeUtils.getNextDay(-1);
        List<ReduceTempAlert> reduceTempAlertList = ReduceTempAlertMapper.reduceTempAlert(today,yesterday);
        for(ReduceTempAlert reduceTempAlert:reduceTempAlertList) {
            try {
                reduceTempAlert.setAlertTime(TimeUtils.getNowTime());
                reduceTempAlert.setHasDispose("0");
                reduceTempAlert.setReduceSpeedBySelf();
                Integer qs = pouringBaseService.getQS(reduceTempAlert.getSbId());
                Double norm = 1.;
                if(qs==null||qs==0) continue;
                MaxTempNormVO maxTempNormVO = ReduceTempAlertMapper.normInfo(reduceTempAlert.getSbId(), qs);
                if(maxTempNormVO==null) continue;
                norm = maxTempNormVO.getMaxTemp();

                if (reduceTempAlert.getReduceSpeed() >= norm) {
//                    reduceTempAlert.setNormSpeed(norm);
//                    reduceTempAlert.setAlertContent("降温速率达到"+reduceTempAlert.getReduceSpeed()+"°C");
//                    reduceTempAlert.setExceedAmountBySelf();
//                    ReduceTempAlertMapper.insertSelective(reduceTempAlert);
                    AlertBase alertBase = new AlertBase();
                    alertBase.setTime(TimeUtils.getNowTime());
                    alertBase.setState(0);
                    alertBase.setTypeNo(12);
                    alertBase.setContent("降温速率达到"+String.format("%.2f",reduceTempAlert.getReduceSpeed())+"°C,"+
                            "超过标准的"+norm);
                    alertBase.setType("降温速率报警");
                    alertBase.setPosition(maxTempNormVO.getSbNo());
                    alertBaseMapper.insertSelective(alertBase);
                    ConnectionUtil.Send(alertBase.toString());
                }


//                if (-reduceTempAlert.getReduceSpeed() >= norm) {
////                    TempRiseAlert tempRiseAlert = new TempRiseAlert();
////                    tempRiseAlert.setAlertTime(TimeUtils.getNowTime());
////                    tempRiseAlert.setAlertType("温度回升预警");
////                    tempRiseAlert.setHasDispose("0");
////                    tempRiseAlert.setSbNorm(norm);
////                    tempRiseAlert.setSbId(reduceTempAlert.getSbId());
////                    tempRiseAlert.setAlertContent(today + "温度:" + reduceTempAlert.getTempToday() + "  " +
////                            yesterday + "温度:" + reduceTempAlert.getTempYesterday() + "  " +
////                            "温度回弹达到" + -reduceTempAlert.getReduceSpeed());
////                    tempRiseAlertMapper.insertSelective(tempRiseAlert);
//                    AlertBase alertBase = new AlertBase();
//                    alertBase.setTime(TimeUtils.getNowTime());
//                    alertBase.setState(0);
//                    alertBase.setTypeNo(15);
//                    alertBase.setContent("温度回弹达到" + String.format("%.2f",-reduceTempAlert.getReduceSpeed())+"°C,"+
//                            "超过标准的"+norm);
//                    alertBase.setType("温度回升预警");
//                    alertBase.setPosition(maxTempNormVO.getSbNo());
//                    alertBaseMapper.insertSelective(alertBase);
//                    ConnectionUtil.Send(alertBase.toString());
//                }
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }


        }

    }
}
