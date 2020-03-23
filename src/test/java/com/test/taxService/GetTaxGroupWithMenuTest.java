package com.test.taxService;

import com.dfire.soa.boss.center.tax.vo.TaxMenuGroupVo;
import com.jum.testbase.TestBase;
import com.jum.utils.DBHelper;
import com.jum.utils.DataMap;
import com.jum.utils.JsonHelper;
import com.jum.utils.StringHelper;
import com.twodfire.share.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * 获取分组以及关联的menu
 * Created by rouyuan on 2018/07/02.
 * 前置条件：
 * 1. 门店：肉圆自动化测试门店1
 * 2. 税费分组三个，分别：‘没有商品’、‘一个商品且为连锁下发’、‘多个商品’
 * 测试思路：
 * 1. 调用接口获取数据；
 * 2. 调用查询数据库；
 * 3. 接口返回数据和数据库数据进行对比；
 */
public class GetTaxGroupWithMenuTest extends TestBase {
    public static Logger logger = LoggerFactory.getLogger(GetTaxGroupWithMenuTest.class);

    @Test(dataProvider = "CsvDataProvider", enabled = true)
    public void testGetTaxGroupWithMenu_ryuan(Map<String, String> data) throws Exception {
        //读case
        long groupid = StringHelper.convert2Long(data.get("GroupId"));
        String brandentityid = StringHelper.convert2String(data.get("brandEntityId"));
        String entityid = StringHelper.convert2String(data.get("entityId"));
        String caseid = data.get("caseid");
        String description = data.get("description");
        boolean expect = Boolean.parseBoolean(data.get("expect"));

        Result<TaxMenuGroupVo> rs = null;
        //调用服务
        rs = taxService.getTaxGroupWithMenu(brandentityid, entityid, groupid);
        logger.info(JsonHelper.objectToString(rs.getModel()));

        Assert.assertEquals(rs.isSuccess(), expect, "接口调用失败");
        if (expect == true) {
            TaxMenuGroupVo model = rs.getModel();
            //获取税费分组基本信息
            DBHelper.setdruidDataSource(turtleDataSource);
            String select_sql = "select * from tax_rate_group where id = \"" + groupid + "\" and is_valid = 1 and entity_id = " + entityid;
            List<DataMap> dblist = DBHelper.executeQuery(select_sql);
            logger.info(dblist.toString());
            Map<String, Object> dbmodel1 = dblist.get(0);
            logger.info(JsonHelper.objectToString(dbmodel1));

            Assert.assertEquals(model.getEntityId(), entityid, "entityid不正确");
            Assert.assertEquals(model.getGroupTax(), Integer.parseInt(dbmodel1.get("GROUP_TAX").toString()), "group_tax不正确");
            Assert.assertEquals(model.getName(), dbmodel1.get("NAME")+"1", "name不正确");
            Assert.assertEquals(model.getName(), dbmodel1.get("NAME")+"1", "name不正确");

        }
    }
}