package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.RoleDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDetailMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(RoleDetail record);

    int insertSelective(RoleDetail record);

    RoleDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleDetail record);

    int updateByPrimaryKey(RoleDetail record);

    List<RoleDetail> selectList(Integer roleId);
}