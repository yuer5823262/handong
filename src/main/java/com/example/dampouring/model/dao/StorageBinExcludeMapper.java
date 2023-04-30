package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.StorageBinExclude;
import com.example.dampouring.model.vo.StorageBinExcludeVO;
import com.example.dampouring.query.StorageBinExcludeQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageBinExcludeMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(StorageBinExclude record);

    int insertSelective(StorageBinExclude record);

    StorageBinExclude selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StorageBinExclude record);

    int updateByPrimaryKey(StorageBinExclude record);

    List<StorageBinExcludeVO> selectList(StorageBinExcludeQue storageBinExcludeQue);

    List<StorageBinExcludeVO> selectListByIds(@Param("ids") Integer[] ids);
}