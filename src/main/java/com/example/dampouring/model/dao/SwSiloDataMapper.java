package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SwSiloData;
import com.example.dampouring.model.vo.SwSiloDataVO;
import com.example.dampouring.model.vo.SwZyDataVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwSiloDataMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] id);

    int insert(SwSiloData record);

    int insertSelective(SwSiloData record);

    SwSiloData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SwSiloData record);

    int updateByPrimaryKey(SwSiloData record);

    List<SwSiloDataVO> selectList();

    List<SwSiloData> selectListByIds(@Param("ids") Integer[] ids);

    List<SwSiloDataVO> getData();
    List<SwZyDataVO> getDataZY();
}