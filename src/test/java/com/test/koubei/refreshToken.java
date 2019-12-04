package com.test.koubei;

import com.dfire.pay.center.domain.model.AlipayPayment;
import com.dfire.pay.center.service.settings.IAlipayPaymentService;
import com.jum.testbase.TestBaseNoResource;
import com.twodfire.share.result.Result;
import org.apache.commons.lang.StringUtils;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.Date;

public class refreshToken extends TestBaseNoResource{

    @Resource
    public IAlipayPaymentService alipayPaymentService;

    String pid = "2088502861838344";
    String token = "201806BBca995328ebd74164ajyrr828af0aX39";

    @Test
    public void test() {
        AlipayPayment alipayPayment = new AlipayPayment();
        if (StringUtils.isNotBlank(pid) && StringUtils.isNotBlank(token)){

            alipayPayment.setAlipayPid(pid);
            alipayPayment.setAlipayTokenExpiresIn(new Date(1565782996000l));
            alipayPayment.setAlipayRefreshExpiresIn(new Date(1565782996000l));
            alipayPayment.setAlipayAppAuthToken(token);
            alipayPayment.setAlipayAppRefreshToken(token);
            Result updateRelust = alipayPaymentService.updateAlipayPaymentAuthToken(alipayPayment, "openapi");
            System.out.println(updateRelust.getMessage());
        }else {
            System.out.println("error");
        }
    }
}
