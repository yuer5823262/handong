package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.UserTable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTableMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(UserTable record);

    int insertSelective(UserTable record);

    UserTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTable record);

    int updateByPrimaryKey(UserTable record);

    UserTable selectByUserName(String userName);

    UserTable selectLogin(@Param("userName") String userName,
                          @Param("password") String password);

    List<UserTable> selectList();
}