package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.HeatPreservation;
import com.example.dampouring.model.vo.HeatPreservationVO;
import com.example.dampouring.query.HeatPreservationQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HeatPreservationMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(HeatPreservation record);

    int insertSelective(HeatPreservation record);

    HeatPreservation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HeatPreservation record);

    int updateByPrimaryKey(HeatPreservation record);

    List<HeatPreservationVO> selectList();

    List<HeatPreservationVO> selectListByIds(@Param("ids") Integer[] ids);

    List<HeatPreservationVO> selectListByQue(HeatPreservationQue heatPreservationQue);
}