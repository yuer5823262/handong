package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartMixingPara;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartMixingParaMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(SmartMixingPara record);

    int insertSelective(SmartMixingPara record);

    SmartMixingPara selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartMixingPara record);

    int updateByPrimaryKey(SmartMixingPara record);

    List<SmartMixingPara> selectList();

    SmartMixingPara selectByMbId(Integer mbId);
}