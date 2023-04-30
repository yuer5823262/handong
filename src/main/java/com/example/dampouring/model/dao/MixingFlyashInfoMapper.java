package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingFlyashInfo;
import com.example.dampouring.query.MixingFlyashInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingFlyashInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingFlyashInfo record);

    int insertSelective(MixingFlyashInfo record);

    MixingFlyashInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingFlyashInfo record);

    int updateByPrimaryKey(MixingFlyashInfo record);

    List<MixingFlyashInfo> selectList(MixingFlyashInfoQue mixingFlyashInfoQue);
}