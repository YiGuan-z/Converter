package com.cqsd.api.lmpl;

import com.cqsd.api.BinarApi;

public class BinarApiImpl implements BinarApi {
    private BinarApiImpl() {
    }

    private static BinarApi binarApi;

    /**
     * 获取一个正数的二进制表示，通过模运算对当前数用2取模
     * 直到当前数比0小
     *
     * @param number 需要计算的正数
     * @return 返回一个二进制表示的字符串
     */
    @Override
    public String getBinary(String number) {
        int currentNum = Integer.parseInt(number);
        StringBuilder binary = new StringBuilder();
        //二进制计算
        do {
            binary.insert(0, (currentNum % 2));
        } while ((currentNum /= 2) > 0);
        //符号位
        binary.insert(0, "0");
        return binary.toString();
    }

    /**
     * 获取一个负数的二进制表示
     * 同样是通过取模法，中间过程中需要计算反码和补码
     *
     * @param number 需要计算的负数
     * @return 二进制表示的字符串
     */
    @Override
    public String getBinaryNegative(String number) {
        int currentNum = Integer.parseInt(number);
        StringBuilder binary = new StringBuilder();
        //计算二进制
        do {
            binary.insert(0, (currentNum % 2));
        } while ((currentNum /= 2) > 0);

        binary = new StringBuilder(reverse(binary.toString()));
        //补码计算
        String result = addBinary(binary.toString(), "1");
        //符号位
        result = "1" + result;
        return result;
    }

    /**
     * 二进制加法器
     * 通过逢二进一的原则来实现
     *
     * @param a 二进制字符串
     * @param b 二进制字符串
     * @return 二进制字符串
     */
    @Override
    public String addBinary(String a, String b) {
        //将两个二进制字符对齐
        String bin1 = a;
        String bin2 = b;
        while (bin1.length() < bin2.length()) bin1 = "0" + bin1;
        while (bin2.length() < bin1.length()) bin2 = "0" + bin2;
        //计算两个二进制字符的和
        int carry = 0;
        String result = "";
        for (int i = bin1.length() - 1; i >= 0; i--) {
            int sum = bin1.charAt(i) - '0' + bin2.charAt(i) - '0';
            //计算进位
            if (carry == 1) {
                sum += carry;
                carry = 0;
            }
            //产生进位
            if (sum >= 2) {
                carry = 1;
            }
            result = sum % 2 + result;
        }
        //将结果转换为字符串
        if (carry > 0) result = carry + result;
        return result;
    }

    /**
     * 二进制减法器
     * 通过对减数的补码进行加法计算
     *
     * @param a 二进制字符串
     * @param b 二进制字符串
     * @return 二进制字符串
     */
    @Override
    public String subBinary(String a, String b) {
        //将两个二进制字符对齐
        String bin1 = a;
        String bin2 = b;
        while (bin1.length() < bin2.length()) bin1 = "0" + bin1;
        while (bin2.length() < bin1.length()) bin2 = "0" + bin2;
        //将第二个二进制反转再加一
        String res = addBinary(reverse(bin2), "1");
        //计算两个二进制相加的和
        StringBuilder result = new StringBuilder(addBinary(bin1, res));
        result.delete(0, 1);
        return result.toString();
    }

    /**
     * 二进制乘法器
     *
     * @param a 二进制字符串
     * @param b 二进制字符串
     * @return 二进制字符串
     */
    @Override
    public String mulBinary(String a, String b) {
        int num1 = Integer.parseInt(toDecimal(a));
        int num2 = Integer.parseInt(toDecimal(b));
        String result = String.valueOf(num1 * num2);
        result = getBinary(result);
        return result;
    }

    /**
     * 二进制除法器
     *
     * @param a 二进制字符串
     * @param b 二进制字符串
     * @return 二进制字符串
     */
    @Override
    public String divBinary(String a, String b) {
        int num1 = Integer.parseInt(toDecimal(a));
        int num2 = Integer.parseInt(toDecimal(b));
        String result = String.valueOf(num1 / num2);
        result = getBinary(result);
        return result;
    }

    /**
     * 二进制取模器
     *
     * @param a 二进制字符串
     * @param b 二进制字符串
     * @return 二进制字符串
     */
    @Override
    public String modBinary(String a, String b) {
        int num1 = Integer.parseInt(toDecimal(a));
        int num2 = Integer.parseInt(toDecimal(b));
        String result = String.valueOf(num1 % num2);
        result = getBinary(result);
        return result;
    }
    //将二进制转换为十进制
    public String toDecimal(String number) {
        StringBuilder cal = new StringBuilder(number);
        String result;
        int res = 0;
        //内部循环控制替代 记录for循环步数
        int v = 0;
        for (int i = cal.length() - 1; i >= 0; i--) {
            v++;
            if (cal.charAt(i) == '1') {
                res += (int) Math.pow(2, v - 1);
            }
        }
        result = String.valueOf(res);
        return result;
    }

    /**
     * 二进制转十六进制
     *
     * @param number 二进制数
     * @return 十六进制数
     */
    @Override
    public String binToHex(String number) {


        return null;
    }

    /**
     * 十进制转十六进制
     *
     * @param number 十进制数
     * @return 十六进制数
     */
    @Override
    public String decToHex(String number) {
        return null;
    }

    /**
     * 十六进制转二进制
     *
     * @param number 十六进制数
     * @return 二进制数
     */
    @Override
    public String hexToBinary(String number) {
        return null;
    }

    /**
     * 十六进制转十进制
     *
     * @param number 十六进制数
     * @return 十进制数
     */
    @Override
    public String hexToDecimal(String number) {
        return null;
    }

    /**
     * 二进制转八进制
     *
     * @param number 二进制数
     * @return 八进制数
     */
    @Override
    public String binToOctal(String number) {
        return null;
    }

    public static synchronized BinarApi getInstance() {
        if (binarApi == null) {
            binarApi = new BinarApiImpl();
        }
        return binarApi;
    }
    //对齐二进制字符串
    public String align(String a, String b) {
        String bin1 = a;
        String bin2 = b;
        while (bin1.length() < bin2.length()) bin1 = "0" + bin1;
        while (bin2.length() < bin1.length()) bin2 = "0" + bin2;
        return bin1 + " " + bin2;
    }

    //反转二进制字符串
    public String reverse(String a) {
        StringBuilder result = new StringBuilder(a);
        for (int i = 0; i < a.length(); i++) {
            if (result.charAt(i) == '0') {
                result.setCharAt(i, '1');
            } else {
                result.setCharAt(i, '0');
            }
        }
        return result.toString();
    }

}
