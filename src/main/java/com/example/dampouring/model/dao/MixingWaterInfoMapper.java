package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingWaterInfo;
import com.example.dampouring.query.MixingWaterInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingWaterInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingWaterInfo record);

    int insertSelective(MixingWaterInfo record);

    MixingWaterInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingWaterInfo record);

    int updateByPrimaryKey(MixingWaterInfo record);

    List<MixingWaterInfo> selectList(MixingWaterInfoQue mixingWaterInfoQue);
}