package com.example.dampouring.service;

import com.example.dampouring.model.request.AddWaterPipeReq;
import com.example.dampouring.model.request.UpdateWaterPipeReq;
import com.example.dampouring.model.vo.WaterPipeVO;
import com.example.dampouring.query.WaterPipeQue;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
import java.util.List;

public interface WaterPipeService {
    void add(AddWaterPipeReq addWaterPipeReq, String userName);

    void update(UpdateWaterPipeReq updateWaterPipeReq);

    void delete(Integer[] ids);


    PageInfo orUserList(WaterPipeQue waterPipeQue);

    List<WaterPipeVO> listByIds(Integer[] ids);

    List<WaterPipeVO> selectBySmallId(Integer smallId);

    void writeFile() throws IOException;

    List<WaterPipeVO> exportList();
}
