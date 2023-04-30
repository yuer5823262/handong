package com.example.dampouring.advice;


import com.alibaba.fastjson.JSONObject;
import com.example.dampouring.annotation.SecurityParameter;
import com.example.dampouring.util.AesUtil;
import com.example.dampouring.util.DESUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.nio.charset.StandardCharsets;

/**
 * 返回数据加密
 */
@ControllerAdvice(basePackages = "com.example.dampouring")
public class EncodeResponseBodyAdvice implements ResponseBodyAdvice {

    private final static Logger logger = LoggerFactory.getLogger(EncodeResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        boolean encode = false;
        //指定加注解的方法加密
        if (methodParameter.getMethod().isAnnotationPresent(SecurityParameter.class)) {
            //获取注解配置的包含和去除字段
            SecurityParameter serializedField = methodParameter.getMethodAnnotation(SecurityParameter.class);
            //出参是否需要加密
            encode = serializedField.outEncode();
        }
        if (encode) {
            logger.info("对方法method :【" + methodParameter.getMethod().getName() + "】返回数据进行加密");
            if (methodParameter.getMethod().getName().contains("Configuration")) {
                return body;
            }
            if (methodParameter.getMethod().getName().contains("swagger")) {
                return body;
            }
//            if (methodParameter.getMethod().getName().contains("get")) {
//                return body;
//            }
            ObjectMapper objectMapper = new ObjectMapper();
            try {
//                logger.info("返回结果加密1=" + body);
                String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
//                logger.info("返回结果加密2=" + result);
//                logger.info("返回结果加密=" + DESUtils.encrypt(result));
                JSONObject jsonObject = JSONObject.parseObject(result);
                String data = jsonObject.getString("data");
                String newData = AesUtil.encrypt(data);
                jsonObject.put("data",newData);
                return jsonObject;
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("对方法method :【" + methodParameter.getMethod().getName() + "】返回数据进行解密出现异常：" + e.getMessage());
            }
        }
        return body;
    }
}
