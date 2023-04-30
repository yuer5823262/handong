package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingSandInfo;
import com.example.dampouring.query.MixingWaterInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingSandInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingSandInfo record);

    int insertSelective(MixingSandInfo record);

    MixingSandInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingSandInfo record);

    int updateByPrimaryKey(MixingSandInfo record);

    List<MixingSandInfo> selectList(MixingWaterInfoQue mixingSandInfoQue);
}