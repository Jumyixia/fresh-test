package com.jum.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created on 2016/12/30.
 * BigDecimal工具
 *
 * @author <a href="mailto:sutang@2dfire.com">酥糖</a>
 */
public class DecimalUtil {


    /**
     * 保留两位小数
     *
     * @param num
     * @return
     */
    public static BigDecimal formatTwoDigit(Number num) {
        return format(num, 2);
    }

    /**
     * 按需求保留小数位
     *
     * @param num
     * @param scale
     * @return
     */
    public static BigDecimal formatNum(Number num, int scale) {
        BigDecimal bigDecimal;
        if (null == num) {
            bigDecimal = new BigDecimal(0.00);
        } else {
            bigDecimal = new BigDecimal(num.doubleValue());
        }
        return formatNum(bigDecimal, scale);
    }

    /**
     * 按需求保留小数位
     *
     * @param num
     * @param scale
     * @return
     */
    public static BigDecimal formatNum(BigDecimal num, int scale) {
        return num.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }


    private static BigDecimal format(Number num, int digit) {
        if (num == null) {
            return new BigDecimal("0.00");
        }
//        if (digit < 0) {
//            throw Exception;
//        }
        StringBuilder decimalPoint = null;
        if (digit == 0) {
            decimalPoint = new StringBuilder("0");
        } else {
            decimalPoint = new StringBuilder("0.");
        }
        for (int i = 0; i < digit; i++) {
            decimalPoint.append("0");
        }
        return new BigDecimal(new DecimalFormat(decimalPoint.toString()).format(num));
    }

    /**
     * 金额格式化
     * formatMoney("123456789.234")  --> 123,456,789.23
     * formatMoney("126789.4")  --> 126,789.40
     * @param s
     * @return
     */
    public static String formatMoney(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        DecimalFormat format = new DecimalFormat("###,###.##");//仅保存两位小数
        String result = format.format(Double.parseDouble(s));
        if (result.indexOf(".") == -1) {//没有小数时，补充两位小数
            result = result + ".00";
        } else {
            String end = result.substring(result.indexOf(".") + 1);
            if (end.length() < 2) {//仅一位小数时，补充1位小数
                result = result + "0";
            }
        }
        return result;
    }

    /**
     * 数字格式化取整
     *
     * @param s
     * @return
     */
    public static String formatInt(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        DecimalFormat format = new DecimalFormat("###,###");
        double num = Double.parseDouble(s);
        String result = format.format(num);
        return result;
    }

    /**
     * 处理数字显示, +量词
     * @param amount
     * @param quantifier
     * @return
     */
    public static String formatNumber(int amount, String quantifier) {
        // 小于10万,  直接展示数字
        if (amount < 100000) {
            return String.valueOf(amount) + quantifier;
        }
        // 小于10亿, 用XXX.XX万展示
        if (amount < 1000000000) {
            return String.format("%.2f万%s", amount / 10000d, quantifier);
        }
        return String.format("%.2f亿%s", amount / 100000000d, quantifier);
    }

    /**
     * 处理金额显示,  先除100, 然后处理, 加量词
     * @param amount
     * @param quantifier
     * @return
     */
    public static String formatMoney(long amount, String quantifier) {
        double money = amount / 100d;
        // 小于10万,  直接展示数字
        if (money < 100000) {
            return String.format("%.2f%s", money, quantifier);
        }
        // 小于10亿, 用XXX.XX万展示
        if (money < 1000000000) {
            return String.format("%.2f万%s", money / 10000, quantifier);
        }
        return String.format("%.2f亿%s", money / 100000000, quantifier);
    }

    public static void main(String[] args){
        System.out.println(formatMoney(1234567891,"元"));
    }
}
