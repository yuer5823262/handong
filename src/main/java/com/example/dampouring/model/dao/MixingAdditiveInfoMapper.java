package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingAdditiveInfo;
import com.example.dampouring.query.MixingWaterInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingAdditiveInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingAdditiveInfo record);

    int insertSelective(MixingAdditiveInfo record);

    MixingAdditiveInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingAdditiveInfo record);

    int updateByPrimaryKey(MixingAdditiveInfo record);

    List<MixingAdditiveInfo> selectList(MixingWaterInfoQue mixingAdditiveInfoQue);
}