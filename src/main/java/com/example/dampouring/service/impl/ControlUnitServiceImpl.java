package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.ControlUnitMapper;
import com.example.dampouring.model.pojo.ControlUnit;
import com.example.dampouring.model.request.AddControlUnitReq;
import com.example.dampouring.model.request.UpdateControlUnitReq;
import com.example.dampouring.model.vo.ControlUnitVO;
import com.example.dampouring.query.ControlUnitQue;
import com.example.dampouring.service.ControlUnitService;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlUnitServiceImpl implements ControlUnitService {
    @Autowired
    ControlUnitMapper controlUnitMapper;
    public void checkData(String cuAddr,String cuType)
    {

        if(cuType.equals("远程测控"))
            return;
        ControlUnitQue controlUnitQue = new ControlUnitQue();
        controlUnitQue.setCuAddr(cuAddr);

        controlUnitQue.setCuType(cuType);
        List<ControlUnitVO> controlUnitList = controlUnitMapper.selectListQue(controlUnitQue);
        if(controlUnitList.size()!=0)
            throw new DamPourException(30000,"测控单元地址重复");
    }
    @Override
    public void add(AddControlUnitReq addControlUnitReq, String userName) {
        checkData(addControlUnitReq.getCuAddr(),addControlUnitReq.getCuType());
        ControlUnit ControlUnit = new ControlUnit();
        BeanUtils.copyProperties(addControlUnitReq,ControlUnit);
        ControlUnit.setOperator(userName);
        ControlUnit.setCreateTime(TimeUtils.getNowTime());
        int count = controlUnitMapper.insertSelective(ControlUnit);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateControlUnitReq updateControlUnitReq){
        ControlUnit controlUnit =
                controlUnitMapper.selectByPrimaryKey(updateControlUnitReq.getId());
        if (controlUnit == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        if(!controlUnit.getCuType().equals("远程测控")&&!controlUnit.getCuAddr().equals(updateControlUnitReq.getCuAddr()))
        {
            checkData(updateControlUnitReq.getCuAddr(),updateControlUnitReq.getCuType());
        }
        BeanUtils.copyProperties(updateControlUnitReq,controlUnit);

        int count = controlUnitMapper.updateByPrimaryKeySelective(controlUnit);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = controlUnitMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ControlUnitVO> controlUnitList = controlUnitMapper.selectList();
        PageInfo pageInfo = new PageInfo(controlUnitList);
        return pageInfo;
    }

    @Override
    public List<ControlUnitVO> listByIds(Integer[] ids) {
        List<ControlUnitVO> categoryList = controlUnitMapper.selectListByIds(ids);
        return categoryList;

    }

//    @Override
//    public List<ControlUnit> listBySmallSbId(Integer[] smallSbNo) {
//        List<ControlUnit> selectVoList = controlUnitMapper.selectBySmallSbNo(smallSbNo);
//        return selectVoList;
//    }

    @Override
    public List<ControlUnitVO> controlUnitState(Integer kzxId) {
        List<ControlUnitVO> categoryList = controlUnitMapper.controlUnitState(kzxId);
        for (ControlUnitVO controlUnitVO: categoryList)
        {
            controlUnitVO.setState(0);
        }
        return categoryList;
    }

    @Override
    public List<ControlUnitVO> flowState(Integer sbId) {
        List<ControlUnitVO> categoryList = controlUnitMapper.flowState(sbId);
        for (ControlUnitVO controlUnitVO: categoryList)
        {
            controlUnitVO.setState(0);
        }
        return categoryList;
    }

    @Override
    public PageInfo select(ControlUnitQue controlUnitQue) {
        PageHelper.startPage(controlUnitQue.getPageNum(), controlUnitQue.getPageSize());
        List<ControlUnitVO> controlUnitList = controlUnitMapper.selectListQue(controlUnitQue);
        PageInfo pageInfo = new PageInfo(controlUnitList);
        return pageInfo;
    }

    @Override
    public List<ControlUnitVO> exportList() {
        List<ControlUnitVO> controlUnitList = controlUnitMapper.selectList();
        return controlUnitList;
    }
}
