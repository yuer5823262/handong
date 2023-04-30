package com.example.dampouring.model.dao.db2;
import com.example.dampouring.model.pojo.MixingTempBc;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MixingTempYcMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MixingTempBc record);

    int insertSelective(MixingTempBc record);

    MixingTempBc selectByPrimaryKey(Integer id);

    List<MixingTempBc> list();

    int updateByPrimaryKeySelective(MixingTempBc record);

    int updateByPrimaryKey(MixingTempBc record);
}
