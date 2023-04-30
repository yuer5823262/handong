package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.AlertBaseMapper;
import com.example.dampouring.model.dao.CloseGroutAlertMapper;
import com.example.dampouring.model.dao.PouringBaseMapper;
import com.example.dampouring.model.pojo.AlertBase;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.pojo.CloseGroutAlert;
import com.example.dampouring.model.vo.CloseGroutAlertVO;
import com.example.dampouring.model.vo.PouringBaseVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.CloseGroutAlertService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloseGroutAlertServiceImpl implements CloseGroutAlertService {
    @Autowired
    CloseGroutAlertMapper CloseGroutAlertMapper;
    @Autowired
    PouringBaseMapper pouringBaseMapper;
    @Autowired
    AlertBaseMapper alertBaseMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<CloseGroutAlertVO> InboundTempInfo = CloseGroutAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }

    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> InboundTempInfo = CloseGroutAlertMapper.list(type);
        return InboundTempInfo;
    }

    @Override
    public void processing(Integer[] ids, String username, String type,Integer mark) {

        for(Integer id:ids)
        {
            CloseGroutAlert CloseGroutAlert = CloseGroutAlertMapper.selectByPrimaryKey(id);
            if(CloseGroutAlert==null) continue;
            if(mark == 0)
            {
                CloseGroutAlert.setHasDispose("0");
                CloseGroutAlert.setOperator("");
                CloseGroutAlert.setOpTime("");
            }
            else
            {
                if(CloseGroutAlert.getOperator()==null||CloseGroutAlert.getOperator().equals(""))
                {
                    CloseGroutAlert.setOperator(username);
                    CloseGroutAlert.setOpTime(TimeUtils.getNowTime());
                }
                CloseGroutAlert.setHasDispose(type);
            }

            CloseGroutAlertMapper.updateByPrimaryKeySelective(CloseGroutAlert);
        }
    }

    @Override
    public void closeGroutAlert() {
        String time = TimeUtils.getNowTime();
        List<PouringBaseVO> pouringBaseList = pouringBaseMapper.selectList();
        for(PouringBaseVO pouringBase:pouringBaseList)
        {
            try {
                if(pouringBase.getClosureGroutTime()==null) continue;
                Double c =TimeUtils.getHourDifferentTime(time,pouringBase.getClosureGroutTime())/24;
                if(c<=3&&c>=0)
                {
                    AlertBase alertBase = new AlertBase();
                    alertBase.setContent(pouringBase.getSmallSbNo()+"距离封拱灌浆还有"+c.intValue()+"天");
                    alertBase.setTime(time);
                    alertBase.setState(0);
                    alertBase.setType("封拱灌浆预警");
                    alertBase.setTypeNo(1);
                    alertBase.setPosition(pouringBase.getSmallSbNo());
                    alertBaseMapper.insertSelective(alertBase);
                    ConnectionUtil.Send(alertBase.toString());
//                    CloseGroutAlert closeGroutAlert = new CloseGroutAlert();
//                    closeGroutAlert.setAlertContent(pouringBase.getSmallSbNo()+"距离封拱灌浆还有"+c.intValue()+"天");
//                    closeGroutAlert.setAlertTime(time);
//                    closeGroutAlert.setHasDispose("0");
//                    closeGroutAlert.setSbId(pouringBase.getSmallSbId());
//                    closeGroutAlert.setAlertType("封拱灌浆预警");
//                    closeGroutAlert.setCgTime(pouringBase.getClosureGroutTime());
//                    CloseGroutAlertMapper.insertSelective(closeGroutAlert);
                }
            } catch (Exception e) {
                Constant.logger.error("错误:",e);
            }

        }
    }
}
