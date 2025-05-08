package com.example.dampouring.model.vo;

import lombok.Data;

@Data
public class PouringProgressVO {
    Integer dsName;
    Integer endCount;
    Double bl;

    public void setBlbyendCount()
    {
        switch (dsName) {
            case 0:
                bl = endCount /1326.;
                break;
            case 1:
                bl = endCount /476.;
                break;
            case 2:
                bl = endCount /504.;
                break;
            case 3:
                bl = endCount /347.;
                break;
            default:
                bl = 0.;
        }
    }
}
