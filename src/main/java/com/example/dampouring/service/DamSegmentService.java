package com.example.dampouring.service;

import com.example.dampouring.model.pojo.DamSegment;
import com.example.dampouring.model.request.AddDamSegmentReq;
import com.example.dampouring.model.request.UpdateDamSegmentReq;
import com.example.dampouring.model.vo.DamSegmentVO;
import com.example.dampouring.model.vo.PouringMonitorVO;
import com.example.dampouring.query.DamSegmentQue;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DamSegmentService {
    void add(AddDamSegmentReq addDamSegmentReq, String userName);

    void update(UpdateDamSegmentReq updateDamSegmentReq);

    void delete(Integer[] ids);


    PageInfo userVoList(Integer pageNum, Integer pageSize);

    List<DamSegment> listByIds(Integer[] ids);

    List<DamSegment> listByBsNo(Integer value);

    PageInfo userVoListQue(DamSegmentQue damSegmentQue);

    List<DamSegmentVO> exportList();

    List<PouringMonitorVO> pouringMonitor();
}
