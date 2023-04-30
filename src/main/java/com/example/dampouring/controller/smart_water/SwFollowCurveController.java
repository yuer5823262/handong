package com.example.dampouring.controller.smart_water;

import com.example.dampouring.common.ApiRestResponse;
import com.example.dampouring.query.SwFollowCurveQue;
import com.example.dampouring.service.SwFollowCurveService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "智能通水监测FollowCurve")
@RequestMapping("api/SwFollowCurveController")
@Controller
public class SwFollowCurveController {
    @Autowired
    SwFollowCurveService SwFollowCurveService;
    @PostMapping("/select")
    @ResponseBody
    public ApiRestResponse listSelectSwFollowCurve(@RequestBody SwFollowCurveQue SwFollowCurveQue) {
        PageInfo pageInfo = SwFollowCurveService.orUserSelect(SwFollowCurveQue);
        return ApiRestResponse.success(pageInfo);
    }
}
