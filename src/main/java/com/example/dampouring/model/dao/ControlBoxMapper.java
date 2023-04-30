package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.ControlBox;
import com.example.dampouring.model.vo.ControlBoxVO;
import com.example.dampouring.query.WaterRainStationQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControlBoxMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(ControlBox record);

    int insertSelective(ControlBox record);

    ControlBox selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ControlBox record);

    int updateByPrimaryKey(ControlBox record);

    ControlBox selectByCbNo(String cbNo);

    List<ControlBoxVO> selectList();

    List<ControlBoxVO> selectListByIds(@Param("ids") Integer[] ids);

    List<ControlBox> selectByScsId(Integer scsId);

    List<ControlBoxVO> selectByQue(WaterRainStationQue waterRainStationQue);
}