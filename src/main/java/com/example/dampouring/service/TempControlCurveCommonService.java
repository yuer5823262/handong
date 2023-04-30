package com.example.dampouring.service;

import com.example.dampouring.model.pojo.TempControlCurveCommon;
import com.example.dampouring.model.request.AddTempControlCurveCommonReq;
import com.example.dampouring.model.request.UpdateTempControlCurveCommonReq;
import com.example.dampouring.model.vo.MaxTempNormVO;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TempControlCurveCommonService {
    void add(AddTempControlCurveCommonReq addTempControlCurveCommonReq, String userName);

    void update(UpdateTempControlCurveCommonReq updateTempControlCurveCommonReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<TempControlCurveCommon> listByIds(Integer[] ids);

    TempControlCurveCommon selectBySbId(Integer sbId);
}
