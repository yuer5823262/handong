package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.ControlProcess;
import com.example.dampouring.query.ControlProcessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControlProcessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ControlProcess record);

    int insertSelective(ControlProcess record);

    ControlProcess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ControlProcess record);

    int updateByPrimaryKey(ControlProcess record);

    List<ControlProcess> selectList(ControlProcessQue controlProcessQue);
}