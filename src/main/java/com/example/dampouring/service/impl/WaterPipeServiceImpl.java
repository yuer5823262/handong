package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.WaterPipeMapper;
import com.example.dampouring.model.pojo.WaterPipe;
import com.example.dampouring.model.request.AddWaterPipeReq;
import com.example.dampouring.model.request.UpdateWaterPipeReq;
import com.example.dampouring.model.vo.WaterPipeVO;
import com.example.dampouring.query.WaterPipeQue;
import com.example.dampouring.service.WaterPipeService;
import com.example.dampouring.util.DatUtils;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WaterPipeServiceImpl implements WaterPipeService {
    @Autowired
    WaterPipeMapper waterPipeMapper;
//    void checkData(Integer sbId)
//    {
//        WaterPipeVO waterPipeList= waterPipeMapper.selectBySmallId(sbId);
//        if(waterPipeList!=null)
//        {
//            throw new DamPourException(30000,"每个仓只有一根水管");
//        }
//    }
    @Override
    public void add(AddWaterPipeReq addWaterPipeReq, String userName) {
//        checkData(addWaterPipeReq.getSbId());
        WaterPipe waterPipe = new WaterPipe();
        BeanUtils.copyProperties(addWaterPipeReq,waterPipe);
        waterPipe.setOperator(userName);
        waterPipe.setCreateTime(TimeUtils.getNowTime());
        int count = waterPipeMapper.insertSelective(waterPipe);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }
    }
    @Override
    public void update(UpdateWaterPipeReq updateWaterPipeReq){
//        checkData(updateWaterPipeReq.getCuId());
        WaterPipe waterPipe =
                waterPipeMapper.selectByPrimaryKey(updateWaterPipeReq.getId());
        if (waterPipe == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateWaterPipeReq,waterPipe);

        int count = waterPipeMapper.updateByPrimaryKeySelective(waterPipe);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = waterPipeMapper.deleteByPrimaryKey(ids);
        if (count != ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(WaterPipeQue waterPipeQue) {
        PageHelper.startPage(waterPipeQue.getPageNum(), waterPipeQue.getPageSize());
        List<WaterPipeVO> waterPipeList = waterPipeMapper.selectList(waterPipeQue);
        PageInfo pageInfo = new PageInfo(waterPipeList);
        return pageInfo;
    }

    @Override
    public List<WaterPipeVO> listByIds(Integer[] ids) {
        List<WaterPipeVO> categoryList = waterPipeMapper.selectListByIds(ids);

        return categoryList;

    }

    @Override
    public List<WaterPipeVO> selectBySmallId(Integer smallId) {
        List<WaterPipeVO> waterPipe = waterPipeMapper.selectBySmallId(smallId);
        return waterPipe;
    }



    @Override
    public void writeFile() throws IOException {
        String fileName = Constant.SMART_TS_DATA_PATH+"pipe_info.dat";
        List<WaterPipeVO> waterPipeList = waterPipeMapper.getTsData();
        List<String> stringList = new ArrayList<>();
        stringList.add(waterPipeList.size()+"");
        for(int i=0;i<waterPipeList.size();i++)
        {
            String str = (i+1)+","+waterPipeList.get(i).getHorizontalSpacing()+","+
                    waterPipeList.get(i).getVerticalSpacing()+","+waterPipeList.get(i).getPipeLen()+","+
                    waterPipeList.get(i).getMaxFlow()+","+waterPipeList.get(i).getWaterDensity()+ ","+
                    waterPipeList.get(i).getWaterSpecificHeat()+","+waterPipeList.get(i).getPipeSpecificHeat()+","+
                    waterPipeList.get(i).getOuterDiameter()+","+waterPipeList.get(i).getInnerDiameter()+","+
                    waterPipeList.get(i).getWpType();
            stringList.add(str);
        }
        DatUtils.writeFile(stringList,fileName);
    }

    @Override
    public List<WaterPipeVO> exportList() {
        List<WaterPipeVO> waterPipeList = waterPipeMapper.selectList(new WaterPipeQue());

        return waterPipeList;
    }
}
