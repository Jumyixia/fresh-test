package com.jum.testbase;

import com.alibaba.druid.pool.DruidDataSource;
import com.jum.http.HttpRequestEx;
import com.jum.utils.CsvDataProvider;
import com.jum.utils.MD5Util;
import com.jum.utils.PropertiesUtil;
import com.jum.utils.StringUtil;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestBaseNoResource extends AbstractTestNGSpringContextTests {

    public static String csvFile;
    public static String xtoken;
    public static String app_key;
    public static String SERVER_URL;
    public static String SERVER_PRE_URL;
    public static String SERVER_RELEASE_URL;

    public HttpRequestEx httpRequest = new HttpRequestEx();


    @DataProvider(name = "CsvDataProvider")
    public Iterator<Object[]> data() throws Exception {
        return (Iterator<Object[]>) new CsvDataProvider(getCsvPath());
    }

    static {
        // 读取config.properties
        Map<String, String> propertiesMap = null;
        try {
            propertiesMap = PropertiesUtil.readProperties("config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        csvFile = propertiesMap.get("csvFile");
        xtoken = propertiesMap.get("token");
        app_key = propertiesMap.get("app_key");
        SERVER_URL = propertiesMap.get("SERVER_URL");
        SERVER_PRE_URL = propertiesMap.get("SERVER_PRE_URL");
        SERVER_RELEASE_URL = propertiesMap.get("SERVER_RELEASE_URL");
    }

    /**
     * 获取csv文件路径
     * @return
     */
    public String getCsvPath() {
        String folderName = this.getClass().getPackage().getName().replaceAll("com.test.", "");
        System.out.println(csvFile + folderName + "/" + this.getClass().getSimpleName() + ".csv");
        return csvFile + folderName + "/" + this.getClass().getSimpleName() + ".csv";
    }



    public String getSign(Map form) {
        return this.server("BoivJgAlmBUO05yoxD6RU/SZ/nhLvpXT40v2ceqKJ1s=", form);
    }

    /**
     * 服务端生成sign
     *
     * @param secrect appKey对应的secrect,不能发到服务端
     * @param params 所有参数的map  包含系统参数和业务参数, 复杂vo的value,为json 格式
     * @return
     */
    public static String server(String secrect,Map<String, String> params) {

        //signMap 中不包含sign
        String [] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        // step 2: 把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();

        for(String key : keys){
            if(key.equals("sign") ||key.equals("method") || key.equals("appKey")
                    ||key.equals("v") || key.equals("format") || key.equals("timestamp") || key.equals("tb_router_cache")){
                continue;
            }
            String value=params.get(key).toString();
            if(!StringUtil.isEmpty(key)&& !StringUtil.isEmpty(value)){
                query.append(key).append(value);
            }
        }
        return MD5Util.encode(query.toString() + secrect);
    }
}
