package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingFlyashAssess;
import com.example.dampouring.query.MixingFlyashAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingFlyashAssessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingFlyashAssess record);

    int insertSelective(MixingFlyashAssess record);

    MixingFlyashAssess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingFlyashAssess record);

    int updateByPrimaryKey(MixingFlyashAssess record);

    List<MixingFlyashAssess> selectList(MixingFlyashAssessQue mixingFlyashAssessQue);

    void delAll();

    List<MixingFlyashAssess> timingComputing();
}