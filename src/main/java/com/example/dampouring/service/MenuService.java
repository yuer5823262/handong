package com.example.dampouring.service;

import com.example.dampouring.model.pojo.Menu;
import com.example.dampouring.model.request.AddMenuReq;
import com.example.dampouring.model.request.UpdateMenuReq;

import java.util.List;

public interface MenuService {
    void add(AddMenuReq addMenuReq, String userName);

    void update(UpdateMenuReq updateMenuReq);

    void delete(Integer[] ids);


    List<Menu> orUserList();
}
