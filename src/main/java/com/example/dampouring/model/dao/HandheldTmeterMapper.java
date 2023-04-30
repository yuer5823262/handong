package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.HandheldTmeter;
import com.example.dampouring.model.vo.HandheldTmeterVO;
import com.example.dampouring.query.HandheldTmeterQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HandheldTmeterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HandheldTmeter record);

    int insertSelective(HandheldTmeter record);

    HandheldTmeter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HandheldTmeter record);

    int updateByPrimaryKey(HandheldTmeter record);

    List<HandheldTmeterVO> selectList(HandheldTmeterQue handheldTmeterQue);
}