package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.FaceDiapauseAlert;
import com.example.dampouring.model.vo.AlertBaseVO;
import com.example.dampouring.model.vo.FaceDiapauseAlertNormVO;
import com.example.dampouring.model.vo.FaceDiapauseAlertVO;
import com.example.dampouring.query.AlertQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaceDiapauseAlertMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FaceDiapauseAlert record);

    int insertSelective(FaceDiapauseAlert record);

    FaceDiapauseAlert selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FaceDiapauseAlert record);

    int updateByPrimaryKey(FaceDiapauseAlert record);

    List<FaceDiapauseAlertVO> selectList(AlertQue alertQue);

    int processinge(@Param("ids") Integer[] ids);


    FaceDiapauseAlertNormVO normInfo(Integer pouringBaseId);

    List<AlertBaseVO> list(Integer type);
}