package com.example.dampouring.service;

import com.example.dampouring.model.pojo.SystemConstant;

import java.util.List;

public interface SystemConstantService {

    void update(Integer id, String val);

    void setConsTantVal();

    List<SystemConstant> orUserList();
    SystemConstant selectByType(String type);

    String getSystemName();
}
