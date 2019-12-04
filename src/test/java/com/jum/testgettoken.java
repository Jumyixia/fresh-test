package com.jum;

import com.jum.http.HttpRequestEx;
import com.jum.http.Response;
import com.jum.testbase.TestBaseNoResource;
import com.jum.utils.JsonHelper;
import com.jum.utils.result.ResultMap;
import org.testng.annotations.Test;

import java.util.*;

/**
 * 测试商家后台的登录以及获取账号下门店列表
 * 1. 根据手机号密码请求登录接口，获取token、memberid；
 * 2. 根据token、memberid，请求获取门店列表接口；
 */
public class testgettoken extends TestBaseNoResource {

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
            form.put("passWord", "c6e95b51881b1f93a40c65ab620c4447");
            form.put("s_os", "pc_merchant_back");
            form.put("_api", "login");
            form.put("mobileNumber", "17770000011");

            Map<String, String> form_header = new HashMap<String, String>();
            //params
            form_header.put("X-Token","");


            String body = "{\"mobileNumber\":\"17770000011\",\"passWord\":\"c6e95b51881b1f93a40c65ab620c4447\"}";
            HttpRequestEx httpRequest = new HttpRequestEx("merchant-api.2dfire-daily.com");

            response = httpRequest.post(path, form, form_header, body);


            //验证返回结果
            ResultMap<String> result = JsonHelper.stringToObject(response.getResponseStr(), ResultMap.class);
            Map<String,String> data1 = (Map<String,String>)result.get("data");
            String token = data1.get("token");
            String memberId = data1.get("memberId");


            form_header.put("X-Token", token);

            path = new ArrayList<>();
            path.add("merchant");
            path.add("shop");
            path.add("v1");
            path.add("get_entity_list");

            form.remove("passWord");
            form.remove("mobileNumber");
            form.put("memberId", memberId);
            form.put("_api","getShopList");
            form.put("_stamp", Long.toString(new Date().getTime()));


            response = httpRequest.get(path, form, form_header);

        } catch (Exception e) {
            logger.error( e);
        }
    }
}
