package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.TempControlNormName;
import com.example.dampouring.query.TempControlNormNameQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TempControlNormNameMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(TempControlNormName record);

    int insertSelective(TempControlNormName record);

    TempControlNormName selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempControlNormName record);

    int updateByPrimaryKey(TempControlNormName record);

    List<TempControlNormName> selectList(TempControlNormNameQue name);

    List<TempControlNormName> selectListByIds(@Param("ids") Integer[] ids);
}