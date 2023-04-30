package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MaxTempAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempAlertVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.query.AlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaxTempAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaxTempAlert record);

    int insertSelective(MaxTempAlert record);

    MaxTempAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaxTempAlert record);

    int updateByPrimaryKey(MaxTempAlert record);

    List<MaxTempAlertVO> selectList(AlertQue maxTempAlertQue);

    int processinge(@Param("ids") Integer[] ids);


    MaxTempNormVO normInfo(Integer itsId);

    List<AlertBaseVO> list(Integer type);
}