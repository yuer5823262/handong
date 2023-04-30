package com.example.dampouring.service.impl;

import com.example.dampouring.common.Constant;
import com.example.dampouring.exception.DamPourException;
import com.example.dampouring.exception.DampouringExceptionEnum;
import com.example.dampouring.model.dao.SwBataMapper;
import com.example.dampouring.model.pojo.SwBata;
import com.example.dampouring.model.request.AddSwBataReq;
import com.example.dampouring.model.request.UpdateSwBataReq;
import com.example.dampouring.service.SwBataService;
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
public class SwBataServiceImpl implements SwBataService {
    @Autowired
    SwBataMapper SwBataMapper;

    @Override
    public void add(AddSwBataReq addSwBataReq, String userName) {
        SwBata SwBata = new SwBata();
        BeanUtils.copyProperties(addSwBataReq,SwBata);
        SwBata.setOperator(userName);
        SwBata.setCreateTime(TimeUtils.getNowTime());
        int count = SwBataMapper.insertSelective(SwBata);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.ADD_FAILED);
        }


    }
    @Override
    public void update(UpdateSwBataReq updateSwBataReq){
        SwBata SwBata =
                SwBataMapper.selectByPrimaryKey(updateSwBataReq.getId());
        if (SwBata == null) {
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
        BeanUtils.copyProperties(updateSwBataReq,SwBata);

        int count = SwBataMapper.updateByPrimaryKeySelective(SwBata);
        if (count == 0){
            throw new DamPourException(DampouringExceptionEnum.UPDATE_FAILED);
        }
    }


    @Override
    public void delete(Integer[] ids) {
        int count = SwBataMapper.deleteByPrimaryKey(ids);
        if (count !=ids.length){
            throw new DamPourException(DampouringExceptionEnum.DELETE_FAILED);
        }
    }


    @Override
    public PageInfo orUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SwBata> SwBataList = SwBataMapper.selectList();
        PageInfo pageInfo = new PageInfo(SwBataList);
        return pageInfo;
    }

    @Override
    public List<SwBata> listByIds(Integer[] ids) {
        List<SwBata> categoryList = SwBataMapper.selectListByIds(ids);

        return categoryList;

    }


    @Override
    public void writeFile() throws IOException {
        String fileName = Constant.SMART_TS_DATA_PATH+"BATA.DAT";
        List<SwBata> SwBataList = SwBataMapper.selectList();
        List<String> stringList = new ArrayList<>();
        stringList.add(SwBataList.size()+"  4");
        for(int i=0;i<SwBataList.size();i++)
        {
            stringList.add(i+" "+SwBataList.get(i).getTime()+" "+SwBataList.get(i).getSrGc());
        }
        DatUtils.writeFile(stringList,fileName);
    }

}
