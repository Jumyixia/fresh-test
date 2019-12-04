package com.jum;

import com.jum.testbase.TestBase;
import com.jum.utils.DBHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class testdb  extends TestBase {
    Logger log = LoggerFactory.getLogger(test.class);

    @Test
    public void test(){
        Map sql = new HashMap<>();

        sql.put("title","%17");
        DBHelper.setdruidDataSource(bossDataSource);
        DBHelper.delete_like("mg_system_message", sql);
    }

    @Test
    public void test2(){
        DBHelper.setdruidDataSource(bossDataSource);
        DBHelper.insert("src/test/resources/dbdata/inserttestData_message.csv", "mg_system_message",null);
    }
}
