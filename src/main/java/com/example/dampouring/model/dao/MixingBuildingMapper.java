package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingBuilding;
import com.example.dampouring.query.MixingBuildingQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingBuildingMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(MixingBuilding record);

    int insertSelective(MixingBuilding record);

    MixingBuilding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingBuilding record);

    int updateByPrimaryKey(MixingBuilding record);

    List<MixingBuilding> selectList();

    List<MixingBuilding> selectListByIds(Integer[] ids);

    MixingBuilding selectByNo(String mbNo);

    List<MixingBuilding> selectListByQue(MixingBuildingQue mixingBuildingQue);
}