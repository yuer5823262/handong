package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.EquipmentAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.EquipmentAlertVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.EquipmentAlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentAlert record);

    int insertSelective(EquipmentAlert record);

    EquipmentAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EquipmentAlert record);

    int updateByPrimaryKey(EquipmentAlert record);

    List<EquipmentAlertVO> selectList(EquipmentAlertQue alertQue);

    int processinge(@Param("ids") Integer[] ids);

    List<AlertBaseVO> list(Integer type);
}