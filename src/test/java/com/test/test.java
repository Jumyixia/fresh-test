package com.test;

import com.jum.testbase.TestBase;
import com.jum.utils.DBHelper;
import com.jum.utils.DataMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.List;


public class test extends TestBase {
    Logger log = LoggerFactory.getLogger(com.jum.test.class);

    @Test()
    public void test() {
        log.debug("halo_debug");
        log.info("halo_info ");
        log.warn("halo_warn");
        log.error("halo_error");
        System.out.println(1111);
        Reporter.log("测试完成");
    }
    @Test
    public void test2(){
        DBHelper.setdruidDataSource(shopDataSource);
        List<DataMap> dbmallshop = DBHelper.executeQuery("select cash_type from mall_shop where mall_entity_id in ('99935513','99935704')  AND is_valid = 1");

        for (int i = 0; i < dbmallshop.size(); i++) {

            logger.info(dbmallshop.get(i).get("cash_type"));
            logger.info(Integer.valueOf(dbmallshop.get(i).get("cash_type").toString()));
        }
    }

}