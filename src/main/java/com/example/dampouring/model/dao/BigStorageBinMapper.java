package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.BigStorageBin;
import com.example.dampouring.model.vo.DamSegmentVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BigStorageBinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BigStorageBin record);

    int insertSelective(BigStorageBin record);

    BigStorageBin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BigStorageBin record);

    int updateByPrimaryKey(BigStorageBin record);

    BigStorageBin selectByBigSbNo(String bigSbNo);

    List<BigStorageBin> selectVoList();

    List<BigStorageBin> selectByids(@Param("ids") Integer[] ids);
}