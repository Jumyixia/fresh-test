package com.jum.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by IntelliJ IDEA.
 * Date: 12-5-9
 * Time: 上午11:08
 * To change this template use File | Settings | File Templates.
 */
public class MD5Util {


    private static final int LO_BYTE = 0x0f;
    private static final int MOVE_BIT = 4;
    private static final int HI_BYTE = 0xf0;
    private static final String[] HEX_DIGITS = { "0", "1", "2", "3", "4", "5", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$

    /**
     * 防止被构建.
     */
    private MD5Util() {

    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param b
     *            字节数组
     * @return 16进制字串
     */

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            buf.append(byteToHexString(b[i]));
        }
        return buf.toString();
    }

    /**
     * 字节转成字符.
     *
     * @param b
     *            原始字节.
     * @return 转换后的字符.
     */
    private static String byteToHexString(byte b) {
        return HEX_DIGITS[(b & HI_BYTE) >> MOVE_BIT] + HEX_DIGITS[b & LO_BYTE];
    }

    /**
     * 进行加密.
     *
     * @param origin
     *            原始字符串.
     * @return 加密后的结果.
     */
    public static String encode(String origin) {
        if (origin == null) {
            throw new IllegalArgumentException(("MULTI_000523"/*加密传入参数不正确!*/)); //$NON-NLS-1$
        }
        String resultString = null;

        resultString = new String(origin);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); //$NON-NLS-1$
            try {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

        return resultString;
    }


    public static void main(String[] args){
        System.out.println(encode("的是非得失法"));
    }


}
