package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingBetonAssess;
import com.example.dampouring.model.pojo.MixingWaterAssess;
import com.example.dampouring.query.MixingWaterAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingWaterAssessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingWaterAssess record);

    int insertSelective(MixingWaterAssess record);

    MixingWaterAssess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingWaterAssess record);

    int updateByPrimaryKey(MixingWaterAssess record);

    List<MixingWaterAssess> selectList(MixingWaterAssessQue mixingWaterAssessQue);

    void delAll();

    List<MixingWaterAssess> timingComputing();
}