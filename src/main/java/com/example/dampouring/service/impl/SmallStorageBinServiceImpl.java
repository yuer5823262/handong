package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.DamSegmentMapper;
import com.example.dampouring.model.dao.SbTempNormMapper;
import com.example.dampouring.model.dao.SmallStorageBinMapper;


import com.example.dampouring.model.dao.TempControlNormInfoMapper;
import com.example.dampouring.model.pojo.DamSegment;
import com.example.dampouring.model.pojo.SbTempNorm;
import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.pojo.TempControlNormInfo;
import com.example.dampouring.model.request.AddSmallStorageBinReq;
import com.example.dampouring.model.request.UpdateSmallStorageBinReq;
import com.example.dampouring.model.vo.TempControlNormInfoVO;
import com.example.dampouring.query.StorageBinQue;
import com.example.dampouring.service.FaceDiapauseAlertService;
import com.example.dampouring.service.SmallStorageBinService;
import com.example.dampouring.util.TimeUtils;
import com.example.dampouring.util.copyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmallStorageBinServiceImpl implements SmallStorageBinService {
    @Autowired
    SmallStorageBinMapper smallStorageBinMapper;
    @Autowired
    DamSegmentMapper damSegmentMapper;
    @Autowired
    TempControlNormInfoMapper tempControlNormInfoMapper;
    @Autowired
    SbTempNormMapper sbTempNormMapper;
    @Override
    public void add(AddSmallStorageBinReq addSmallStorageBinReq, String userName) {
        if(addSmallStorageBinReq.smallNoIsEmpty()) addSmallStorageBinReq.setBigSbNoByDs();
        checkReqDate(addSmallStorageBinReq.getDsStart(),addSmallStorageBinReq.getDsEnd(),
                addSmallStorageBinReq.getElevationStart(),addSmallStorageBinReq.getElevationEnd(),
                addSmallStorageBinReq.getSmallSbNo());
        SmallStorageBin smallStorageBin = new SmallStorageBin();
        BeanUtils.copyProperties(addSmallStorageBinReq,smallStorageBin);
        smallStorageBin.setOperator(userName);
        smallStorageBin.setCreateTime(TimeUtils.getNowTime());
        smallStorageBin.setIsAlert("1");
        smallStorageBin.setIsCalculate("1");
        smallStorageBin.setIsGetWater("1");
        smallStorageBin.setIsComputer("1");
        int count = smallStorageBinMapper.insertSelective(smallStorageBin);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
    }

    @Override
    public void update(UpdateSmallStorageBinReq updateSmallStorageBinReq) {
        SmallStorageBin smallStorageBin = smallStorageBinMapper.selectByPrimaryKey(updateSmallStorageBinReq.getId());
        if(smallStorageBin==null){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        copyUtils.copyPropertiesIgnoreNull(updateSmallStorageBinReq,smallStorageBin);
        checkReqDate(smallStorageBin.getDsStart(),smallStorageBin.getDsEnd(),
                smallStorageBin.getElevationStart(),smallStorageBin.getElevationEnd(),null);
        int count = smallStorageBinMapper.updateByPrimaryKeySelective(smallStorageBin);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }

    @Override
    public void delete(Integer[] ids) {
        int count = smallStorageBinMapper.deleteByPrimaryKey(ids);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }

    @Override
    public PageInfo userVoList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SmallStorageBin> selectVoList = smallStorageBinMapper.selectVoList();
        PageInfo pageInfo = new PageInfo(selectVoList);
        return pageInfo;
    }

    @Override
    public List<SmallStorageBin> exportList() {
        List<SmallStorageBin> selectVoList = smallStorageBinMapper.selectVoList();
        return selectVoList;
    }

    @Override
    public List<SmallStorageBin> listByIds(Integer[] ids) {
        List<SmallStorageBin> selectVoList = smallStorageBinMapper.selectByIds(ids);
        return selectVoList;
    }

    @Override
    public SmallStorageBin listBybNo(String sbNo) {
        SmallStorageBin selectVoList = smallStorageBinMapper.selectBySbNo(sbNo);
        return selectVoList;
    }

    @Override
    public PageInfo userVoListQue(StorageBinQue storageBinQue) {
        PageHelper.startPage(storageBinQue.getPageNum(), storageBinQue.getPageSize());
        List<SmallStorageBin> selectVoList = smallStorageBinMapper.selectVoListQue(storageBinQue);
        PageInfo pageInfo = new PageInfo(selectVoList);
        return pageInfo;
    }
    void checkReqDate(String dsStart,String dsEnd,double elevationStart,double elevationEnd,String sbNo){
        SmallStorageBin smallStorageBin = smallStorageBinMapper.selectBySbNo(sbNo);
        if(smallStorageBin!=null)
        {
            throw new DamPourException(30000,"仓号已存在");
        }
        if(elevationStart>=elevationEnd)
        {
            throw new DamPourException(30000,"起始高程应小于终止高程");
        }
        DamSegment damSegmentStart = damSegmentMapper.selectByName(dsStart);
        DamSegment damSegmentEnd = damSegmentMapper.selectByName(dsEnd);
        if(damSegmentStart==null||damSegmentEnd==null){
            throw new DamPourException(30000,"所选分段不存在");
        }
        if(elevationStart<damSegmentStart.getElevationStart()||
                elevationEnd>damSegmentEnd.getElevationEnd())
            throw new DamPourException(30000,"起始高程低于分段起始高程或终止高程高于分段终止高程");
    }

}
