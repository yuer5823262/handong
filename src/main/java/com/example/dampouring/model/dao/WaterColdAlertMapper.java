package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.WaterColdAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.example.dampouring.model.vo.WaterColdAlertVO;
import com.example.dampouring.query.AlertQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterColdAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WaterColdAlert record);

    int insertSelective(WaterColdAlert record);

    WaterColdAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WaterColdAlert record);

    int updateByPrimaryKey(WaterColdAlert record);

    List<WaterColdAlertVO> selectList(AlertQue alertQue);

    int processinge(Integer[] ids);

    MaxTempNormVO normInfo(Integer waterPipeId);

    List<AlertBaseVO> list(Integer type);
}