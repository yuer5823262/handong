package com.example.dampouring.service;

import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.model.request.RegisterUserReq;
import com.example.dampouring.model.request.UpdateUserReq;
import com.example.dampouring.model.vo.UserVO;
import com.github.pagehelper.PageInfo;

import java.security.NoSuchAlgorithmException;

public interface UserService {
    UserTable getUser(int userId);
    void register(RegisterUserReq registerUserReq) throws DamPourException, NoSuchAlgorithmException;

    UserTable login(String userName, String password, String ip) throws DamPourException;

    boolean checkAdminRole(UserTable currentUser);

    void updateInfomation(UserTable currentUser, UpdateUserReq updateUserReq);


    UserTable getInfo(Integer id);

    PageInfo orUserList(Integer pageNum, Integer pageSize);

    void delete(Integer[] ids);

    void logout(String currentUser, String ip);

    void update(UpdateUserReq updateUserReq);

    UserVO oauth2(String oauth2Result);

    UserVO dataInterface();

    UserVO oauth(String oauthToken);
}
