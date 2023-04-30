package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TopTempAssess;
import com.example.dampouring.model.vo.TopTempAssessVO;
import com.example.dampouring.query.TopTempAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopTempAssessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopTempAssess record);

    int insertSelective(TopTempAssess record);

    TopTempAssess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopTempAssess record);

    int updateByPrimaryKey(TopTempAssess record);

    List<TopTempAssessVO> List();

    List<TopTempAssessVO> selectList(TopTempAssessQue topTempAssessQue);

    void deleteAll();
}