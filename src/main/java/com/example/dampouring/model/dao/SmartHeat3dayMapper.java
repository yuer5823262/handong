package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartHeat3day;
import com.example.dampouring.model.vo.SmartHeat3dayVO;
import com.example.dampouring.query.AlertQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartHeat3dayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartHeat3day record);

    int insertSelective(SmartHeat3day record);

    SmartHeat3day selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartHeat3day record);

    int updateByPrimaryKey(SmartHeat3day record);

    List<SmartHeat3dayVO> selectList(AlertQue alertQue);
}