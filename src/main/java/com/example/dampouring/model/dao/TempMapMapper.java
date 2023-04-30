package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempMap;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempMapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TempMap record);

    int insertSelective(TempMap record);

    TempMap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempMap record);

    int updateByPrimaryKey(TempMap record);

    List<TempMap> listBySbId(Integer sbId,String type);

    TempMap selectBySbIdAndName(Integer sbId, String name,String type);
}