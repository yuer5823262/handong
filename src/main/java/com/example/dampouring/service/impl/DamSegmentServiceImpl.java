package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.BigSegmentMapper;
import com.example.dampouring.model.dao.DamSegmentMapper;
import com.example.dampouring.model.pojo.BigSegment;
import com.example.dampouring.model.pojo.DamSegment;
import com.example.dampouring.model.request.AddDamSegmentReq;
import com.example.dampouring.model.request.UpdateDamSegmentReq;
import com.example.dampouring.model.vo.DamSegmentVO;
import com.example.dampouring.model.vo.PouringMonitorVO;
import com.example.dampouring.query.DamSegmentQue;
import com.example.dampouring.service.DamSegmentService;
import com.example.dampouring.util.TimeUtils;
import com.example.dampouring.util.copyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DamSegmentServiceImpl implements DamSegmentService {
    @Autowired
    DamSegmentMapper damSegmentMapper;
    @Autowired
    BigSegmentMapper bigSegmentMapper;
    @Override
    public void add(AddDamSegmentReq addDamSegmentReq, String userName) {
        DamSegment damSegmentCheck = damSegmentMapper.selectByName(addDamSegmentReq.getDsName());
        if (damSegmentCheck != null) {
            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BigSegment bigSegmentCheck = bigSegmentMapper.selectByPrimaryKey(addDamSegmentReq.getBsNo());
        if (bigSegmentCheck == null) {
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
        DamSegment damSegment = new DamSegment();
        BeanUtils.copyProperties(addDamSegmentReq,damSegment);
        damSegment.setOperator(userName);
        damSegment.setCreateTime(TimeUtils.getNowTime());
        int count = damSegmentMapper.insertSelective(damSegment);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
    }
    @Override
    public void update(UpdateDamSegmentReq updateDamSegmentReq){
        DamSegment damSegment = damSegmentMapper.selectByPrimaryKey(updateDamSegmentReq.getDsNo());
        if(damSegment==null){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        DamSegment damSegmentCheck =
                damSegmentMapper.selectByName(updateDamSegmentReq.getDsName());
        if (damSegmentCheck != null &&
                !damSegmentCheck.getDsNo().equals(updateDamSegmentReq.getDsNo())  ) {
            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        copyUtils.copyPropertiesIgnoreNull(updateDamSegmentReq,damSegment);
        damSegment.setHeight(damSegment.getElevationEnd()-damSegment.getElevationStart());
        if(!updateDamSegmentReq.checkBsNoIsEmpty()){
            BigSegment bigSegmentCheck = bigSegmentMapper.selectByPrimaryKey(updateDamSegmentReq.getBsNo());
            if (bigSegmentCheck == null) {
                throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
            }
        }

        int count = damSegmentMapper.updateByPrimaryKeySelective(damSegment);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = damSegmentMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo userVoList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<DamSegmentVO> DamSegmentList = damSegmentMapper.selectVoList();
        PageInfo pageInfo = new PageInfo(DamSegmentList);
        return pageInfo;
    }

    @Override
    public List<DamSegment> listByIds(Integer[] ids) {
        List<DamSegment> categoryList = damSegmentMapper.selectListByIds(ids);
        return categoryList;

    }

    @Override
    public List<DamSegment> listByBsNo(Integer value) {
        List<DamSegment> categoryList = damSegmentMapper.selectListByBSNo(value);
        return categoryList;
    }

    @Override
    public PageInfo userVoListQue(DamSegmentQue damSegmentQue) {
        PageHelper.startPage(damSegmentQue.getPageNum(), damSegmentQue.getPageSize());
        List<DamSegmentVO> DamSegmentList = damSegmentMapper.selectVoListQue(damSegmentQue);
        PageInfo pageInfo = new PageInfo(DamSegmentList);
        return pageInfo;
    }

    @Override
    public List<DamSegmentVO> exportList() {
        List<DamSegmentVO> DamSegmentList = damSegmentMapper.selectVoList();
        return DamSegmentList;
    }

    @Override
    public List<PouringMonitorVO> pouringMonitor() {
        List<PouringMonitorVO> pouringMonitorVOS= damSegmentMapper.pouringMonitor();
        return pouringMonitorVOS;
    }
}
