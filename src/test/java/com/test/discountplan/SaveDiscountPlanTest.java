package com.test.discountplan;

import com.alibaba.fastjson.JSONObject;

import com.jum.constants.Constants;
import com.jum.http.Response;
import com.jum.testbase.TestBase;
import com.jum.utils.JsonHelper;
import com.jum.utils.StringHelper;
import com.twodfire.share.result.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 打折方案-保存
 * 场景：添加打折方案，保存
 * 相关库：
 * Created by RouYuan on 2017/11/1.
 */
public class SaveDiscountPlanTest extends TestBase {

    public static Logger logger = LoggerFactory.getLogger("biz");

    @Test(dataProvider = "CsvDataProvider",groups={"SaveDiscountPlan"})
    public void test_rouyuan(Map<String,String> data) throws Exception{
    	//变量声明
        String user_ids_str;
        String discount_plan_str;
        String kind_ids_str;
        String menu_ids_str;
        String is_menu_discount;
        String is_all_kind;
        int exp_code;
        String url;

        //读case
        user_ids_str = StringHelper.convert2String(data.get("user_ids_str"));
        discount_plan_str = StringHelper.convert2String(data.get("discount_plan_str"));
        kind_ids_str = StringHelper.convert2String(data.get("kind_ids_str"));
        menu_ids_str = StringHelper.convert2String(data.get("menu_ids_str"));
        is_menu_discount = StringHelper.convert2String(data.get("is_menu_discount"));
        is_all_kind = StringHelper.convert2String(data.get("is_all_kind"));
        exp_code = StringHelper.convert2int(data.get("exp_code"));
        
        //调用Http服务
        Response response = null;
        try{
            Map<String,String> form = new HashMap<String, String>();
          //params
            form.put("token", xtoken);
            form.put("app_key", app_key);
            form.put("entityId", "00201115");
            form.put("user_ids_str", user_ids_str);
            form.put("discount_plan_str",discount_plan_str);
            form.put("kind_ids_str", kind_ids_str);
            form.put("menu_ids_str", menu_ids_str);
            form.put("is_all_kind", is_all_kind);
            form.put("is_menu_discount", is_menu_discount);
            form.put("plate_entity_id", "00201234");
            form.put("entityType","2");

            String sign = getSign(form);
            form.put("sign", sign);
            url = SERVER_PRE_URL + "/discount_plan/v1/save_discount_plan?";
            response = httpRequest.postHandle(url,form,200000);
            System.out.println("getResponseStr:" + response.getResponseStr());

            //验证返回结果：仅校验是否保存成功，保存内容是否正确后续在list接口中进行校验
            ResultMap<String> result = JsonHelper.stringToObject(response.getResponseStr(), ResultMap.class);
            Assert.assertEquals(exp_code,result.get("code"));
            
        }catch (Exception e){
            logger.error("SaveDiscountPlanTest异常");
        }
    }

    @BeforeClass
    public void beforeclass(){
        //调用Http服务
        Response response = null;
        try{
            Map<String,String> form = new HashMap<String, String>();
            //params
            form.put("token", xtoken);
            form.put("app_key", app_key);
            form.put("entityType", "2");
            form.put("entityId", "00201115");
            form.put("brandEntityId", "10015105");
            form.put("plate_entity_id", "00201234");

            String sign = getSign(form);
            form.put("sign", sign);
            String url = SERVER_PRE_URL + "/discount_plan/v2/list_discount_plan?";
            response = httpRequest.postHandle(url, form, 200000);
            System.out.println("getResponseStr():" + response.getResponseStr());

            JSONObject result = JSONObject.parseObject(response.getResponseStr());
            Assert.assertEquals(result.get("code").toString(), "1");

            Map data1 = (Map)result.get("data");

            List<Map<String,Object>> discoutplanlist = (List<Map<String,Object>>)data1.get("discountPlanVoList");
            if (discoutplanlist.size() > 0) {
                String ids_str = "[";
                for (Map<String, Object> displan : discoutplanlist) {
                    ids_str = ids_str + "\"" + displan.get("id") + "\",";
                }

                ids_str = ids_str.substring(0, ids_str.length() - 1) + "]";

                System.out.println(ids_str);

                form = new HashMap<String, String>();
                //params
                form.put("token", xtoken);
                form.put("app_key", app_key);
                form.put("entityType", "2");
                form.put("entityId", "00201115");
                form.put("brandEntityId", "10015105");
                form.put("ids_str", ids_str);


                sign = getSign(form);
                form.put("sign", sign);
                url = SERVER_PRE_URL + "/discount_plan/v1/remove_discount_plan?";
                response = httpRequest.postHandle(url, form, 200000);
                System.out.println("getResponseStr():" + response.getResponseStr());

                //验证返回结果
                ResultMap<String> resultMap = JsonHelper.stringToObject(response.getResponseStr(), ResultMap.class);
                Assert.assertEquals(resultMap.get("code").toString(), "1");
            }
        }catch(Exception e) {
            logger.error("list_discount_plan异常", e);
        }
    }
}