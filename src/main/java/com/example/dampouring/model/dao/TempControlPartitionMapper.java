package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempControlPartition;
import com.example.dampouring.model.vo.TempControlPartitionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempControlPartitionMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(TempControlPartition record);

    int insertSelective(TempControlPartition record);

    TempControlPartition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempControlPartition record);

    int updateByPrimaryKey(TempControlPartition record);

    List<TempControlPartitionVO> selectList();

    List<TempControlPartitionVO> selectListByIds(@Param("ids") Integer[] ids);
}