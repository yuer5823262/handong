package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.Maintain;
import com.example.dampouring.model.vo.MaintainVO;
import com.example.dampouring.query.MaintainQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MaintainMapper {

    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(Maintain record);

    int insertSelective(Maintain record);

    Maintain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Maintain record);

    int updateByPrimaryKey(Maintain record);

    List<MaintainVO> selectList();

    List<MaintainVO> selectListByIds(@Param("ids") Integer[] ids);


    List<MaintainVO> selectListByQue(MaintainQue maintainQue);
}