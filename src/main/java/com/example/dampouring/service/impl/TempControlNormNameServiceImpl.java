package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.TempControlNormNameMapper;
import com.example.dampouring.model.pojo.TempControlNormName;
import com.example.dampouring.model.request.AddTempControlNormNameReq;
import com.example.dampouring.model.request.UpdateTempControlNormNameReq;
import com.example.dampouring.query.TempControlNormNameQue;
import com.example.dampouring.service.TempControlNormNameService;
import com.example.dampouring.util.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempControlNormNameServiceImpl implements TempControlNormNameService {
    @Autowired
    TempControlNormNameMapper TempControlNormNameMapper;

    @Override
    public void add(AddTempControlNormNameReq addTempControlNormNameReq, String userName) {
        TempControlNormName TempControlNormName = new TempControlNormName();
        BeanUtils.copyProperties(addTempControlNormNameReq,TempControlNormName);
        TempControlNormName.setOperator(userName);
        TempControlNormName.setTime(TimeUtils.getNowTime());
        int count = TempControlNormNameMapper.insertSelective(TempControlNormName);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateTempControlNormNameReq updateTempControlNormNameReq){
        TempControlNormName TempControlNormName =
                TempControlNormNameMapper.selectByPrimaryKey(updateTempControlNormNameReq.getId());
        if (TempControlNormName == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateTempControlNormNameReq,TempControlNormName);

        int count = TempControlNormNameMapper.updateByPrimaryKeySelective(TempControlNormName);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = TempControlNormNameMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public List<TempControlNormName> orUserList(TempControlNormNameQue name) {

        List<TempControlNormName> TempControlNormNameList = TempControlNormNameMapper.selectList(name);
        return TempControlNormNameList;
    }

    @Override
    public List<TempControlNormName> listByIds(Integer[] ids) {
        List<TempControlNormName> categoryList = TempControlNormNameMapper.selectListByIds(ids);

        return categoryList;
    }
}
