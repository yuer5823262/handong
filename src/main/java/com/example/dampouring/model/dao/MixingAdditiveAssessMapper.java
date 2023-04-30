package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingAdditiveAssess;
import com.example.dampouring.query.MixingWaterAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingAdditiveAssessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingAdditiveAssess record);

    int insertSelective(MixingAdditiveAssess record);

    MixingAdditiveAssess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingAdditiveAssess record);

    int updateByPrimaryKey(MixingAdditiveAssess record);

    List<MixingAdditiveAssess> selectList(MixingWaterAssessQue mixingAdditiveAssessQue);

    List<MixingAdditiveAssess> timingComputing();

    void delAll();
}