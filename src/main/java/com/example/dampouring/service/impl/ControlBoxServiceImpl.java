package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.ControlBoxMapper;
import com.example.dampouring.model.pojo.ControlBox;
import com.example.dampouring.model.request.AddControlBoxReq;
import com.example.dampouring.model.request.UpdateControlBoxReq;
import com.example.dampouring.model.vo.ControlBoxVO;
import com.example.dampouring.query.WaterRainStationQue;
import com.example.dampouring.service.ControlBoxService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlBoxServiceImpl implements ControlBoxService {
    @Autowired
    ControlBoxMapper controlBoxMapper;

    @Override
    public void add(AddControlBoxReq addControlBoxReq, String userName) {
        ControlBox controlBoxCheck = controlBoxMapper.selectByCbNo(addControlBoxReq.getCbNo());
        if (controlBoxCheck != null) {
            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        ControlBox controlBox = new ControlBox();
        BeanUtils.copyProperties(addControlBoxReq,controlBox);
        controlBox.setOperator(userName);
        controlBox.setCreateTime(TimeUtils.getNowTime());
        int count = controlBoxMapper.insertSelective(controlBox);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateControlBoxReq updateControlBoxReq){
        ControlBox ControlBox =
                controlBoxMapper.selectByPrimaryKey(updateControlBoxReq.getId());
        if (ControlBox == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        ControlBox ControlBoxCheck =
                controlBoxMapper.selectByCbNo(updateControlBoxReq.getCbNo());
        if (ControlBoxCheck != null &&
                !ControlBoxCheck.getCbNo().equals(ControlBox.getCbNo()) ) {

            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        BeanUtils.copyProperties(updateControlBoxReq,ControlBox);

        int count = controlBoxMapper.updateByPrimaryKeySelective(ControlBox);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = controlBoxMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ControlBoxVO> controlBoxList = controlBoxMapper.selectList();
        PageInfo pageInfo = new PageInfo(controlBoxList);
        return pageInfo;
    }

    @Override
    public List<ControlBoxVO> listByIds(Integer[] ids) {
        List<ControlBoxVO> categoryList = controlBoxMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<ControlBox> listByScsId(Integer scsId) {
        List<ControlBox> selectVoList = controlBoxMapper.selectByScsId(scsId);
        return selectVoList;
    }

    @Override
    public List<ControlBoxVO> exportList() {
        List<ControlBoxVO> controlBoxList = controlBoxMapper.selectList();
        return controlBoxList;
    }

    @Override
    public PageInfo selectByQue(WaterRainStationQue waterRainStationQue) {
        PageHelper.startPage(waterRainStationQue.getPageNum(), waterRainStationQue.getPageSize());
        List<ControlBoxVO> controlBoxList = controlBoxMapper.selectByQue(waterRainStationQue);
        PageInfo pageInfo = new PageInfo(controlBoxList);
        return pageInfo;
    }
}
