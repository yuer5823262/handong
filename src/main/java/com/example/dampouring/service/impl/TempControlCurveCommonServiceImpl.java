package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.pojo.TempControlCurveCommon;
import com.example.dampouring.model.request.AddTempControlCurveCommonReq;
import com.example.dampouring.model.request.UpdateTempControlCurveCommonReq;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.service.TempControlCurveCommonService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempControlCurveCommonServiceImpl implements TempControlCurveCommonService {
    @Autowired
    com.example.dampouring.model.dao.TempControlCurveCommonMapper TempControlCurveCommonMapper;

    @Override
    public void add(AddTempControlCurveCommonReq addTempControlCurveCommonReq, String userName) {
        TempControlCurveCommon TempControlCurveCommon = new TempControlCurveCommon();
        BeanUtils.copyProperties(addTempControlCurveCommonReq,TempControlCurveCommon);
        TempControlCurveCommon.setOperator(userName);
        TempControlCurveCommon.setCreateTime(TimeUtils.getNowTime());
        int count = TempControlCurveCommonMapper.insertSelective(TempControlCurveCommon);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateTempControlCurveCommonReq updateTempControlCurveCommonReq){
        TempControlCurveCommon TempControlCurveCommon =
                TempControlCurveCommonMapper.selectByPrimaryKey(updateTempControlCurveCommonReq.getId());
        if (TempControlCurveCommon == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateTempControlCurveCommonReq,TempControlCurveCommon);

        int count = TempControlCurveCommonMapper.updateByPrimaryKeySelective(TempControlCurveCommon);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = TempControlCurveCommonMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TempControlCurveCommon> TempControlCurveCommonList = TempControlCurveCommonMapper.selectList();
        PageInfo pageInfo = new PageInfo(TempControlCurveCommonList);
        return pageInfo;
    }

    @Override
    public List<TempControlCurveCommon> listByIds(Integer[] ids) {
        List<TempControlCurveCommon> categoryList = TempControlCurveCommonMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public TempControlCurveCommon selectBySbId(Integer sbId) {
        return TempControlCurveCommonMapper.selectBySbId(sbId);
    }
}
