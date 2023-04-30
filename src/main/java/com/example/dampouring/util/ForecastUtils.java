package com.example.dampouring.util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class ForecastUtils {
    public static void test1(){
        String result= HtmlUtils.getResult("http://www.weather.com.cn/weather/101270101.shtml");
        System.out.println(result);
        Document document= Jsoup.parse(result);
        Elements elements;

        // 获取日期和星期
        elements=document.select("h1");
        List<String> dateList=new ArrayList<>();
        List<String> dayList=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String text=elements.get(i).text();
            int length=text.length();
            dateList.add(text.substring(0,length-4));
            dayList.add(text.substring(length-3,length-1));
        }
        System.out.println(dateList);
        System.out.println(dayList);

        // 获取天气
        elements=document.select("p[class=wea]");
        List<String> weatherList=new ArrayList<>();
        for (Element item : elements) {
            weatherList.add(item.text());
        }
        System.out.println(weatherList);

        // 获取温度，最高温和最低温
        elements=document.select("p[class=tem]");
        int i=0;
        List<String> highTempList=new ArrayList<>();
        List<String> lowTempList=new ArrayList<>();
        for (Element item : elements) {
            highTempList.add(item.select("span").text()+"℃");
            lowTempList.add(item.select("i").text());
        }
        System.out.println(highTempList);
        System.out.println(lowTempList);

        // 封装结果，每天一行
        List<Map<String,String>> list=new ArrayList<>();
        for (int j = 0; j < 7; j++) {
            Map<String,String> map=new LinkedHashMap<>();
            map.put("date",dateList.get(j));
            map.put("day",dayList.get(j));
            map.put("weather",weatherList.get(j));
            map.put("highTemp",highTempList.get(j));
            map.put("lowTemp",lowTempList.get(j));
            list.add(map);
        }

        list.forEach(System.out::println);
    }

}
