package com.cqsd.controller;

import com.cqsd.api.BinarApi;
import com.cqsd.api.lmpl.BinarApiImpl;

public class Binar {
    //Don't let anyone instantiate this class.
    private Binar() {
    }

    private static final BinarApi binarApi = BinarApiImpl.getInstance();
//    private static final BinarApi binarApi=BinarApi.binar;
    /**
     * 十进制转二进制
     * 获取一个正数的二进制表示
     *
     * @param number 十进制数
     * @return 二进制数
     */
    public static String getBinary(String number) {
        return binarApi.getBinary(number);
    }

    /**
     * 获取一个负数的二进制表示
     *
     * @param number 十进制数
     * @return 二进制数
     */
    public static String getBinaryNegative(String number) {
        return binarApi.getBinaryNegative(number);
    }

    /**
     * 二进制加法器
     *
     * @param a 加数
     * @param b 被加数
     * @return 两个数的和
     */
    public static String addBinary(String a, String b) {
        return binarApi.addBinary(a, b);
    }

    /**
     * 二进制减法器
     *
     * @param a 减数
     * @param b 被减数
     * @return 两个数的差
     */
    public static String subBinary(String a, String b) {
        return binarApi.subBinary(a, b);
    }

    /**
     * 二进制乘法器
     *
     * @param a 乘数
     * @param b 被乘数
     * @return 两个数的积
     */
    public static String mulBinary(String a, String b) {
        return binarApi.mulBinary(a, b);
    }

    /**
     * 二进制除法器
     *
     * @param a 除数
     * @param b 被除数
     * @return 两个数的商
     */
    public static String divBinary(String a, String b) {
        return binarApi.divBinary(a, b);
    }

    /**
     * 二进制取模器
     *
     * @param a 模数
     * @param b 被取模数
     * @return 两个数的模
     */
    public static String modBinary(String a, String b) {
        return binarApi.modBinary(a, b);
    }

    /**
     * 二进制转十进制
     *
     * @param number 二进制数
     * @return 十进制数
     */
    public static String toDecimal(String number) {
        return binarApi.toDecimal(number);
    }

    /**
     * 二进制转八进制
     *
     * @param number 二进制数
     * @return 八进制数
     */
    public static String binToOctal(String number) {
        return binarApi.binToOctal(number);
    }

    /**
     * 二进制转十六进制
     *
     * @param number 二进制数
     * @return 十六进制数
     */
    public static String binToHex(String number) {
        return binarApi.binToHex(number);
    }

    /**
     * 十进制转十六进制
     *
     * @param number 十进制数
     * @return 十六进制数
     */
    public static String decToHex(String number) {
        return binarApi.decToHex(number);
    }

    /**
     * 十六进制转十进制
     *
     * @param number 十六进制数
     * @return 十进制数
     */
    public static String hexToDecimal(String number) {
        return binarApi.hexToDecimal(number);
    }

    /**
     * 查询10-15对应的字符
     *
     * @param number 十进制数
     * @return 对应的十六进制数
     */
    public static String getHexNumber(int number) {
        return binarApi.getHexNumber(number);
    }

    /**
     * 十进制转二进制
     * 获取一个正数的二进制表示
     * @param number 十进制数
     * @return 二进制数
     */
    public static String getBinaryPositive(String number) {
        return binarApi.getBinaryPositive(number);
    }
}
