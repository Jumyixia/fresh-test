package com.test.video;

import com.jum.constants.Constants;
import com.jum.http.Response;
import com.jum.testbase.TestBase;
import com.jum.utils.JsonHelper;
import com.jum.utils.StringHelper;
import com.jum.utils.result.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * （连锁）店家宣传视频店家商品视频
 * 场景：
 * Created by rouyuan on 2017/10/10.
 */
public class ListShopFieldTest extends TestBase {
    public static Logger logger = LoggerFactory.getLogger("biz");

    @Test(dataProvider = "CsvDataProvider", enabled = true)
    public void testListShopField_rouyuan(Map<String,String> data) throws Exception{
        //变量申明
        String caseid;
        String entity_id;
        String biz_type;
        String filter;
        int exp_code;
        String url;

        //读case
        caseid = StringHelper.convert2String(data.get("caseid"));
        entity_id = StringHelper.convert2String(data.get("entity_id"));
        biz_type = StringHelper.convert2String(data.get("biz_type"));
        filter = StringHelper.convert2String(data.get("filter"));
        exp_code = StringHelper.convert2int(data.get("exp_code"));


        //调用Http服务
        Response response = null;
        try{
            Map<String,String> form = new HashMap<String, String>();
            //params
            form.put("token", xtoken);
            form.put("app_key", "200006");
            form.put("entityId", Constants.BRAND_ENTITY_ID_RY);
            form.put("userId", Constants.BRAND_USERID_RY);
            form.put("biz_type", biz_type);
            form.put("filter", filter);

            url = SERVER_URL + "/video/v1/list_shop_field?";
            response = httpRequest.postHandle(url, form, 200000);
            System.out.println(caseid + " getResponseStr():" + response.getResponseStr());


            //验证返回结果
            ResultMap<String> result = JsonHelper.stringToObject(response.getResponseStr(), ResultMap.class);
            Assert.assertEquals(result.get("code"), exp_code, "返回code和预期不一致");


        }catch(Exception e){
            logger.error("ListShopFieldTest异常",e);
        }
    }
}