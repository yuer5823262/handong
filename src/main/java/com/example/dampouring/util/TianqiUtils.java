package com.example.dampouring.util;

import com.alibaba.fastjson.JSONObject;
import com.example.dampouring.common.Constant;
import com.example.dampouring.model.vo.TianqiVO;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.commons.codec.binary.Base64;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.jdbc.Null;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.List;

import javax.crypto.Cipher;

public class TianqiUtils {
//    static String ip = "http://10.169.65.231:18090";
    static String ip = "https://10.169.65.231";
    static String token=null;
    static String password = "YBT@1qaz!QAZ";
    static String userName = "zgskyjk";
    public static void getToken(){
        try {
            String ent="";
//            ent= HtmlUtils.getResult(ip+"/security/login-public-key");
//            Constant.logger.info(ent);
//            JSONObject jsonObject = JSONObject.parseObject(ent);
//            String pubKey = jsonObject.getString("data");
//            Constant.logger.info("pubkey:"+pubKey);
            String pwd = password;
//            Constant.logger.info("pwd:"+pwd);
            ent= HtmlUtils.getResult(ip+"/security/login?username="+userName+"&password="+pwd);
            Constant.logger.info("end:"+ent);
            JSONObject jsonObject = JSONObject.parseObject(ent);
            JSONObject data = jsonObject.getJSONObject("data");
            String result = data.getString("token");
            Constant.logger.info("result:"+result);
            token= result;
        } catch (Exception e) {
            Constant.logger.error("获取天气token错误",e);
        }
    }
    public static List<TianqiVO> getTiqnqi() {
        getToken();
        if(token==null)
        {
            return null;
        }
        String ent="";
        List<TianqiVO> tianqiVOS = null;
        try {
            ent= HtmlUtils.getResult(ip+"/api/wisdomDam/weather/LRSeven/"+101271811);
            Constant.logger.info(ent);
            JSONObject jsonObject = JSONObject.parseObject(ent);
            JSONObject data = jsonObject.getJSONObject("data");
            String result = data.getString("weatherList");
            tianqiVOS = JSON.parseArray(result, TianqiVO.class);
//            Constant.city=tianqiVOS.get(0).getCityName();
        } catch (Exception e) {
            Constant.logger.error("获取天气预报失败",e);
        }
        return tianqiVOS;
    }

    /**
     * RSA加密
     *
     * @param data      待加密数据
     * @param publicKey 公钥
     */
    private static String encrypt(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int inputLen = data.getBytes().length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offset = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offset > 0) {
            if (inputLen - offset > 117) {
                cache = cipher.doFinal(data.getBytes(), offset, 117);
            } else {
                cache = cipher.doFinal(data.getBytes(), offset, inputLen - offset);
            }
            out.write(cache, 0, cache.length);
            i++;
            offset = i * 117;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        // 获取加密内容使用base64进行编码,并以UTF-8为标准转化成字符串
        // 加密后的字符串
        return new String(Base64.encodeBase64(encryptedData));
    }

    /**
     * 获取公钥
     *
     * @param publicKey base64加密的公钥字符串
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        byte[] decodedKey = Base64.decodeBase64(publicKey.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}
