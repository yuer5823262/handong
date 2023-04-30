package com.example.dampouring.service;

import com.example.dampouring.model.pojo.SwConcretePara;
import com.example.dampouring.model.request.AddSwConcreteParaReq;
import com.example.dampouring.model.request.UpdateSwConcreteParaReq;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SwConcreteParaService {
    void add(AddSwConcreteParaReq addSwConcreteParaReq, String userName);

    void update(UpdateSwConcreteParaReq updateSwConcreteParaReq);

    void delete(Integer[] ids);

    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<SwConcretePara> listByIds(Integer[] ids);
}
