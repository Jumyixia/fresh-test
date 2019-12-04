package com.jum;

import com.jum.testbase.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class test extends TestBase{
    Logger log = LoggerFactory.getLogger(test.class);

    @Test
    public void test(){
        log.debug("halo_debug");
        log.info("halo_info ");
        log.warn("halo_warn");
        log.error("halo_error");
    }
}
