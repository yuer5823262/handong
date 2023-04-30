package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.ControlUnit;
import com.example.dampouring.model.vo.ControlUnitVO;
import com.example.dampouring.model.vo.ControllerUnitValueVO;
import com.example.dampouring.query.ControlUnitQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ControlUnitMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(ControlUnit record);

    int insertSelective(ControlUnit record);

    ControlUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ControlUnit record);

    int updateByPrimaryKey(ControlUnit record);

    List<ControlUnitVO> selectListByIds(@Param("ids") Integer[] ids);

    List<ControlUnit> selectBySmallSbNo(@Param("smallSbNo")Integer[] smallSbNo);

    List<ControlUnitVO> selectList();

    List<ControlUnitVO> controlUnitState(Integer kzxId);

    List<ControlUnitVO> flowState(Integer sbId);

    List<ControllerUnitValueVO> selectByComputing();

    List<ControlUnitVO> selectListQue(ControlUnitQue controlUnitQue);
}