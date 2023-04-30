package com.example.dampouring.service.impl;
import com.example.dampouring.model.dao.TempRiseAlertMapper;
import com.example.dampouring.model.pojo.TempRiseAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.TempRiseAlertVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.service.TempRiseAlertService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempRiseAlertServiceImpl implements TempRiseAlertService {
    @Autowired
    TempRiseAlertMapper TempRiseAlertMapper;
    @Override
    public PageInfo orUserSelect(AlertQue AlertQue) {
        PageHelper.startPage(AlertQue.getPageNum(), AlertQue.getPageSize());
        List<TempRiseAlertVO> InboundTempInfo = TempRiseAlertMapper.selectList(AlertQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }
    @Override
    public List<AlertBaseVO> list(Integer type) {
        List<AlertBaseVO> result = TempRiseAlertMapper.list(type);
        return result;
    }
    @Override
    public void processing(Integer[] ids, String username,String type,Integer mark) {
        for(Integer id:ids)
        {
            TempRiseAlert TempRiseAlert = TempRiseAlertMapper.selectByPrimaryKey(id);
            if(TempRiseAlert==null) continue;
            if(mark == 0)
            {
                TempRiseAlert.setHasDispose("0");
                TempRiseAlert.setOperator("");
                TempRiseAlert.setOpTime("");
            }
            else
            {
                if(TempRiseAlert.getOperator()==null||TempRiseAlert.getOperator().equals(""))
                {
                    TempRiseAlert.setOperator(username);
                    TempRiseAlert.setOpTime(TimeUtils.getNowTime());
                }
                TempRiseAlert.setHasDispose(type);
            }
            TempRiseAlertMapper.updateByPrimaryKeySelective(TempRiseAlert);
        }
    }
}
