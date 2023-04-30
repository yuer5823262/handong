package com.example.dampouring.model.dao;

import com.example.dampouring.model.pojo.PouringBase;
import com.example.dampouring.model.request.AddPouringBaseReq;
import com.example.dampouring.model.vo.PouringBaseVO;
import com.example.dampouring.model.vo.TempUpVo;
import com.example.dampouring.query.PouringBaseQue;
import com.example.dampouring.query.TempUpQue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PouringBaseMapper {
    int deleteByPrimaryKey(@Param("ids") Integer[] ids);

    int insert(PouringBase record);

    int insertSelective(PouringBase record);

    PouringBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PouringBase record);

    int updateByPrimaryKey(PouringBase record);

    List<PouringBaseVO> selectList();

    List<PouringBaseVO> selectListByIds(@Param("ids") Integer[] ids);

    List<PouringBaseVO> selectListQue(PouringBaseQue pouringBaseQue);

    List<TempUpVo> tempUp(TempUpQue tempUpQue);

    List<PouringBaseVO> selectByFg(PouringBaseQue pouringBaseQue);

    PouringBase selectBySbId(Integer sbId);

    PouringBaseVO selectBySbNo(String sbNo);

    List<PouringBaseVO> selectBy30Min();

    List<PouringBase> selectByUpSb(Double elevationStart, Integer dsStart, Integer dsEnd);

    PouringBase selectByUpSbBycheckOpenTime(Integer sbId);
}