package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.RoleDetailMapper;
import com.example.dampouring.model.pojo.RoleDetail;
import com.example.dampouring.model.request.AddRoleDetailReq;
import com.example.dampouring.model.request.UpdateRoleDetailReq;
import com.example.dampouring.service.RoleDetailService;
import com.example.dampouring.util.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleDetailServiceImpl implements RoleDetailService {
    @Autowired
    RoleDetailMapper RoleDetailMapper;

    @Override
    public void add(AddRoleDetailReq addRoleDetailReq, String userName) {
        RoleDetail RoleDetail = new RoleDetail();
        BeanUtils.copyProperties(addRoleDetailReq,RoleDetail);
        RoleDetail.setOperator(userName);
        RoleDetail.setCreateTime(TimeUtils.getNowTime());
        int count = RoleDetailMapper.insertSelective(RoleDetail);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateRoleDetailReq updateRoleDetailReq){
        RoleDetail RoleDetail =
                RoleDetailMapper.selectByPrimaryKey(updateRoleDetailReq.getId());
        if (RoleDetail == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
//        RoleDetail RoleDetailCheck =
//                RoleDetailMapper.selectByName(updateRoleDetailReq.getBsName());
//        if (RoleDetailCheck != null &&
//                !RoleDetailCheck.getBsNo().equals(RoleDetail.getBsNo()) ) {
//
//            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
//        }
        BeanUtils.copyProperties(updateRoleDetailReq,RoleDetail);

        int count = RoleDetailMapper.updateByPrimaryKeySelective(RoleDetail);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = RoleDetailMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public List<RoleDetail> orUserList(Integer roleId) {

        List<RoleDetail> RoleDetailList = RoleDetailMapper.selectList(roleId);
        return RoleDetailList;
    }
}
