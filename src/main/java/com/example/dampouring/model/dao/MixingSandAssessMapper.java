package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingSandAssess;
import com.example.dampouring.query.MixingWaterAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingSandAssessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingSandAssess record);

    int insertSelective(MixingSandAssess record);

    MixingSandAssess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingSandAssess record);

    int updateByPrimaryKey(MixingSandAssess record);

    List<MixingSandAssess> selectList(MixingWaterAssessQue mixingSandAssessQue);

    void delAll();

    List<MixingSandAssess> timingComputing();
}