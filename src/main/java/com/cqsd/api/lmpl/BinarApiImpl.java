package com.cqsd.api.lmpl;

import com.cqsd.api.BinarApi;

import java.util.HashMap;
import java.util.Map;

public class BinarApiImpl implements BinarApi {
    /**
     * 单例模式
     */
    private static BinarApi binarApi;
    /**
     * 十六进制字典
     */
    private final static Map<Integer, String> HexMap;

    //Don't let anyone instantiate this class.
    private BinarApiImpl() {
    }

    static {
        HexMap = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            HexMap.put(i, String.valueOf(i));
        }
        HexMap.put(10, "A");
        HexMap.put(11, "B");
        HexMap.put(12, "C");
        HexMap.put(13, "D");
        HexMap.put(14, "E");
        HexMap.put(15, "F");
    }

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
        StringBuilder bin1 = new StringBuilder(a);
        StringBuilder bin2 = new StringBuilder(b);
        while (bin1.length() < bin2.length()) bin1.insert(0, "0");
        while (bin2.length() < bin1.length()) bin2.insert(0, "0");
        //计算两个二进制字符的和
        int carry = 0;
        StringBuilder result = new StringBuilder();
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
            result.insert(0, sum % 2);
        }
        //将结果转换为字符串
        if (carry > 0) result.insert(0, carry);
        return result.toString();
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
        StringBuilder bin1 = new StringBuilder(a);
        StringBuilder bin2 = new StringBuilder(b);
        while (bin1.length() < bin2.length()) bin1.insert(0, "0");
        while (bin2.length() < bin1.length()) bin2.insert(0, "0");
        //将第二个二进制反转再加一
        String res = addBinary(reverse(bin2.toString()), "1");
        //计算两个二进制相加的和
        StringBuilder result = new StringBuilder(addBinary(bin1.toString(), res));
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
        //8421原则，和二转八类似
        //需要处理10-16的映射关系
        StringBuilder num = new StringBuilder(number);
        StringBuilder result = new StringBuilder();
        while (num.length() % 4 != 0) num.insert(0, "0");
        int t = 0;
        int sum = 0;
        char temp;
        for (int i = num.length() - 1; i >= 0; i--) {
            temp = num.charAt(i);
            t++;
            if (t == 1) {
                if (temp != '0') {
                    sum = sum + 1;
                }
            } else if (t == 2) {
                if (temp != '0') {
                    sum = sum + 2;
                }
            } else if (t == 3) {
                if (temp != '0') {
                    sum = sum + 4;
                }
            } else {
                if (temp != '0') {
                    sum = sum + 8;
                }
                if (sum > 9) {
                    result.insert(0, getHexNumber(sum));
                } else {
                    result.insert(0, sum);
                }
                sum = 0;
                t = 0;
            }
        }
        return result.toString();
    }

    /**
     * 十进制转十六进制
     *
     * @param number 十进制数
     * @return 十六进制数
     */
    @Override
    public String decToHex(String number) {
        //十进制转换十六进制
        //类似与十进制转换二进制
        StringBuilder result = new StringBuilder();
        int num = Integer.parseInt(number);
        if (num == 0) return "0";
        do {
            int temp = num % 16;
            if (temp > 9) {
                result.insert(0, getHexNumber(temp));
            } else {
                result.insert(0, temp);
            }
        } while ((num /= 16) > 0);
        return result.toString();
    }
    /**
     * 十六进制转十进制
     *
     * @param number 十六进制数
     * @return 十进制数
     */
    @Override
    public String hexToDecimal(String number) {
        StringBuilder num = new StringBuilder(number);
        String result;
        int sum = 0;
        int t = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            t++;
            if (num.charAt(i) != '0') {
                int temp = getDecNumber(String.valueOf(num.charAt(i)));
                sum = (int) (sum + temp * Math.pow(16, t - 1));
            }
        }
        result = String.valueOf(sum);
        return result;
    }

    /**
     * 二进制转八进制
     *
     * @param number 二进制数
     * @return 八进制数
     */
    @Override
    public String binToOctal(String number) {
        //421原则3为相加不足补0
        StringBuilder bin = new StringBuilder(number);
        while (bin.length() % 3 != 0) bin.insert(0, "0");
        //结果集
        String result;
        //文字暂存池
        StringBuilder res = new StringBuilder();
        //计算池
        int temp = 0;
        //内部判断变量
        int v = 0;
        for (int i = bin.length() - 1; i >= 0; i--) {
            //步增
            v++;
            //判断三个数字
            if (v == 1) {
                if (bin.charAt(i) != '0') {
                    temp += 1;
                }
            } else if (v == 2) {
                if (bin.charAt(i) != '0') {
                    temp += 2;
                }
            } else {
                if (bin.charAt(i) != '0') {
                    temp += 4;
                }
                //在第三部将结果加入res变量
                res.insert(0, temp);
                //将存储池和控制变量归零
                temp = 0;
                v = 0;
            }
        }
        result = res.toString();
        return result;
    }

    public static synchronized BinarApi getInstance() {
        if (binarApi == null) {
            binarApi = new BinarApiImpl();
        }
        return binarApi;
    }

    //对齐二进制字符串
    public String align(String a, String b) {
        StringBuilder bin1 = new StringBuilder(a);
        StringBuilder bin2 = new StringBuilder(b);
        while (bin1.length() < bin2.length()) bin1.insert(0, "0");
        while (bin2.length() < bin1.length()) bin2.insert(0, "0");
        return bin1 + " " + bin2;
    }

    //反转二进制字符串
    //这个方法有毒，耗时极长
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

    @Override
    public String getHexNumber(int number) {
        return HexMap.get(number);
    }

    /**
     * 通过value来获取key
     *
     * @param number 十六进制数
     * @return 十进制数
     */
    public int getDecNumber(String number) {
        final int[] result = new int[1];
        HexMap.keySet().forEach(key -> {
            if (HexMap.get(key).equals(number)) {
                result[0] = key;
            }
        });
        return result[0];
    }

}
