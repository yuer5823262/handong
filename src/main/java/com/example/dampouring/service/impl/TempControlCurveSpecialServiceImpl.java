package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.pojo.TempControlCurveCommon;
import com.example.dampouring.model.pojo.TempControlCurveSpecial;
import com.example.dampouring.model.request.AddTempControlCurveSpecialReq;
import com.example.dampouring.model.request.UpdateTempControlCurveSpecialReq;
import com.example.dampouring.service.TempControlCurveSpecialService;
import com.example.dampouring.util.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempControlCurveSpecialServiceImpl implements TempControlCurveSpecialService {
    @Autowired
    com.example.dampouring.model.dao.TempControlCurveSpecialMapper TempControlCurveSpecialMapper;

    @Override
    public void add(AddTempControlCurveSpecialReq addTempControlCurveSpecialReq, String userName) {
        TempControlCurveSpecial TempControlCurveSpecial = new TempControlCurveSpecial();
        BeanUtils.copyProperties(addTempControlCurveSpecialReq,TempControlCurveSpecial);
        TempControlCurveSpecial.setOperator(userName);
        TempControlCurveSpecial.setCreateTime(TimeUtils.getNowTime());
        int count = TempControlCurveSpecialMapper.insertSelective(TempControlCurveSpecial);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateTempControlCurveSpecialReq updateTempControlCurveSpecialReq){
        TempControlCurveSpecial TempControlCurveSpecial =
                TempControlCurveSpecialMapper.selectByPrimaryKey(updateTempControlCurveSpecialReq.getId());
        if (TempControlCurveSpecial == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateTempControlCurveSpecialReq,TempControlCurveSpecial);

        int count = TempControlCurveSpecialMapper.updateByPrimaryKeySelective(TempControlCurveSpecial);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = TempControlCurveSpecialMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public List<TempControlCurveSpecial> orUserList() {

        List<TempControlCurveSpecial> TempControlCurveSpecialList = TempControlCurveSpecialMapper.selectList();
        return TempControlCurveSpecialList;
    }

    @Override
    public List<TempControlCurveSpecial> listByIds(Integer[] ids) {
        List<TempControlCurveSpecial> categoryList = TempControlCurveSpecialMapper.selectListByIds(ids);

        return categoryList;
    }
}
