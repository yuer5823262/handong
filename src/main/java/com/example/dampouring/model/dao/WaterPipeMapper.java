package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.WaterPipe;
import com.example.dampouring.model.vo.WaterPipeVO;
import com.example.dampouring.query.WaterPipeQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterPipeMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(WaterPipe record);

    int insertSelective(WaterPipe record);

    WaterPipe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WaterPipe record);

    int updateByPrimaryKey(WaterPipe record);

    List<WaterPipeVO> selectList(WaterPipeQue waterPipeQue);

    List<WaterPipeVO> selectListByIds(@Param("ids") Integer[] ids);

    List<WaterPipeVO> selectBySmallId(Integer smallId);
    List<WaterPipeVO> selectBySbNo(String sbNo);
    List<WaterPipeVO> selectByComputing();

    List<WaterPipeVO> selectListByCuId(Integer cuId);

    String getQsByWPid(Integer wpId);

    List<WaterPipeVO> getTsData();
}