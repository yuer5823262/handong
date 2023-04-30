package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmallStorageBin;
import com.example.dampouring.query.StorageBinQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmallStorageBinMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(SmallStorageBin record);

    int insertSelective(SmallStorageBin record);

    SmallStorageBin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmallStorageBin record);

    int updateByPrimaryKey(SmallStorageBin record);

    List<SmallStorageBin> selectVoList();

    List<SmallStorageBin> selectByIds(@Param("ids") Integer[] ids);


    List<SmallStorageBin> selectVoListQue(StorageBinQue storageBinQue);

    Integer[] selectByComputing();

    SmallStorageBin selectBySbNo(String sbNo);
}