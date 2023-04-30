package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingBetonInfo;
import com.example.dampouring.query.MixingBetonInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingBetonInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingBetonInfo record);

    int insertSelective(MixingBetonInfo record);

    MixingBetonInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingBetonInfo record);

    int updateByPrimaryKey(MixingBetonInfo record);

    List<MixingBetonInfo> selectList(MixingBetonInfoQue mixingBetonInfoQue);
}