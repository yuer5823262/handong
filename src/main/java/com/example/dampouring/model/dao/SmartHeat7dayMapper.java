package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartHeat7day;
import com.example.dampouring.model.vo.SmartHeat7dayVO;
import com.example.dampouring.query.AlertQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartHeat7dayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartHeat7day record);

    int insertSelective(SmartHeat7day record);

    SmartHeat7day selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartHeat7day record);

    int updateByPrimaryKey(SmartHeat7day record);

    List<SmartHeat7dayVO> selectList(AlertQue alertQue);
}