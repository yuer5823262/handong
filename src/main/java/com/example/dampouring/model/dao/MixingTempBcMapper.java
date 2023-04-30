package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingTempBc;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingTempBcMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingTempBc record);

    int insertSelective(MixingTempBc record);
    List<MixingTempBc> list();
    MixingTempBc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingTempBc record);

    int updateByPrimaryKey(MixingTempBc record);
    int selectBySourceId(String sourceId);
}