package com.example.dampouring.annotation;


import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;


@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface SecurityParameter {

    /**
     * 入参是否解密，默认不解密
     */
    boolean inDecode() default false;

    /**
     * 出参是否加密，默认不加密
     */
    boolean outEncode() default false;
}
