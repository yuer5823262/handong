package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempGradometer;
import com.example.dampouring.model.vo.TempGradometerVO;
import com.example.dampouring.query.TempGradometerQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempGradometerMapper {


    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(TempGradometer record);

    int insertSelective(TempGradometer record);

    TempGradometer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempGradometer record);

    int updateByPrimaryKey(TempGradometer record);

    TempGradometer selectByTgmName(String tgmName);

    List<TempGradometerVO> selectList(TempGradometerQue tempGradometerQue);

    List<TempGradometerVO> selectListByIds(@Param("ids") Integer[] ids);

    List<TempGradometerVO> selectListByCuId(Integer cuId);

    List<TempGradometer> selectByCuIdCNo(Integer cuId, Integer channelNo);

    List<TempGradometer> listByUseful();
}