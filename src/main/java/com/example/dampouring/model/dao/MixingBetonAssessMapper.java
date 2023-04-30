package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingBetonAssess;
import com.example.dampouring.query.MixingBetonAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingBetonAssessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingBetonAssess record);

    int insertSelective(MixingBetonAssess record);

    MixingBetonAssess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingBetonAssess record);

    int updateByPrimaryKey(MixingBetonAssess record);

    List<MixingBetonAssess> selectList(MixingBetonAssessQue mixingBetonAssessQue);

    void delAll();

    List<MixingBetonAssess> timingComputing();
}