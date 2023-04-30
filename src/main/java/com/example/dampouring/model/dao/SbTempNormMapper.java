package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SbTempNorm;
import com.example.dampouring.model.vo.SbTempNormVO;
import com.example.dampouring.query.SbTempNormQue;
import com.example.dampouring.query.SelectNormQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SbTempNormMapper {
    int deleteByPrimaryKey(@Param("ids")Integer[] ids);

    int insert(SbTempNorm record);

    int insertSelective(SbTempNorm record);

    SbTempNorm selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SbTempNorm record);

    int updateByPrimaryKey(SbTempNorm record);

    List<SbTempNormVO> List(SbTempNormQue sbTempNormQue);

    List<SbTempNormVO> selectByIds(@Param("ids") Integer[] ids);

    SbTempNormVO selectNorm(SelectNormQue selectNormQue);
}