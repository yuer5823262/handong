package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.DamPourLog;
import com.example.dampouring.query.DamPourLogQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DamPourLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DamPourLog record);

    int insertSelective(DamPourLog record);

    DamPourLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DamPourLog record);

    int updateByPrimaryKey(DamPourLog record);

    List<DamPourLog> selectList(DamPourLogQue damPourLogQue);
}