package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.RainWaterInfo;
import com.example.dampouring.query.RainWaterInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RainWaterInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RainWaterInfo record);

    int insertSelective(RainWaterInfo record);

    RainWaterInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RainWaterInfo record);

    int updateByPrimaryKey(RainWaterInfo record);

    List<RainWaterInfo> List(String type);

    List<RainWaterInfo> selectList(RainWaterInfoQue rainWaterInfoQue);
}