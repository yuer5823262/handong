package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.MaterialsTempInfo;
import com.example.dampouring.query.MaterialsTempInfoQue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialsTempInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterialsTempInfo record);

    int insertSelective(MaterialsTempInfo record);

    MaterialsTempInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterialsTempInfo record);

    int updateByPrimaryKey(MaterialsTempInfo record);

    List<MaterialsTempInfo> List();

    List<MaterialsTempInfo> selectList(MaterialsTempInfoQue materialsTempInfoQue);
}