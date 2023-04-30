package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.SwSiloDataMapper;
import com.example.dampouring.model.pojo.SwSiloData;
import com.example.dampouring.model.request.AddSwSiloDataReq;
import com.example.dampouring.model.request.UpdateSwSiloDataReq;
import com.example.dampouring.model.vo.SwSiloDataVO;
import com.example.dampouring.model.vo.SwZyDataVO;
import com.example.dampouring.service.SwSiloDataService;
import com.example.dampouring.util.DatUtils;
import com.example.dampouring.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class SwSiloDataServiceImpl implements SwSiloDataService {
    @Autowired
    com.example.dampouring.model.dao.SwSiloDataMapper SwSiloDataMapper;
    @Override
    public void add(AddSwSiloDataReq addSwSiloDataReq, String userName) {
        SwSiloData SwSiloData = new SwSiloData();
        BeanUtils.copyProperties(addSwSiloDataReq,SwSiloData);
        SwSiloData.setOperator(userName);
        SwSiloData.setCreateTime(TimeUtils.getNowTime());
        int count = SwSiloDataMapper.insertSelective(SwSiloData);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateSwSiloDataReq updateSwSiloDataReq){
        SwSiloData SwSiloData =
                SwSiloDataMapper.selectByPrimaryKey(updateSwSiloDataReq.getId());
        if (SwSiloData == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateSwSiloDataReq,SwSiloData);

        int count = SwSiloDataMapper.updateByPrimaryKeySelective(SwSiloData);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = SwSiloDataMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SwSiloDataVO> SwSiloDataList = SwSiloDataMapper.selectList();
        PageInfo pageInfo = new PageInfo(SwSiloDataList);
        return pageInfo;
    }

    @Override
    public List<SwSiloData> listByIds(Integer[] ids) {
        List<SwSiloData> categoryList = SwSiloDataMapper.selectListByIds(ids);
        return categoryList;
    }
    @Override
    public void writeFile() throws Exception {
        String fileName = Constant.SMART_TS_DATA_PATH+"silo_data.dat";
        List<SwSiloDataVO> categoryList = SwSiloDataMapper.getData();
        List<String> result = new ArrayList<>();
        result.add(categoryList.size()+"");
        Integer count =1;
        for(SwSiloDataVO swSiloDataVO:categoryList)
        {
            swSiloDataVO.setId(count);
            swSiloDataVO.setSgId(count);
            count+=1;
        }
        for(SwSiloDataVO swSiloDataVO:categoryList)
        {
            String a = "";
            Class cls = swSiloDataVO.getClass();
            Field[] fields = cls.getDeclaredFields();
            for(int i=0; i<fields.length-2; i++){
                Field f = fields[i];
                f.setAccessible(true);
                if(f.get(swSiloDataVO)==null||f.get(swSiloDataVO).equals(""))
                {
                    a=a+"DataMissing,";
                }
                else a = a+f.get(swSiloDataVO)+",";
            }
            a = a.substring(0,a.length() -1);
            result.add(a);
        }
        DatUtils.writeFile(result,fileName);
    }

    @Override
    public void writeZyFile() throws Exception {
        List<SwZyDataVO> categoryList = SwSiloDataMapper.getDataZY();
        if(categoryList==null) return;
        List<String> result = new ArrayList<>();
        String sbNo= categoryList.get(0).getSbNo();
        Integer count = 1;
        result.add(count+"");
        String fileName = Constant.SMART_TS_DATA_PATH+sbNo+".dat";
        for(SwZyDataVO swZyDataVO:categoryList)
        {
            if(!swZyDataVO.getSbNo().equals(sbNo))
            {
                result.set(0,(count-1)+"");
                DatUtils.writeFile(result,fileName);
                result.clear();
                count=1;
                result.add(count+"");
                sbNo= swZyDataVO.getSbNo();
                fileName=Constant.SMART_TS_DATA_PATH+sbNo+".dat";
            }
            String a = count+",";
            Class cls = swZyDataVO.getClass();
            Field[] fields = cls.getDeclaredFields();
            DecimalFormat df = new DecimalFormat("#.00");
            for(int i=1; i<fields.length; i++){
                Field f = fields[i];
                f.setAccessible(true);
                if(f.get(swZyDataVO)==null||f.get(swZyDataVO).equals(""))
                {
                    a=a+"DataMissing,";
                }
                else
                {
                    if(i>1)
                        a = a+df.format(f.get(swZyDataVO))+",";
                    else a = a+f.get(swZyDataVO)+",";
                }
            }
            a = a.substring(0,a.length() -1);
            result.add(a);
            count++;
        }
        result.set(0,(count-1)+"");
        DatUtils.writeFile(result,fileName);
    }
}
