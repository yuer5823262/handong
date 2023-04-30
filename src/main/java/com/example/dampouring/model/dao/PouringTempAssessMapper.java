package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.PouringTempAssess;
import com.example.dampouring.model.vo.PouringTempAssessVO;
import com.example.dampouring.query.PouringTempAssessQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PouringTempAssessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PouringTempAssess record);

    int insertSelective(PouringTempAssess record);

    PouringTempAssess selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PouringTempAssess record);

    int updateByPrimaryKey(PouringTempAssess record);

    List<PouringTempAssessVO> List();

    List<PouringTempAssessVO> selectList(PouringTempAssessQue pouringTempAssessQue);

    void deleteAll();
}