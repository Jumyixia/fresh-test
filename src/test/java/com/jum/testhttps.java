package com.jum;

import com.jum.http.HttpRequestEx;
import com.jum.http.Response;
import com.jum.testbase.TestBaseNoResource;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.Test;

import java.util.*;

/**
 * 测试商家后台的登录以及获取账号下门店列表
 */
public class testhttps extends TestBaseNoResource {

    @Test
    public void test() {


        //调用Http服务
        Response response = null;
        try {
            List<String> path = new ArrayList<>();
            path.add("merchant");
            path.add("v1");
            path.add("login");

            Map<String, String> form = new HashMap<String, String>();
            //params
            form.put("_stamp", Long.toString(new Date().getTime()));
            form.put("app_key", "200017");
            form.put("base_param", "{\"deviceId\":\"a4a201d6f40c615d\",\"appKey\":\"200006\",\"sBR\":\"HTC D830u\",\"sOS\":\"android\"}");
            form.put("s_os", "pc_merchant_back");
            form.put("_api", "login");
            form.put("param_str", "{\"appKey\":\"200006\",\"countryCode\":\"+86\",\"deviceId\":\"a4a201d6f40c615d\",\"isEnterprise\":0,\"loginType\":1,\"mobile\":\"13300000003\",\"password\":\"c6e95b51881b1f93a40c65ab620c4447\",\"thirdType\":0}");

            String sign = getSign(form);

            form.put("sign" , sign);
            String url = SERVER_PRE_URL + "/compositeauth/v1/login？";
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("Content-Type", "application/json;charset=utf-8");

            HttpRequestEx ht = new HttpRequestEx();
            Response rs = ht.postHandle(url, form, 200000);
            System.out.println(rs.getResponseStr());



        } catch (Exception e) {
            logger.error( e);
        }
    }
}
