package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.BigSegment;
import com.example.dampouring.query.BigSegmentQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BigSegmentMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(BigSegment record);

    int insertSelective(BigSegment record);

    BigSegment selectByPrimaryKey(Integer bsNo);

    BigSegment selectByName(String name);

    List<BigSegment> selectList();

    List<BigSegment> selectListByIds(@Param("ids") Integer[] ids);

    int updateByPrimaryKeySelective(BigSegment record);

    int updateByPrimaryKey(BigSegment record);

    List<BigSegment> selectListByContractor(String value);


    List<BigSegment> selectListQue(BigSegmentQue bigSegmentQue);
}