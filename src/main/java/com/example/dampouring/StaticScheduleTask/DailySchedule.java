package com.example.dampouring.StaticScheduleTask;

import com.example.dampouring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DailySchedule {
    @Autowired
    ScheduledConfig scheduledUtils;
    @Autowired
    DailyInnerTempService dailyInnerTempService;
    @Autowired
    DailyPourTempService dailyPourTempService;
    @Autowired
    DailyOneWaterService dailyOneWaterService;
    @Autowired
    DailyMidWaterService dailyMidWaterService;
    @Autowired
    DailyTwoWaterService dailyTwoWaterService;



    void dailyInnerTemp()
    {

    }
    void dailyPourTemp()
    {

    }
    void dailyOneWater()
    {

    }
    void dailyMidWater()
    {

    }
    void dailyTwoWater()
    {

    }
}
