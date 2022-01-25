package com.cqsd.api;

public interface BinarApi {
    /**
     * 十进制转二进制
     * 获取一个正数的二进制表示
     * @param number 十进制数
     * @return 二进制数
     */
    String getBinary(String number);

    /**
     * 获取一个负数的二进制表示
     * @param number 十进制数
     * @return 二进制数
     */
    String getBinaryNegative(String number);

    /**
     * 二进制加法器
     * @param a 加数
     * @param b 被加数
     * @return 两个数的和
     */
    String addBinary(String a, String b);

    /**
     * 二进制减法器
     * @param a 减数
     * @param b 被减数
     * @return 两个数的差
     */
    String subBinary(String a, String b);

    /**
     * 二进制乘法器
     * @param a 乘数
     * @param b 被乘数
     * @return 两个数的积
     */
    String mulBinary(String a, String b);

    /**
     * 二进制除法器
     * @param a 除数
     * @param b 被除数
     * @return 两个数的商
     */
    String divBinary(String a, String b);

    /**
     * 二进制取模器
     * @param a 模数
     * @param b 被取模数
     * @return 两个数的模
     */
    String modBinary(String a, String b);

    /**
     * 二进制转十进制
     * @param number 二进制数
     * @return 十进制数
     */
    String toDecimal(String number);

    /**
     * 二进制转八进制
     * @param number 二进制数
     * @return 八进制数
     */
    String binToOctal(String number);

    /**
     * 二进制转十六进制
     * @param number 二进制数
     * @return 十六进制数
     */
    String binToHex(String number);

    /**
     * 十进制转十六进制
     * @param number 十进制数
     * @return 十六进制数
     */
    String decToHex(String number);

    /**
     * 十六进制转二进制
     * @param number 十六进制数
     * @return 二进制数
     */
    String hexToBinary(String number);

    /**
     * 十六进制转十进制
     * @param number 十六进制数
     * @return 十进制数
     */
    String hexToDecimal(String number);
}
