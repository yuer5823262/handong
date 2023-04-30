package com.example.dampouring.service;

import com.example.dampouring.model.pojo.BigSegment;
import com.example.dampouring.model.request.AddBigSegmentReq;
import com.example.dampouring.model.request.UpdateBigSegmentReq;
import com.example.dampouring.query.BigSegmentQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BigSegmentService {
    void add(AddBigSegmentReq addBigSegmentReq, String userName);

    void update(UpdateBigSegmentReq updateBigSegmentReq);

    void delete(Integer[] ids);


    PageInfo orUserList(Integer pageNum, Integer pageSize);

    List<BigSegment> listByIds(Integer[] ids);

    List<BigSegment> listByContractor(String value);

    PageInfo orUserListQue(BigSegmentQue bigSegmentQue);

    List<BigSegment> exportList();
}
