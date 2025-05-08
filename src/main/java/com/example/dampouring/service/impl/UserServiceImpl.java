package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.dao.DamPourLogMapper;
import com.example.dampouring.model.dao.UserTableMapper;
import com.example.dampouring.model.pojo.DamPourLog;
import com.example.dampouring.model.pojo.SystemConstant;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.request.RegisterUserReq;
import com.example.dampouring.model.request.UpdateUserReq;
import com.example.dampouring.model.vo.UserVO;
import com.example.dampouring.service.SystemConstantService;
import com.example.dampouring.service.UserService;
import com.example.dampouring.util.JwtUtils;
import com.example.dampouring.util.MD5Utils;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.util.TimeUtils;
import com.example.dampouring.util.copyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import com.szgc.core.auth.OAuth2ClientFactory;
//import com.szgc.core.security.oauth2.IOauth2ClientService;
//import com.szgc.core.security.oauth2.Oauth2Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    UserTableMapper userMapper;

    @Autowired
    DamPourLogMapper damPourLogMapper;
    @Autowired
    SystemConstantService systemConstantService;
    @Override
    public UserTable getUser(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void register(RegisterUserReq registerUserReq) throws  NoSuchAlgorithmException {
        UserTable result= userMapper.selectByUserName(registerUserReq.getUsername());
        if(result != null){
            throw new DamPourException(DampouringExceptionEnum.NAME_EXISTED);
        }
        UserTable user = new UserTable();
        BeanUtils.copyProperties(registerUserReq,user);
        user.setPwd(MD5Utils.getMD5Str(user.getPwd()));
        int conut = userMapper.insertSelective(user);
        if(conut==0){
            throw new DamPourException(DampouringExceptionEnum.INSERT_FAILED);
        }

    }
    @Override
    public UserTable login(String userName, String password, String ip) throws DamPourException {
        String md5Pwd = null;
        try {
            md5Pwd = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            Constant.logger.error("错误:",e);
        }

        UserTable user = userMapper.selectLogin(userName,md5Pwd);

        if (user ==null)
            throw new DamPourException(DampouringExceptionEnum.PASSWORD_WRONG);
        DamPourLog damPourLog = new DamPourLog();
        damPourLog.setIpAddr(ip);
        damPourLog.setTime(TimeUtils.getNowTime());
        damPourLog.setOperator(user.getUsername());
        damPourLog.setType("login");
        damPourLogMapper.insertSelective(damPourLog);
        return user;
    }



    @Override
    public boolean checkAdminRole(UserTable currentUser) {
        return currentUser.getRole()==1;
    }

    @Override
    public void updateInfomation(UserTable currentUser, UpdateUserReq updateUserReq) {
        try {
            String oldPwd = MD5Utils.getMD5Str(updateUserReq.getOldPwd());
            if(!oldPwd.equals(currentUser.getPwd())){
                throw new DamPourException(DampouringExceptionEnum.PASSWORD_WRONG);
            }
        } catch (NoSuchAlgorithmException e) {
            Constant.logger.error("错误:",e);
        }
        copyUtils.copyPropertiesIgnoreNull(updateUserReq,currentUser);
        try {
            currentUser.setPwd(MD5Utils.getMD5Str(currentUser.getPwd()));
        } catch (NoSuchAlgorithmException e) {
            Constant.logger.error("错误:",e);
        }
        int updateCount = userMapper.updateByPrimaryKeySelective(currentUser);
        if (updateCount > 1) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }

    @Override
    public UserTable getInfo(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserTable> subControlStationList = userMapper.selectList();
        PageInfo pageInfo = new PageInfo(subControlStationList);
        return pageInfo;
    }

    @Override
    public void delete(Integer[] ids) {
        int count = userMapper.deleteByPrimaryKey(ids);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }

    @Override
    public void logout(String currentUser, String ip) {
        DamPourLog damPourLog = new DamPourLog();
        damPourLog.setIpAddr(ip);
        damPourLog.setTime(TimeUtils.getNowTime());
        damPourLog.setOperator(currentUser);
        damPourLog.setType("logout");
        damPourLogMapper.insertSelective(damPourLog);
    }

    @Override
    public void update(UpdateUserReq updateUserReq) {
        UserTable currentUser = new UserTable();
        copyUtils.copyPropertiesIgnoreNull(updateUserReq,currentUser);
        if(!currentUser.getPwd().isEmpty()) {
            try {
                currentUser.setPwd(MD5Utils.getMD5Str(currentUser.getPwd()));
            } catch (NoSuchAlgorithmException e) {
                Constant.logger.error("错误:",e);
            }
        }
        int updateCount = userMapper.updateByPrimaryKeySelective(currentUser);
        if (updateCount > 1) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }
    @Override
    public UserVO oauth2(String oauthToken) {
        return null;
    }


    @Override
    public UserVO dataInterface()
    {
        SystemConstant dduser = systemConstantService.selectByType("dduser");
        UserTable user = userMapper.selectByUserName(dduser.getVal());
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        userVO.setToken(JwtUtils.getToken(user));
        return userVO;
    }
    @Override
    public UserVO oauth(String oauthToken) {
        SystemConstant ddip = systemConstantService.selectByType("ddip");
        SystemConstant dduser = systemConstantService.selectByType("dduser");
        String url = "http://"+ddip.getVal()+"?token=" + oauthToken;
        RestTemplate restTemplate = new RestTemplate();
        String response;
        try {
            response = restTemplate.getForObject(url, String.class);
        }
        catch(Exception e){
            throw new DamPourException(13524,"单点登录失败");
        }
        if (response == null || !response.contains("user_name")) {
            throw new DamPourException(13524,"单点登录失败");
        }
        UserTable user = userMapper.selectByUserName(dduser.getVal());
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        userVO.setToken(JwtUtils.getToken(user));
        return userVO;
    }
//    @Override
//    public UserVO oauth2(String oauthToken) {
////        oauthToken = oauthToken.replaceAll(" ","+");
//        IOauth2ClientService iOauth2ClientService= OAuth2ClientFactory.createOauth2ClientByKey(Constant.OAUTH2_KEY,Constant.APP_ID,Constant.OAUTH2_URL);
//        Oauth2Result oauth2Result = iOauth2ClientService.doVerify(oauthToken);
//        UserVO userVO = new UserVO();
//        if(oauth2Result.isSuccess())
//        {
//            String userName = oauth2Result.getData().getUsername();
//            UserTable user = userMapper.selectByUserName(userName);
//            if (user ==null)
//                throw new DamPourException(12345,"匹配不到本地用户");
//            BeanUtils.copyProperties(user,userVO);
//            userVO.setToken(JwtUtils.getToken(user));
//        }
//        else
//        {
//            throw new DamPourException(oauth2Result.getCode(),oauth2Result.getMessage());
//        }
//        return userVO;
//    }

}
