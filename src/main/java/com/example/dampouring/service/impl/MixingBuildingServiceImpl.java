package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.MixingBuildingMapper;
import com.example.dampouring.model.pojo.MixingBuilding;
import com.example.dampouring.model.pojo.TempControlCurveSpecial;
import com.example.dampouring.model.request.AddMixingBuildingReq;
import com.example.dampouring.model.request.UpdateMixingBuildingReq;
import com.example.dampouring.model.vo.InnerTempSensorInfoVO;
import com.example.dampouring.query.MixingBuildingQue;
import com.example.dampouring.service.MixingBuildingService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MixingBuildingServiceImpl implements MixingBuildingService {
    @Autowired
    MixingBuildingMapper MixingBuildingMapper;

    @Override
    public void add(AddMixingBuildingReq addMixingBuildingReq, String userName) {
        MixingBuilding MixingBuilding = new MixingBuilding();
        BeanUtils.copyProperties(addMixingBuildingReq,MixingBuilding);
        MixingBuilding.setOperator(userName);
        MixingBuilding.setCreateTime(TimeUtils.getNowTime());
        int count = MixingBuildingMapper.insertSelective(MixingBuilding);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateMixingBuildingReq updateMixingBuildingReq){
        MixingBuilding MixingBuilding =
                MixingBuildingMapper.selectByPrimaryKey(updateMixingBuildingReq.getId());
        if (MixingBuilding == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
//        MixingBuilding MixingBuildingCheck =
//                MixingBuildingMapper.selectByName(updateMixingBuildingReq.getBsName());
//        if (MixingBuildingCheck != null &&
//                !MixingBuildingCheck.getBsNo().equals(MixingBuilding.getBsNo()) ) {
//
//            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
//        }
        BeanUtils.copyProperties(updateMixingBuildingReq,MixingBuilding);

        int count = MixingBuildingMapper.updateByPrimaryKeySelective(MixingBuilding);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = MixingBuildingMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public List<MixingBuilding> orUserList() {

        List<MixingBuilding> MixingBuildingList = MixingBuildingMapper.selectList();
        return MixingBuildingList;
    }

    @Override
    public List<MixingBuilding> listByIds(Integer[] ids) {
        List<MixingBuilding> categoryList = MixingBuildingMapper.selectListByIds(ids);
        return categoryList;
    }

    @Override
    public PageInfo select(MixingBuildingQue mixingBuildingQue) {
        PageHelper.startPage(mixingBuildingQue.getPageNum(), mixingBuildingQue.getPageSize());
        List<MixingBuilding> mixingBuildingList = MixingBuildingMapper.selectListByQue(mixingBuildingQue);
        PageInfo pageInfo = new PageInfo(mixingBuildingList);
        return pageInfo;
    }
}
