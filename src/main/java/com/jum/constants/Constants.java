package com.jum.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Constants {
	
	//贻贝自动化测试店
	public static final String 	BRAND_ENTITY_ID = "99929799";  //连锁自动化测试总店
	public static final String 	SHOP1_ENTITY_ID = "99929800";  //贻贝自动化测试店1
	public static final String 	SHOP2_ENTITY_ID = "99929801"; //贻贝自动化测试店2
	public static final String 	SHOP1_ID = "8b57e640703ce77733e8da7712bd3ed9";  //贻贝自动化测试店1
	public static final String 	PLATE1_ENTITY_ID = "99929804"; //品牌1
	public static final String 	PLATE2_ENTITY_ID = "99929805"; //品牌2
	public static final String 	PLATE3_ENTITY_ID = "99929806"; //品牌3
	public static final String 	PLATE1_ID = "9992979958d3767f0158d7130f460000"; //品牌1的id
	
	/********************连锁下发自动化数据准备***************************************/
	public static final String 	DJYY_VAL = "en_US"; //连锁下发单据语言为英文
	//品牌1下的商品list = 商品促销数据
	public static final List<String> PLATE1_MEMU_LIST = new ArrayList<String>(Arrays.asList("连锁商品1", "连锁西红柿炒蛋"));
	//品牌1下的商品类目list
	public static final List<String> PLATE1_KINDMEMU_LIST = new ArrayList<String>(Arrays.asList("连锁商品分类1", "连锁三级分类"));
	//品牌1下的商品规格list
	public static final List<String> PLATE1_SPEC_LIST = new ArrayList<String>(Arrays.asList("连锁规格1", "连锁规格2"));
	//品牌1下的商品做法list
	public static final List<String> PLATE1_MAKE_LIST = new ArrayList<String>(Arrays.asList("连锁做法1", "连锁做法2"));
	//品牌1下的商品备注list
	public static final List<String> PLATE1_TASTE_LIST = new ArrayList<String>(Arrays.asList("连锁备注1", "连锁备注2"));
	//品牌1下的商品单位list
	public static final List<String> PLATE1_UNIT_LIST = new ArrayList<String>(Arrays.asList("连锁单位1", "连锁单位2"));
	//品牌1下的商品加料list
	public static final List<String> PLATE1_ADDTION_LIST = new ArrayList<String>(Arrays.asList("连锁加料1", "连锁加料2"));
	//连锁付款方式下发list
	public static final List<String> PLATE1_KINDPAY_LIST = new ArrayList<String>(Arrays.asList("连锁现金", "连锁银行卡"));
	//需要清理连锁数据的门店list
	public static final List<String> SHOP_ENTITYID_LIST = new ArrayList<String>(Arrays.asList("99929801","99929800"));
	//连锁下发的各种收银优惠
	public static final List<String> PLATE1_DISCOUNTPLAN_LIST = new ArrayList<String>(Arrays.asList("连锁打折方案"));
	public static final List<String> PLATE1_FULLDISCOUNT_LIST = new ArrayList<String>(Arrays.asList("连锁整单满减"));
	public static final List<String> PLATE1_RECEIVEDISCOUNT_LIST = new ArrayList<String>(Arrays.asList("连锁应收打折"));

		
	//海浮石自动化测试涉及常量
	public static String ENTITY_ID = "99929066";//海浮石连锁总店
	public static String ENTITY_ID_DD = "99926544";//海浮石连锁门店
	public static String ENTITY_ID_D1 = "99930081";//海浮石单店
	public static String USER_ID = "78a30fa4a5464e1e8ccacb585de25d85";//userid
	public static String PRICEPLAN_ID;//价格方案id
	public static int LASTVER;//版本号
	public static String MENU_ID;//菜品id
	public static String MENU_ID2;//菜品id2
	public static String SUITMENU_ID;//套餐id
	public static String SUITMENU_ID2;//套餐id2
	public static String BLACKLIST_ID = "9992654459a65e8e015a4f3a726c0004";//黑名单id
	public static String WX_APP_ID = "wx656903d306f112ef";//微信公众号id
	public static String SPECIAL_TAG_ID;//特色标签id
	public static String MAKE_ID;//做法id
	public static String MENU_MAKE_ID;//商品做法id
	public static String SPEC_ID;//规格id
	public static String SPEC_ID1;//规格specId
	public static String[] BATH_MENU_ID = new String[3];//批量操作
	public static String KIND_MENU_ID;//商品分类id
	public static String KIND_MENU_ID_TC;//套餐分类id
	public static String KIND_MENU_ID_LS;//连锁商品分类id
	public static String KIND_TASTE_ID;//备注分类id
	public static String KIND_TASTE_ID_LS;//连锁备注分类id
	public static String TASTE_ID;//备注id
	public static String TASTE_ID_LS;//连锁备注id
	public static String KIND_ADDITION_ID;//加料分类id
	public static String KIND_ADDITION_ID_LS;//连锁加料分类id
	public static String ADDITION_ID;//加料id
	public static String ADDITION_ID_LS;//连锁加料id
	public static String MENU_TIME_ID1;//商品促销活动id
	public static String MENU_TIME_ID2;//商品打折活动id
	public static String MENU_TIME_PRICE_ID1;//促销活动下的商品
	public static String MENU_TIME_PRICE_ID2;//打折活动下的商品
	public static String MENU_TIME_PRICE_ID3;//打折活动下的商品
	public static String RULE_ID;//撞餐规则id
	public static String CHANGE_ID;//套餐分组内商品id
	public static String DETAIL_ID1;//套餐分组id
	public static String DETAIL_ID2;//套餐分组id
	public static String MENU_DETAIL_ID1;//商品图1
	public static String MENU_DETAIL_ID2;//商品图2
	public static String HEAD_PIC_ID;//头图id
	public static String DETAIL_PIC_ID;//详情图id

	
	//山楂酱自动化测试店
    public static final String BRAND_ENTITY_ID_SZJ = "99929720";  // 连锁总店
    public static final String PLATE_ENTITY_ID_SZJ = "99929729";  // 品牌
	public static final String BRANCH_ENTITY_ID_SZJ = "99932836" ; //分公司
    public static final String SHOP_ENTITY_ID_SZJ = "99929719";  // 门店
    public static final String SHOP_ENTITY_ID_SZJ2 = "99934636"; //门店2
    public static final String SHOP_ENTITY_ID_SZJ3_LS = "99934580"; //零售单店开店
    public static final String SHOP_ENTITY_ID_SZJ4_TW = "99934614"; //台湾店开店(单店)

	//入参实体类型entity_type 0、单店 1、总部 2、门店 3、分公司
    public static final String ENTITY_TYPE_SHOP = "0";  // 单店
    public static final String ENTITY_TYPE_BRAND = "1";  // 总部
	public static final String ENTITY_TYPE_LINKSHOP = "2";  // 门店
	public static final String ENTITY_TYPE_BRANCH = "3";  // 门店

	//行业类型 0餐饮 3零售
	public static final String INDUSTRY_RETAIL = "3";  // 单店


    public static final String MEMBER_ID_SZJ = "aef301d7075e4c52be8c3f0b4eb64508";//开店测试member_id 对应15000000010
    public static final String MOBOLE_SZJ = "+86 15000000010";

	public static final String GUIDE_ICON_URL = "http://assets.2dfire.com/boss/function/guide/";

    public static final String HOMEPAGE_V6 = "5.8.2";  // 门店



	//栗子自动化测试店
	public static final String 	BRAND_ENTITY_ID_LZ = "99930327";  //连锁总店
	public static final String 	SHOP1_ENTITY_ID_LZ = "99930331";  //门店1
	public static final String 	SHOP2_ENTITY_ID_LZ = "99930332";  //门店2
	public static final String 	PLATE_ENTITY_ID_LZ = "99930334";  //品牌
	public static final String  SHOP3_ENTIYI_ID_LZ = "99932376";  //单店
	public static final String 	BRAND1_ENTITY_ID_LZ = "99929385";  //栗子连锁测试3

	
	//肉圆自动化测试店
	public static final String 	BRAND_ENTITY_ID_RY = "99932371";  //肉圆自动化测试连锁店、5000312
	public static final String  BRAND_USERID_RY = "76182c12ceb0428d95dfcf96435bf521";
	public static final String 	BRAND_ENTITY_ID_RY2 = "99935705";  //肉圆自动化测试连锁店2、5000302
	public static final String 	PLATE_ENTITY_ID_RY = "99932372";  //品牌
	public static final String 	SHOP_ENTITY_ID_RY = "99932287";  //肉圆自动化测试门店	5000311
	public static final String 	SHOP_ENTITY_ID_RY1 = "99932248";  //肉圆自动化测试门店1、9032747
	public static final String  SHOP_ENTITY_ID_RY2 = "99932241"; //肉圆自动化测试门店2	9029619（没有商品数据）
	public static final String  MALL_ENTITY_ID_RY = "99935513";	//肉圆接口自动化商场、SM0078099
	public static final String  MALL_ENTITY_ID_RY2 = "99935704";	//肉圆接口自动化商场2、SM008388
	public static final String  TAKEOUT_SHOP = "99931453";		//第三方外卖专用门店：生地测试门店4
	public static final String  TAKEOUT_BRAND = "99930921";		//第三方外卖专用连锁：生地连锁店

	public static List<String> DISCOUNT_PLAN_ID = new ArrayList();	//打折方案id
	public static List DISCOUNT_PLAN_LASTVER = new ArrayList();	//打折方案lastver
	public static String CREDIT_CODE = "";	//统一社会信用代码
	public static String OPEN_TICKET_NAME = "";	//开票名称


	//店家资料，ShopImg分类
	public static final int TYPE_IMAGE_SHOP = 0;	//店家图片
	public static final int TYPE_IMAGE_DOOR = 2;	//店铺门头照
	public static final int TYPE_IMAGE_LOGO = 3;	//店家logo


	// 商家类型(1:店铺, 2:连锁)
	public final static String ENTITY_TYPE_SHOP1 = "1";
	public final static String ENTITY_TYPE_BRAND1 = "2";

	//美团的appid、appsecret、appPoiCode
	public final static String APP_ID = "738";
	public final static String APP_SECRET = "c0971272a98f8a8cd420eda90e77c452";
	public final static String APP_POI_CODE = "t_1Gqt0A1dRD";

	//第三方外卖测试用的分类
	public final static String CATEGORY_ITEM_CREATE = "肉圆自动化分类商品";
	public final static String CATEGORY_ITEM_UPDATE = "肉圆分类商品勿删";
	public final static String CATEGORY_SUIT_CREATE = "肉圆自动化分类套餐";
	public final static String CATEGORY_SUIT_UPDATE = "肉圆分类套餐勿删";
	public final static String CATEGORY_CHAIN_ITEM_CREATE = "肉圆连锁商品勿删";
	public final static String CATEGORY_CHAIN_ITEM_UPDATE = "ry连锁商品勿删";
	public final static String CATEGORY_CHAIN_SUIT_CREATE = "肉圆连锁套餐勿删";
	public final static String CATEGORY_CHAIN_SUIT_UPDATE = "ry连锁套餐勿删";

	//第三方外卖回归测试，商品名称和商品id
	public final static List<Map> ITEM_INFO = new ArrayList();
	public final static List<Map> SUIT_INFO = new ArrayList();

	//珊瑚自动化测试店
	public static final String 	BRAND_ENTITY_ID_SH = "99931256";  //连锁总店--珊瑚国际化总部
	public static final String 	SHOP_ENTITY_ID_SH = "99931257";  //门店---珊瑚内网测试
	public static final String 	SHOP_ENTITY_ID_SH2 = "99931153";  //门店---珊瑚自动化测试店
	public static final String 	SHOP_ENTITY_TYPE = "2";//门店---类型(0、单店 1、总部 2、门店 3、分公司)
	public static final String 	USER_ID_SH = "a3cb79a5950647babab67297d2569d3a";//userId

	//生地自动化测试店
	public static final String 	BRAND_ENTITY_ID_SD = "99931383";  //连锁总店--生地连锁总部
	public static final String 	SHOP_ENTITY_ID_SD= "99931112";  //门店---生地内网测试门店2
	public static final String 	SHOP_ENTITY_TYPE_SD = "2";//门店---类型(0、单店 1、总部 2、门店 3、分公司)

	//半夏自动化测试店
	public static final String 	BRAND_ENTITY_ID_BX = "99933919";  //半夏自动化连锁
	public static final String 	SHOP_ENTITY_ID_BX = "99932605";   //半夏自动测试店
	
	//收银设置中各项目访问路径
	public static final String 	URL_SHOP_TEMPLATE = "/shop_template/v2/list_all_shop_template"; //收银单据设置
	public static final String 	URL_DIC_ITEM = "/dic_item/v2/list_dic_item"; //客单备注
	public static final String 	URL_SPEC_REASION = "/special_reason/v2/list_special_reason"; 
	public static final String 	URL_DISCOUNT_PALEN = "/discount_plan/v2/list_discount_plan"; 
	public static final String 	URL_FULL_DISCOUNT = "/full_discount/v1/get_full_discount_list"; 
	public static final String 	URL_RECEIV_DISCOUNT = "/receivable_discount/v1/get_receivable_discount_list"; 
	public static final String 	URL_CONFIG_SET = "/config_set/v2/list";  //单据语言url

}
