package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.SmartWarehouseWarningMapper;
import com.example.dampouring.model.pojo.SmartWarehouseWarning;
import com.example.dampouring.model.pojo.SmartWarehouseWarning;
import com.example.dampouring.model.vo.SmartWarehouseWarningVO;
import com.example.dampouring.query.SmartWarehouseWarningQue;
import com.example.dampouring.service.SmartWarehouseWarningService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SmartWarehouseWarningServiceImpl implements SmartWarehouseWarningService {
    @Autowired
    SmartWarehouseWarningMapper SmartWarehouseWarningMapper;
    @Override
    public PageInfo orUserSelect(SmartWarehouseWarningQue SmartWarehouseWarningQue) {
        PageHelper.startPage(SmartWarehouseWarningQue.getPageNum(), SmartWarehouseWarningQue.getPageSize());
        List<SmartWarehouseWarningVO> InboundTempInfo = SmartWarehouseWarningMapper.selectList(SmartWarehouseWarningQue);
        PageInfo pageInfo = new PageInfo(InboundTempInfo);
        return pageInfo;
    }

    @Override
    public void processing(Integer[] ids, String username) {
        SmartWarehouseWarning SmartWarehouseWarning = new SmartWarehouseWarning();
        SmartWarehouseWarning.setOperator(username);
        SmartWarehouseWarning.setProcessingTime(TimeUtils.getNowTime());
        SmartWarehouseWarning.setIsProcessing(1);
        for(Integer id:ids)
        {
            SmartWarehouseWarning.setId(id);
            SmartWarehouseWarningMapper.updateByPrimaryKeySelective(SmartWarehouseWarning);
        }
    }
}
