package com.example.dampouring.service.impl;


import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.BigSegmentMapper;
import com.example.dampouring.model.pojo.BigSegment;
import com.example.dampouring.model.request.AddBigSegmentReq;
import com.example.dampouring.model.request.UpdateBigSegmentReq;
import com.example.dampouring.query.BigSegmentQue;
import com.example.dampouring.service.BigSegmentService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BigSegmentServiceImpl implements BigSegmentService {
    @Autowired
    BigSegmentMapper bigSegmentMapper;

    @Override
    public void add(AddBigSegmentReq addBigSegmentReq, String userName) {
        BigSegment bigSegmentCheck = bigSegmentMapper.selectByName(addBigSegmentReq.getBsName());
        if (bigSegmentCheck != null) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BigSegment bigSegment = new BigSegment();
        BeanUtils.copyProperties(addBigSegmentReq,bigSegment);
        bigSegment.setOperator(userName);
        bigSegment.setCreateTime(TimeUtils.getNowTime());
        int count = bigSegmentMapper.insertSelective(bigSegment);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateBigSegmentReq updateBigSegmentReq){
        BigSegment bigSegment =
                bigSegmentMapper.selectByPrimaryKey(updateBigSegmentReq.getBsNo());
        if (bigSegment == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BigSegment bigSegmentCheck =
                bigSegmentMapper.selectByName(updateBigSegmentReq.getBsName());
        if (bigSegmentCheck != null &&
                !bigSegmentCheck.getBsNo().equals(bigSegment.getBsNo()) ) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BeanUtils.copyProperties(updateBigSegmentReq,bigSegment);

        int count = bigSegmentMapper.updateByPrimaryKeySelective(bigSegment);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = bigSegmentMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BigSegment> bigSegmentList = bigSegmentMapper.selectList();
        PageInfo pageInfo = new PageInfo(bigSegmentList);
        return pageInfo;
    }

    @Override
    public List<BigSegment> listByIds(Integer[] ids) {
        List<BigSegment> categoryList = bigSegmentMapper.selectListByIds(ids);
        return categoryList;

    }

    @Override
    public List<BigSegment> listByContractor(String value) {
        List<BigSegment> categoryList = bigSegmentMapper.selectListByContractor(value);
        return categoryList;
    }

    @Override
    public PageInfo orUserListQue(BigSegmentQue bigSegmentQue) {
        PageHelper.startPage(bigSegmentQue.getPageNum(), bigSegmentQue.getPageSize());
        List<BigSegment> bigSegmentList = bigSegmentMapper.selectListQue(bigSegmentQue);
        PageInfo pageInfo = new PageInfo(bigSegmentList);
        return pageInfo;
    }

    @Override
    public List<BigSegment> exportList() {
        List<BigSegment> bigSegmentList = bigSegmentMapper.selectList();
        return bigSegmentList;
    }

}
