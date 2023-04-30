package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.SmartWarehouseWarning;
import com.example.dampouring.model.vo.SmartWarehouseWarningVO;
import com.example.dampouring.query.SmartWarehouseWarningQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartWarehouseWarningMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmartWarehouseWarning record);

    int insertSelective(SmartWarehouseWarning record);

    SmartWarehouseWarning selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmartWarehouseWarning record);

    int updateByPrimaryKey(SmartWarehouseWarning record);

    List<SmartWarehouseWarningVO> selectList(SmartWarehouseWarningQue smartWarehouseWarningQue);
}