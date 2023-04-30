package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.RoleMapper;
import com.example.dampouring.model.pojo.FaceMicroClimate;
import com.example.dampouring.model.pojo.Role;
import com.example.dampouring.model.request.AddRoleReq;
import com.example.dampouring.model.request.UpdateRoleReq;
import com.example.dampouring.service.RoleService;
import com.example.dampouring.util.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper RoleMapper;

    @Override
    public void add(AddRoleReq addRoleReq, String userName) {
        Role Role = new Role();
        BeanUtils.copyProperties(addRoleReq,Role);
        Role.setOperator(userName);
        Role.setCreateTime(TimeUtils.getNowTime());
        int count = RoleMapper.insertSelective(Role);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateRoleReq updateRoleReq){
        Role Role =
                RoleMapper.selectByPrimaryKey(updateRoleReq.getId());
        if (Role == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
//        Role RoleCheck =
//                RoleMapper.selectByName(updateRoleReq.getBsName());
//        if (RoleCheck != null &&
//                !RoleCheck.getBsNo().equals(Role.getBsNo()) ) {
//
//            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
//        }
        BeanUtils.copyProperties(updateRoleReq,Role);

        int count = RoleMapper.updateByPrimaryKeySelective(Role);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = RoleMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }

    @Override
    public Role selectById(Integer id) {
        return RoleMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<Role> orUserList() {

        List<Role> RoleList = RoleMapper.selectList();
        return RoleList;
    }

    @Override
    public List<Role> listByIds(Integer[] ids) {
        List<Role> categoryList = RoleMapper.selectListByIds(ids);

        return categoryList;
    }
}
