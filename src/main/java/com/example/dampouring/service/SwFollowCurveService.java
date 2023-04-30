package com.example.dampouring.service;

import com.example.dampouring.query.SwFollowCurveQue;
import com.github.pagehelper.PageInfo;

import java.io.IOException;

public interface SwFollowCurveService {
    PageInfo orUserSelect(SwFollowCurveQue swFollowCurveQue);

    void readFile(Integer state);
}
