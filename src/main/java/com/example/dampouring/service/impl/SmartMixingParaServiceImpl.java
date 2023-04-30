package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.SmartMixingParaMapper;
import com.example.dampouring.model.pojo.SmartMixingPara;
import com.example.dampouring.model.request.AddSmartMixingParaReq;
import com.example.dampouring.model.request.UpdateSmartMixingParaReq;
import com.example.dampouring.service.SmartMixingParaService;
import com.example.dampouring.util.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartMixingParaServiceImpl implements SmartMixingParaService {
    @Autowired
    SmartMixingParaMapper SmartMixingParaMapper;

    @Override
    public void add(AddSmartMixingParaReq addSmartMixingParaReq, String userName) {
        SmartMixingPara SmartMixingPara = new SmartMixingPara();
        BeanUtils.copyProperties(addSmartMixingParaReq,SmartMixingPara);
        int count = SmartMixingParaMapper.insertSelective(SmartMixingPara);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateSmartMixingParaReq updateSmartMixingParaReq){
        SmartMixingPara SmartMixingPara =
                SmartMixingParaMapper.selectByPrimaryKey(updateSmartMixingParaReq.getId());
        if (SmartMixingPara == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateSmartMixingParaReq,SmartMixingPara);

        int count = SmartMixingParaMapper.updateByPrimaryKeySelective(SmartMixingPara);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = SmartMixingParaMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public List<SmartMixingPara> orUserList() {

        List<SmartMixingPara> SmartMixingParaList = SmartMixingParaMapper.selectList();
        return SmartMixingParaList;
    }
}
