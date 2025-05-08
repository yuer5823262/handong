package com.example.dampouring.model.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@Data
public class CoolingRateVo {

    @Excel(name = "时间",width = 20)
    String time;
    @Excel(name = "降温速率",width = 20)
    Double temp;


}
