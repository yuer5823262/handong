package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.HandAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.query.HandAlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HandAlertMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(HandAlert record);

    int insertSelective(HandAlert record);

    HandAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HandAlert record);

    int updateByPrimaryKey(HandAlert record);

    List<HandAlert> selectList(HandAlertQue handAlertQue);

    int processinge(@Param("ids") Integer[] ids);

    List<AlertBaseVO> list(Integer type, Integer roleId);
}