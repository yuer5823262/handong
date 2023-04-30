package com.example.dampouring.common;

import com.example.dampouring.service.SystemConstantService;
import com.example.dampouring.util.ConnectionUtil;
import com.example.dampouring.util.DllUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
@Component
public class Constant implements ApplicationRunner {
    @Autowired
    SystemConstantService SystemConstantService;
    public static short p =3;

    public static short pSta=1;
    public static Integer timeout =1;
    public static final String APP_ID="znwk";
    public static final String OAUTH2_URL = "https://10.169.65.231";
//    public static final String OAUTH2_URL = "http://hj5iai.natappfree.cc";
    public static final String OAUTH2_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCH+feoIEAGR1daRTY1zX8c3RTEYe9MaWzyJFi8ibXjY3wyi8scpYaomVAOR/Zn3FrjrFhJTn2G7q05rsbXOaR3JWsOlS6ArGvDg/pgPMHgQa4vnFPnkvqoBTQWAbMG3ZDB5PFXGepxI59boXxmDP7zoaFrgSSvkqdfnrygPxdr0QIDAQAB";
//    public static final String OAUTH2_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPcYlkYMPk0VKwoluuB9ylvpyr47C1S5dCRyLBbcH083NthYGvKDTONYN+p3vSxNc3qTYSGrK2rlWs+HBvAmLBr7dssTlWL+uRVSKfvwF5cgS2AEvlhP7XZnmYRbk/w5mzXWMoOCl17PdF+Rl/iPYDFqMlpeAthQuGMue13dC3EwIDAQAB";
    public static final String SALT= "sad2asdAS%D&2#284.";
    public static final String DAM_POUR_USer= "DAM_POUR_USer";
    public static final String IMAGE_STATIC_BG= "\\bgImage\\";
    public static final String SMART_BW_DATA_PATH = System.getProperty("user.dir")+"\\bwData\\";
    public static final String SMART_TS_DATA_PATH = System.getProperty("user.dir")+"\\tsData\\";
    public static final String TEMP_MAP_PATH = System.getProperty("user.dir")+"\\tempMap\\";
    public static Logger logger= LoggerFactory.getLogger("constant");
    public static String cityNo="101271811";
    public static String city="白玉县";
    public static String mqIp="10.169.65.234";
    public static DllUtils DllUTILS = DllUtils.getDllUtils();
    public static Integer getDataSlot= 10;
    public static Integer systemState= 32;
    public void setVal()
    {
        System.out.println("开始初始化");
        SystemConstantService.setConsTantVal();
        System.out.println("初始化完毕");
    }
    public static void openPort()
    {
        if(Constant.systemState==64) return;
        Constant.DllUTILS.C_CommClose();
        Constant.pSta = Constant.DllUTILS.C_CommOpen(Constant.p);
        Constant.print("打开端口:"+Constant.p+" sta:"+Constant.pSta);
    }

    public static void print(String str)
    {
        logger.info(str);
        if(WebsocketServerEndpoint.websocketServerSet.size()>0){
            try{
                //这里省略获取到需要发送数据data的逻辑
                WebsocketServerEndpoint.websocketServerSet.forEach(t->t.sendMessage(str));
            }catch (Exception e){
                Constant.logger.error("错误:",e);
            }
        }
    }
    public static void printError(String str)
    {
        logger.error(str);
    }

    public static void closePort()
    {
        if(Constant.systemState==64) return;
        Constant.DllUTILS.C_CommClose();
        Constant.pSta = 3;
        Constant.print("关闭端口:"+Constant.p+" sta:"+Constant.pSta);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        setVal();
    }
}
