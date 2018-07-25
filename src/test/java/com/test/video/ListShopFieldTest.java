package com.test.video;

import com.alibaba.fastjson.JSON;
import com.jum.http.Response;
import com.jum.testbase.TestBase;
import com.jum.utils.DBHelper;
import com.jum.utils.DataMap;
import com.jum.utils.JsonHelper;
import com.jum.utils.StringHelper;
import com.jum.utils.result.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * （连锁）店家宣传视频店家商品视频
 * 场景：
 * Created by rouyuan on 2017/10/10.
 */
public class ListShopFieldTest extends TestBase {
    public static Logger logger = LoggerFactory.getLogger("biz");

    @Test(dataProvider = "CsvDataProvider", enabled = false)
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
            form.put("entityId", entity_id);
            form.put("biz_type", biz_type);
            form.put("filter", filter);

            url = SERVER_URL + "/video/v1/list_shop_field?";
            response = httpRequest.postHandle(url, form, 200000);
            System.out.println(caseid + " getResponseStr():" + response.getResponseStr());


            //验证返回结果
            ResultMap<String> result = JsonHelper.stringToObject(response.getResponseStr(), ResultMap.class);
            Assert.assertEquals(result.get("code"), exp_code, "返回code和预期不一致");

            if ("5".equals(caseid)){
                Object data1 = result.get("data");
                Assert.assertEquals(data1, null, "data未null");
            }

            if ("3".equals(caseid)){
                List data1 = (List)result.get("data");

                DBHelper.setdruidDataSource(bossDataSource);
                List<DataMap> videofield = DBHelper.executeQuery("SELECT * FROM video_field WHERE entity_id = '99932287' AND biz_type = '1' AND is_valid = 1 ORDER BY create_time ASC" );

                for (int i = 0; i < data1.size(); i++){
                    Map field = (Map)data1.get(i);

                    //
                    String cycle = "有效期";
                    if (videofield.get(i).get("expired_date").equals("")){
                        cycle = cycle + "：" + videofield.get(i).getStringValue("cycle") + "个月";
                    } else {
                        cycle = cycle + ":" + videofield.get(i).getStringValue("init_date") + "~" + videofield.get(i).getStringValue("expired_date");
                        Assert.assertEquals(field.get("timDetail").toString().replace("/",""), cycle, "fieldId和数据库不一致");

                        String videofieldid = videofield.get(i).getStringValue("id");
                        List<DataMap> videofieldusage = DBHelper.executeQuery("SELECT * FROM video_field_usage WHERE field_id = '" + videofieldid + "' AND is_valid = '1'" );
                        String menuid = videofieldusage.get(0).getStringValue("biz_id");

                        Assert.assertEquals(field.get("fieldId"), videofieldid, "fieldId和数据库不一致");
                        Assert.assertEquals(field.get("fieldUsageId"), videofieldusage.get(0).get("id"),"fieldUsageId和数据库不一致");
                        Assert.assertEquals(field.get("menuId"), menuid, "menuId和数据库不一致");

                        //如果商品没有绑定视频，则没有coverUrl
                        if (field.containsKey("coverUrl")){
                            List<DataMap> videolibrary = DBHelper.executeQuery("SELECT * FROM video_library WHERE id in ( SELECT video_id FROM video_menu_relation WHERE menu_id = '" +  menuid + "')" );
                            Assert.assertEquals(field.get("coverUrl"), videolibrary.get(0).getStringValue("cover_url"), "coverUrl和数据库不一致");
                            Assert.assertEquals(field.get("videoUrl"), videolibrary.get(0).getStringValue("video_url"), "videoUrl和数据库不一致");
                        }

                        //如果商品id不正确时，不会返回menuName
                        if (field.containsKey("menuName")){
                            DBHelper.setdruidDataSource(itemDataSource);
                            List<DataMap> menu = DBHelper.executeQuery("SELECT * FROM item.menu WHERE menu_id = '" +  menuid + "')" );
                            Assert.assertEquals(field.get("menuName"), menu.get(0).getStringValue("name"), "menuName和数据库不一致");
                        }

                    }
                }
            }

        }catch(Exception e){
            logger.error("ListShopFieldTest异常",e);
        }
    }
}