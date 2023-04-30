package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MixingAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MixingAlertVO;
import com.example.dampouring.query.AlertQue;
import com.example.dampouring.query.MixingAlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MixingAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MixingAlert record);

    int insertSelective(MixingAlert record);

    MixingAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MixingAlert record);

    int updateByPrimaryKey(MixingAlert record);

    List<MixingAlertVO> selectList(MixingAlertQue alertQue);

    int processinge(@Param("ids") Integer[] ids);

    List<AlertBaseVO> list(Integer type);
}