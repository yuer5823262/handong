package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.CloseGroutAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.CloseGroutAlertVO;
import com.example.dampouring.query.AlertQue;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CloseGroutAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CloseGroutAlert record);

    int insertSelective(CloseGroutAlert record);

    CloseGroutAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CloseGroutAlert record);

    int updateByPrimaryKey(CloseGroutAlert record);

    List<CloseGroutAlertVO> selectList(AlertQue alertQue);

    int processinge(Integer[] ids);

    List<AlertBaseVO> list(Integer type);
}