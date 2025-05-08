package com.example.dampouring.config;
import com.example.dampouring.filter.LoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class LoginFliterConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginFilter())
                //拦截的路径
                .addPathPatterns("/api/**")
                //排除登录接口
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/login/oauth")
                .excludePathPatterns("/api/SystemConstant/getSystemName")
                .excludePathPatterns("/api/SystemConstant/getSystemBgUrl")
                .excludePathPatterns("/api/CombinedCurves/select")
                .excludePathPatterns("/api/InnerTempSensorInfo/select")
                .excludePathPatterns("/api/tempMeasurementsAssess/select")
                .excludePathPatterns("/api/TopTempAssess/select")
                .excludePathPatterns("/api/WaterPipeFlowInfo/list")
                .excludePathPatterns("/api/smallStorageBin/list")
                .excludePathPatterns("/api/InnerTempSensorInfo/addByRemoteDev");
    }
}
