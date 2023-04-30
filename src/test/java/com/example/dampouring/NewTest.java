package com.example.dampouring;

import com.example.dampouring.common.Constant;
import com.example.dampouring.model.pojo.UserTable;
import com.example.dampouring.model.vo.UserVO;
import com.example.dampouring.util.*;
import org.springframework.beans.BeanUtils;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class NewTest {
    public static void main(String[] args){
        System.out.println(TimeUtils.LongTOTime(1680178121L));
        System.out.println(TimeUtils.LongTOTime(1680175930000L));
    }

}