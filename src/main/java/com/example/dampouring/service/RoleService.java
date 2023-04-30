package com.example.dampouring.service;

import com.example.dampouring.model.pojo.Role;
import com.example.dampouring.model.request.AddRoleReq;
import com.example.dampouring.model.request.UpdateRoleReq;

import java.util.List;

public interface RoleService {
    void add(AddRoleReq addRoleReq, String userName);

    void update(UpdateRoleReq updateRoleReq);

    void delete(Integer[] ids);

    Role selectById(Integer id);
    List<Role> orUserList();

    List<Role> listByIds(Integer[] ids);
}
