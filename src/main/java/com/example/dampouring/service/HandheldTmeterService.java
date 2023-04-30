package com.example.dampouring.service;

import com.example.dampouring.query.HandheldTmeterQue;
import com.github.pagehelper.PageInfo;

public interface HandheldTmeterService {
    PageInfo orUserSelect(HandheldTmeterQue handheldTmeterQue);
}
