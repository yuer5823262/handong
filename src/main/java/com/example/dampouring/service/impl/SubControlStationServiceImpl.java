package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.SubControlStationMapper;
import com.example.dampouring.model.pojo.SubControlStation;
import com.example.dampouring.model.request.AddSubControlStationReq;
import com.example.dampouring.model.request.UpdateSubControlStationReq;
import com.example.dampouring.query.WaterRainStationQue;
import com.example.dampouring.service.SubControlStationService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubControlStationServiceImpl implements SubControlStationService {
    @Autowired
    SubControlStationMapper subControlStationMapper;

    @Override
    public void add(AddSubControlStationReq addSubControlStationReq, String userName) {
        SubControlStation subControlStationCheck = subControlStationMapper.selectByScsNo(addSubControlStationReq.getScsNo());
        if (subControlStationCheck != null) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        SubControlStation subControlStation = new SubControlStation();
        BeanUtils.copyProperties(addSubControlStationReq,subControlStation);
        subControlStation.setOperator(userName);
        subControlStation.setCreateTime(TimeUtils.getNowTime());
        int count = subControlStationMapper.insertSelective(subControlStation);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateSubControlStationReq updateSubControlStationReq){
        SubControlStation subControlStation =
                subControlStationMapper.selectByPrimaryKey(updateSubControlStationReq.getId());
        if (subControlStation == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        SubControlStation subControlStationCheck =
                subControlStationMapper.selectByScsNo(updateSubControlStationReq.getScsNo());
        if (subControlStationCheck != null &&
                !subControlStationCheck.getScsNo().equals(subControlStation.getScsNo()) ) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BeanUtils.copyProperties(updateSubControlStationReq,subControlStation);

        int count = subControlStationMapper.updateByPrimaryKeySelective(subControlStation);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = subControlStationMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SubControlStation> subControlStationList = subControlStationMapper.selectList();
        PageInfo pageInfo = new PageInfo(subControlStationList);
        return pageInfo;
    }

    @Override
    public List<SubControlStation> listByIds(Integer[] ids) {
        List<SubControlStation> categoryList = subControlStationMapper.selectListByIds(ids);
        return categoryList;

    }

    @Override
    public List<SubControlStation> exportList() {
        List<SubControlStation> subControlStationList = subControlStationMapper.selectList();
        return subControlStationList;
    }

    @Override
    public PageInfo selectByQue(WaterRainStationQue waterRainStationQue) {
        PageHelper.startPage(waterRainStationQue.getPageNum(), waterRainStationQue.getPageSize());
        List<SubControlStation> subControlStationList = subControlStationMapper.selectByQue(waterRainStationQue);
        PageInfo pageInfo = new PageInfo(subControlStationList);
        return pageInfo;
    }
}
