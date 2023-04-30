package com.example.dampouring.service;

import com.example.dampouring.model.pojo.SwBata;
import com.example.dampouring.model.request.AddSwBataReq;
import com.example.dampouring.model.request.UpdateSwBataReq;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
import java.util.List;

public interface SwBataService {
    void add(AddSwBataReq addSwBataReq, String userName);

    void update(UpdateSwBataReq updateSwBataReq);

    void delete(Integer[] ids);

    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<SwBata> listByIds(Integer[] ids);

    void writeFile() throws IOException;
}
