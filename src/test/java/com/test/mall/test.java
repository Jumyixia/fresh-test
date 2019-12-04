package com.test.mall;

import com.alibaba.fastjson.JSON;
import com.dfire.soa.boss.agreement.bo.AgreementPrimaryBO;
import com.dfire.soa.boss.agreement.enums.AgreementTypeEnum;
import com.dfire.soa.boss.agreement.service.IEntireAgreementService;
import com.jum.http.Response;
import com.jum.testbase.TestBaseNoResource;
import com.jum.vo.shoppingmall.MallContractVo;
import com.jum.vo.shoppingmall.MallVo;
import com.twodfire.share.result.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.ui.Model;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class test extends TestBaseNoResource {

    @Resource
    private IEntireAgreementService entireAgreementService;

    public void addTestMall(Model model, String phone, String mallName, Boolean Is2dfireErp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = System.currentTimeMillis();

        //添加一个默认合同
        MallContractVo mallContractVo = new MallContractVo();
        mallContractVo.setCode("" + time);
        mallContractVo.setName("测试合同" + time);
        mallContractVo.setFirstPartyCompany("测试甲方公司");
        mallContractVo.setFirstPartyLinkMan("测试甲方联系人");
        mallContractVo.setFirstPartyPhone(StringUtils.isNotBlank(phone) ? phone : "18767122238");
        mallContractVo.setSecondPartyCompany("测试乙方公司");
        mallContractVo.setSecondPartyLinkMan("测试乙方联系人");
        mallContractVo.setSecondPartyPhone(StringUtils.isNotBlank(phone) ? phone : "18767122238");
        mallContractVo.setSigningTime(simpleDateFormat.format(new Date(time)));
        mallContractVo.setValidTime(mallContractVo.getSigningTime());
        mallContractVo.setExpireTime(simpleDateFormat.format(new Date(time + 1000L * 60 * 60 * 24 * 365 * 2)));
        mallContractVo.setSalesMan("测试销售人员");
        mallContractVo.setUrl("https://download.2dfire.com/restadapter/20180809/invoice/15c2437415924f46b2cbd937ed8be2bb");
        AgreementPrimaryBO agreementPrimaryBO = new AgreementPrimaryBO();
        agreementPrimaryBO.setName(mallContractVo.getName());
        agreementPrimaryBO.setCode(mallContractVo.getCode());
        agreementPrimaryBO.setAgreementModule(JSON.toJSONString(mallContractVo));
        agreementPrimaryBO.setType(AgreementTypeEnum.TRADING_AREA.getType());
        // 编辑
        Result<Boolean> insertResult = entireAgreementService.addAgreementPrimary(agreementPrimaryBO);
        if (!insertResult.isSuccess()) {
            System.out.println("创建合同失败");
        }

        //添加一个默认商圈
        MallVo mallVo = new MallVo();
        mallVo.setName(StringUtils.isNotBlank(mallName) ? mallName : "测试商圈" + time);
        mallVo.setCountryId("001");
        mallVo.setProvinceId("11");
        mallVo.setCityId("78");
        mallVo.setTownId("769");
        mallVo.setStreetId("330105003");
        mallVo.setAddress("教工路");
        mallVo.setAdminMobileCode("+86");
        mallVo.setAdminMobile(StringUtils.isNotBlank(phone) ? phone : "18767122238");
        mallVo.setLinkman(StringUtils.isNotBlank(phone) ? phone : "18767122238");
        mallVo.setLinkMobile(StringUtils.isNotBlank(phone) ? phone : "18767122238");
        mallVo.setMallContractCode(mallContractVo.getCode());
    }

    @Test
    public void test1(){
        //调用Http服务
        Response response = null;
        try{
            Map<String,String> form = new HashMap<String, String>();
            //params
            form.put("mallName","肉圆test000003");

//            String url = "http://10.1.29.208:8080/yardcontent/shoppingmall/addTestMall.do?";
            String url = "http://yardcontent.2dfire-daily.com/shoppingmall/addTestMall.do?";
            response = httpRequest.postHandle(url, form, 200000);
            System.out.println(" getResponseStr():" + response.getResponseStr());



        }catch(Exception e){
            System.out.println(e);
        }
    }
}
