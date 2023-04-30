package com.example.dampouring.service.impl;

import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.MenuMapper;
import com.example.dampouring.model.pojo.Menu;
import com.example.dampouring.model.request.AddMenuReq;
import com.example.dampouring.model.request.UpdateMenuReq;
import com.example.dampouring.service.MenuService;
import com.example.dampouring.util.TimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper MenuMapper;

    @Override
    public void add(AddMenuReq addMenuReq, String userName) {
        Menu Menu = new Menu();
        BeanUtils.copyProperties(addMenuReq,Menu);
        Menu.setOperator(userName);
        Menu.setCreateTime(TimeUtils.getNowTime());
        int count = MenuMapper.insertSelective(Menu);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateMenuReq updateMenuReq){
        Menu Menu =
                MenuMapper.selectByPrimaryKey(updateMenuReq.getId());
        if (Menu == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
//        Menu MenuCheck =
//                MenuMapper.selectByName(updateMenuReq.getBsName());
//        if (MenuCheck != null &&
//                !MenuCheck.getBsNo().equals(Menu.getBsNo()) ) {
//
//            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
//        }
        BeanUtils.copyProperties(updateMenuReq,Menu);

        int count = MenuMapper.updateByPrimaryKeySelective(Menu);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = MenuMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public List<Menu> orUserList() {

        List<Menu> MenuList = MenuMapper.selectList();
        return MenuList;
    }
}
