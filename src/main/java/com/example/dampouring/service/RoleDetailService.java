package com.example.dampouring.service;

import com.example.dampouring.model.pojo.RoleDetail;
import com.example.dampouring.model.request.AddRoleDetailReq;
import com.example.dampouring.model.request.UpdateRoleDetailReq;

import java.util.List;

public interface RoleDetailService {
    void add(AddRoleDetailReq addRoleDetailReq, String userName);

    void update(UpdateRoleDetailReq updateRoleDetailReq);

    void delete(Integer[] ids);


    List<RoleDetail> orUserList(Integer roleId);
}
