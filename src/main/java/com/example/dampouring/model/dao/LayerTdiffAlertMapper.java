package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.LayerTdiffAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.LayerTdiffAlertVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.SbTempNo;
import com.example.dampouring.query.AlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LayerTdiffAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LayerTdiffAlert record);

    int insertSelective(LayerTdiffAlert record);

    LayerTdiffAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LayerTdiffAlert record);

    int updateByPrimaryKey(LayerTdiffAlert record);

    List<LayerTdiffAlertVO> selectList(AlertQue alertQue);

    int processinge(@Param("ids") Integer[] ids);

    List<SbTempNo> sbTemp(String time);

    MaxTempNormVO normInfo(Integer sbId);

    List<AlertBaseVO> list(Integer type);
}