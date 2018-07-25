package com.jum.testbase;

import com.alibaba.druid.pool.DruidDataSource;
import com.dfire.soa.boss.center.tax.service.ITaxService;
import com.jum.http.HttpRequestEx;
import com.jum.utils.CsvDataProvider;
import com.jum.utils.PropertiesUtil;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestBase extends AbstractTestNGSpringContextTests {

    public static String csvFile;
    public static String xtoken;
    public static String app_key;
    public static String SERVER_URL;

    public HttpRequestEx httpRequest = new HttpRequestEx();


    @Resource(name = "bossDataSource")
    public DruidDataSource bossDataSource;

    @Resource(name = "twodfireDataSource")
    public DruidDataSource twodfireDataSource;

    @Resource(name = "itemDataSource")
    public DruidDataSource itemDataSource;

    @Resource(name = "bpsDataSource")
    public DruidDataSource bpsDataSource;

    @Resource(name = "turtleDataSource")
    public DruidDataSource turtleDataSource;

    //税费服务
    @Resource
    protected ITaxService taxService;

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
}
