package com.example.dampouring.service;

import com.example.dampouring.model.request.AddPouringBaseReq;
import com.example.dampouring.model.request.UpdatePouringBaseReq;
import com.example.dampouring.model.vo.PouringBaseVO;
import com.example.dampouring.query.PouringBaseQue;
import com.example.dampouring.query.TempUpQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PouringBaseService {
    void add(AddPouringBaseReq addPouringBaseReq, String userName);

    void update(UpdatePouringBaseReq updatePouringBaseReq);

    void delete(Integer[] ids);

    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<PouringBaseVO> listByIds(Integer[] ids);

    PageInfo orUserSelect(PouringBaseQue pouringBaseQue);

    List<PouringBaseVO> exportList();

    PageInfo tempUp(TempUpQue tempUpQue);

    PageInfo selectByFg(PouringBaseQue pouringBaseQue);
    Integer getQS(Integer sbId);
}
