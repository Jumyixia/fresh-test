package com.jum.utils.compare;

import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AssertUtil extends Assert{
	private static final Logger logger = Logger.getLogger(AssertUtil.class);

	public static void contains(String actualValue, String expectValue) {
			try {
				Assert.assertTrue(actualValue.contains(expectValue), String
						.format("期待'%s'包含'%s'，实际为不包含", actualValue,
								expectValue));
			} catch (AssertionError e) {
				// TODO: handle exception
				String detailMsg = e.getMessage();
				int index = detailMsg.indexOf("expected");//去掉 expected 后面的字符串
				detailMsg = detailMsg.substring(0, index);
				AssertionError assertionError = new AssertionError(detailMsg);
				throw assertionError;
			}
		
	}
	
	public static void notContains(String actualValue, String expectValue) {
		try {
			Assert.assertFalse(actualValue.contains(expectValue), String
					.format("期待'%s'不包含'%s'，实际为包含.", actualValue, expectValue));
		} catch (Exception e) {
			String detailMsg = e.getMessage();
			int index = detailMsg.indexOf("expected");//去掉 expected 后面的字符串
			detailMsg = detailMsg.substring(0, index);
			AssertionError assertionError = new AssertionError(detailMsg);
			throw assertionError;
		}
	}
	
	public static void assertEquals(Object actualValue, Object expectValue,String message) {
		if (expectValue!=null&&String.valueOf(expectValue).equalsIgnoreCase("N/A")) {
			return ;
		}
		Assert.assertEquals(actualValue,  expectValue, message);
	}
	
	
	public static void assertEquals(String actualValue, String expectValue,String message) {
		if (expectValue!=null&&expectValue.equalsIgnoreCase("N/A")) {
			return ;
		}
		Assert.assertEquals(actualValue,  expectValue, message);
	}
	
	public static void assertEquals(Double actualValue, String expectValue,String message) {
		if (expectValue!=null&&expectValue.equalsIgnoreCase("N/A")) {
			return ;
		}
		Assert.assertEquals(actualValue, Double.valueOf(expectValue), message);
	}

	@SuppressWarnings("rawtypes")
	public static  void assertEmpty(List model, String message) {
		if (model!=null) {
			Assert.assertEquals(model.size(),0,message);
		}else {
			Assert.assertNull(model,message);
		}
		
	}

	@SuppressWarnings("rawtypes")
	public static void assertNotEmpty(List model, String message) {
		Assert.assertNotNull(model,message);
		Assert.assertNotEquals(model.size(),0,message);
	}

	/**
	 * 比较两个map
	 * @param actual
	 * @param expected
	 * @param type 0：存在不一致； 1：actual包含expected 2：完全一致；
	 * @param message
	 */
	public static void AsserMapCompare(Map actual, Map expected, int type, String message){
		Map act = new HashMap();
		act.putAll(actual); //进行深拷贝
		int arg = mapCompare(act, expected);
		arg = type == 1 ? (arg == 2 ? 1 : arg) : arg;
		Assert.assertEquals(arg, type, message);
	}

	/**
	 * 比较两个map是否一致
	 * @param actual
	 * @param expected
	 * @return
	 * 0：存在不一致；
	 * 1：actual包含expected且存在更多值
	 * 2：完全一致；
	 */
	public static int mapCompare(Map actual, Map expected) {
		Iterator<Map.Entry<String, Object>> expected_it = expected.entrySet().iterator();
		while (expected_it.hasNext()) {
			Map.Entry<String, Object> entry = expected_it.next();
			if (!actual.get(entry.getKey()).equals(entry.getValue())){
				logger.info("mapCompare：" + entry.getKey() + "，两边不一致");
				return 0;
			}else {
				actual.remove(entry.getKey());
			}
		}

		if (actual.size() == 0){
			return 2;
		}else {
			return 1;
		}
	}

	/**
	 * 比较两个map是否一致：
	 * 1. 先判空
	 * 2. 判size：
	 * 	2.1 actual.size < expected.size 则返回0
	 * 	2.2 遍历expected，判断actual.get(entry.getKey()).equals(entry.getValue())
	 * 		2.2.1 如果存在不一致，则返回0
	 * 		2.2.2 如果全部一致，则再判断大小
	 * 			2.2.2.1 大小一致，则返回1
	 * 			2.2.2.2 如果actual.size > expectede.size，则返回2
	 * @param actual
	 * @param expected
	 * @return
	 * 0：存在不一致；
	 * 1：actual包含expected且存在更多值
	 * 2：完全一致；
	 */
	public static int mapCompare2(Map actual, Map expected) {
		if (null == actual || null == expected) {
			return 0;
		}

		if (actual.size() < expected.size()){
			logger.info("mapCompare：actual 内容少于 expected");
			return  0;
		}else {
			Iterator<Map.Entry<String, Object>> expected_it = expected.entrySet().iterator();
			while (expected_it.hasNext()) {
				Map.Entry<String, Object> entry = expected_it.next();
				if (!actual.get(entry.getKey()).equals(entry.getValue())) {
					logger.info("mapCompare：" + entry.getKey() + "，两边不一致");
					return 0;
				}
			}
			if (actual.size() == expected.size()){
				return 2;
			}else {
				return 1;
			}
		}
	}
}
