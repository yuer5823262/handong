package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.model.pojo.TempControlNormInfo;
import com.example.dampouring.model.vo.TempControlNormInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempControlNormInfoMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(TempControlNormInfo record);

    int insertSelective(TempControlNormInfo record);

    TempControlNormInfo selectByPrimaryKey(Integer id);

    TempControlNormInfo selectByMonth(Integer month);

    int updateByPrimaryKeySelective(TempControlNormInfo record);

    int updateByPrimaryKey(TempControlNormInfo record);

    List<TempControlNormInfoVO> selectListByIds(@Param("ids") Integer[] ids);

    List<TempControlNormInfoVO> selectList();

    TempControlNormInfoVO selectBySb(SmallStorageBin smallStorageBin);
}