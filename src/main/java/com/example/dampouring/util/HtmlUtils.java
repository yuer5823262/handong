package com.example.dampouring.util;
import com.example.dampouring.common.Constant;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HtmlUtils {
    public static String getResult(String url) {
        try (CloseableHttpClient httpClient = (CloseableHttpClient) SkipHttpsUtil.wrapClient();
             CloseableHttpResponse response = httpClient.execute(new HttpGetConfig(url))) {
            String result = EntityUtils.toString(response.getEntity(),"utf-8"); //设置编码，防止乱码
            return result;
        } catch (IOException e) {
            Constant.logger.error("http访问错误:",e);
            return "";
        }
    }
}

class HttpGetConfig extends HttpGet {
    public HttpGetConfig(String url) {
        super(url);
        setDefaultConfig();
    }

    private void setDefaultConfig() {
        this.setConfig(RequestConfig.custom()
                .setConnectionRequestTimeout(1000 * 10)
                .setConnectTimeout(1000 * 10)
                .setSocketTimeout(1000 * 10)
                .build());
        this.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:92.0) Gecko/20100101 Firefox/92.0");
        this.setHeader("connection","close");
        if(TianqiUtils.token!=null)
            this.setHeader("Cookie","SZGC-SHIRO-TOKEN="+TianqiUtils.token);
    }
}


