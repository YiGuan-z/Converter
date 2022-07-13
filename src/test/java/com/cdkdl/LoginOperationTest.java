package com.cdkdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class LoginOperationTest {
    @Test
    void testBoolean() {
        int a = 10;
        int b = 20;
        int c = 30;
        //与 只要表达式中有一个false就会返回false 遇假为假 ，遇到第一个false就不会进行后续运算
        System.out.println((a <= b) && (a <= c)); //true&&true true
        System.out.println((a <= b) && (a > c)); // true && false false
        System.out.println((b >= c) && (c > a)); //false
        System.out.println((c <= b) && (c <= a)); //false
        //或 只要表达式中又一个为true就会返回true 遇真为真，遇到第一个true就不会进行后续运算
        System.out.println((a <= b) || (a <= c)); //true true
        System.out.println((a <= b) || (a > c)); // true && false false
        System.out.println((b >= c) || (c > a)); //false || true true
        System.out.println((c <= b) || (c <= a)); //false || false false
        //非 对表达式进行取反运算
        System.out.println(!(a <= b)); // !true false
        System.out.println(!(a <= b)); // !false true
    }

    @Test
    void testIf() {
        //需求 判断年龄，如果小于18，提示未满18岁禁止进入
//        Scanner scanner = new Scanner(System.in);
        int score = 3;
        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 60 && score <= 90) {
            System.out.println("及格");
        } else {
            System.out.println("差");
        }
    }

    @Test
    void testSwitch() {
        //需求，使用switch完成输入的值在1-7之间输出对应的星期几
        int day = 8;
        switch (day) {
            case 1:
                System.out.println("周一");
                break;
            case 2:
                System.out.println("周二");
                break;
            case 3:
                System.out.println("周三");
                break;
            case 4:
                System.out.println("周四");
                break;
            case 5:
                System.out.println("周五");
                break;
            case 6:
                System.out.println("周六");
                break;
            case 7:
                System.out.println("周日");
                break;
            default:
                System.out.printf("一个星期有%d吗？", day);
        }
    }

    @Test
    void testFor() {
        int result = 0;
        for (int i = 0; i <= 100; i++) {
            result += i;
        }
        System.out.printf("1...100自然数的和是:%d\n", result);
    }

    @Test
    void testWhile() {
        //需求 1-10之间所有偶数的和
        //需要加的数字
        int count = 0;
        //结果
        int result = 0;
        while (count <= 100) {
            result += count++;
        }
        System.out.printf("1...100的和是%d", result);

    }

    @Test
    void testDoWhile() {
        int count = 0;
        int result = 0;
        do {
            result += (count % 2 == 0) ? 0 : count;
            count++;
        } while (count <= 100);
        System.out.printf("1...100的偶数值是%d", result);
    }

    @Test
    void testPrint() {
        StringBuilder sb = new StringBuilder("*");
        for (int i = 0; i < 5; i++) {
            System.out.println(sb);
            sb.append("*");
        }
    }

    /**
     * 打印99乘法表
     */
    @Test
    void testPrint99() {
//        ClassLoader.
        for (int row = 1; row <= 9; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.printf("%d*%d=%d ", col, row, row * col);
            }
            System.out.println();
        }
    }

    @Test
    void loopControl() {
        int count = 0;
        //从1输出到10，当变量为7的时候结束循环
        for (int i = 0; i <= 10; i++) {
            if (i == 7)
                break;
            count++;
        }
        System.out.printf("当前是%d", count);
    }

    @Test
    void testContinue() {
        for (int i = 0; i <= 10; i++) {
            if (i == 7) continue;
            System.out.printf("当前id是%d\n", i);
        }
    }

    @Test
    void testShuai() {
        int result = 0;
        for (int i = 1; i <= 500; i++) {
            result += (i % 7 == 0) ? i : 0;
        }
        System.out.printf("1...500能被7整除数的结果为%d", result);
    }

    /**
     * 从100每次递减5输出直至5
     */
    @Test
    void testDecreasing() {
        int result = 100;
        System.out.println("*****************************************");
        do {
            System.out.printf("%d\t", result);
        } while ((result -= 5) >= 5);
        System.out.println();
        System.out.println("*****************************************");
    }

    /**
     * 1至50中是7的倍数数值之和
     */
    @Test
    void testSum() {
        int count = 1;
        int result = 0;
        while (count++ <= 50) {
            result += (count % 7 == 0) ? count : 0;
        }
        System.out.printf("1...50中7的倍数之和是%d", result);
    }

    /**
     * 输入一批整数，使用循环求出最大值和最小值
     */
    @Test
    void ifMaxNumber() {
        int testNumber[] = new int[]{
                90, 78, 0, 5, 345, 45, 1, 2345
        };
        int index = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        print();
        while (index < testNumber.length) {
            //如果当前数大于max里面的数字，就把max更新到当前数值
            if (testNumber[index] > max) {
                max = testNumber[index];
            }
            //如果当前数小于Int最大值，就把min赋值到min
            if (testNumber[index] < min) {
                min = testNumber[index];
            }
            index++;
        }
        System.out.printf("最大值为%d\n最小值为%d\n", max, min);
        print();
    }

    /**
     * 100到999之间的水仙花数有及格
     */
    @Test
    void daffodils() {
        int start = 100;
        int count = 0;
        print();
        for (int i = start; i <= 999; i++) {
            int gewei = i % 10;
            int shiwei = i % 100 / 10;
            int baiwei = i % 1000 / 100;
            int resule = (int) (Math.pow(gewei, 3) + Math.pow(shiwei, 3) + Math.pow(baiwei, 3));
            if (i == resule) {
                count++;
                System.out.printf("%d\t", i);
            }
        }
        System.out.println();
        print();
        System.out.printf("100...999之间的水仙花数有%d个", count);
    }

    /**
     * 1到100之间的倍数输出haha，
     * 5的倍数输出heihei15的倍数输出hahaheihei，其它原样输出
     */
    @Test
    void testHahaPrint() {
        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.printf("%d\thahaheihei\n", i);
            } else if (i % 3 == 0) {
                System.out.printf("%d\thaha\n", i);
            } else if (i % 5 == 0) {
                System.out.printf("%d\theihei\n", i);
            } else {
                System.out.printf("%d\n", i);
            }
        }
    }

    /**
     * 鸡兔同笼
     * 一共35头
     * 94只脚
     */
    @Test
    void chicken() {
        int head = 35;
        int foot = 94;
        int x = 2 * head - foot / 2;
        int y = head - x;
        print();
        System.out.printf("鸡有%d只，兔子有%d只", x, y);
        print();
    }

    @Test
    void draw() {
        var sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append("*");
            System.out.println(sb);
        }
    }

    @Test
    void draw1() {
        int data[] = new int[]{
                //9x9的画布上
                //顶点为1：5 4：2 4：8
                0, 0, 0, 0, 1, 0, 0, 0, 0,
                0, 0, 0, 1, 0, 1, 0, 0, 0,
                0, 0, 1, 0, 0, 0, 1, 0, 0,
                0, 1, 0, 0, 1, 0, 0, 1, 0,
        };
        print();
        for (int i = 0; i < data.length; i++) {
            if (i == 0) continue;
            if (i % 9 == 0) {
                System.out.println();
            } else {
                if (data[i] == 0) {
                    System.out.print(" ");
                } else if (data[i] == 1) {
                    System.out.print("*");
                }
            }
        }
        System.out.println();
        print();
    }

    @Test
    void testYear() {
        int result = 0;
        //定义一个需要分析的表达式
        String expression = "2022/01/08";
        //定义一年的年份
        int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //将表达式通过/分割
        String[] exp = expression.split("/");
        //获取年月日
        int year = Integer.parseInt(exp[0]);
        int month = Integer.parseInt(exp[1]);
        int day = Integer.parseInt(exp[2]);
        System.out.printf("year:%-2d month:%-2d day:%-2d\n", year, month, day);
        //判断闰年
        if (year % 4 == 0 && year % 100 != 0 /*|| year % 400 == 0*/) {
            months[1] = 29;
        }
        //将数组里的天数相加
        for (int i = 0; i < month - 1; i++) {
            result += months[i];
        }
        //最后加上天数
        result += day;
        System.out.printf("%d", result);
    }

    @Test
    void testNumber() {
        int a = 81;
        int b = 153;
        System.out.printf("最大公因数是%d\n", getGCD(a, b));
        System.out.printf("最小公倍数是%d\n", getLCM(a, b));
    }

    /**
     * 获取公因数
     *
     * @param x int
     * @param y int
     * @return 公因数
     */
    int getGCD(int x, int y) {
        while (x % y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return y;
    }

    /**
     * 公倍数
     *
     * @param x int
     * @param y int
     * @return 公倍数
     */
    int getLCM(int x, int y) {
        int temp = Math.max(x, y);
        while (temp % x != 0 || temp % y != 0) {
            temp++;
        }
        return temp;
    }

    @Test
    void printArray() {
        //定义数组：通过数组元素类型[] 数组名;
        //
        long longArr[] = new long[]{
                30491675, 28347490, 47575954, 383646658, 4947565
        };
        long resoveArr[] = new long[longArr.length];
        int j = 0;
        for (int i = longArr.length - 1; i >= 0; i--) {
            resoveArr[j] = longArr[i];
            j++;
        }
//        for (long l : resoveArr) {
//            System.out.printf("数组反转后是%d\n", l);
//        }
        print(resoveArr);
    }

    void print(long[] arr) {
        for (var item : arr) {
            System.out.printf("%d\t", item);
        }
    }

    @Test
    void printArrayList() {
        StringBuilder sb = new StringBuilder("[");
        int nums[] = {1, 234, 124323, 5, 5, 2, 234};
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i != nums.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    @Test
    void arrayTwo() {
        int nums[][] = new int[11][11];
        nums[0][0] = 5;
        nums[0][1] = 4;
        printArray(nums);
    }

    void printArray(int[][] nums) {
        for (int[] num : nums) {
            for (int i : num) {
                System.out.printf("%-2d\t", i);
            }
            System.out.println();
        }
    }

    @Test
    void testPrice() {
        double totalPrice = getTotalPrice(0.7, 54.2, 321.4, 3245.2);
        System.out.printf("%-2.4f", totalPrice);
    }

    double getTotalPrice(double cutoff, double... prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total * cutoff;
    }

    @Test
    void getFac() {
        long factorial = getFactorial(5);
        System.out.println(factorial);
    }

    long getFactorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return getFactorial(n - 1) * n;
        }
    }

    @Test
    void tetAvg() {
        int nums[][] = {{1, 2, 3}, {4, 5}};
        System.out.println(getAvg(nums));
    }

    int getAvg(int[][] arr) {
        int count = 0;
        int length = 0;
        for (var item : arr) {
            for (var num : item) {
                length++;
                count += num;
            }
        }
        return count / length;
    }

    @Test
    void testPrinf() {
        int nums[] = {23423, 4655647, 8, 0, 0, 345, 0, 0, 0};
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] != 0) {
                str.append(nums[i]);
                str.append(",");
            } else if (nums[i] != 0) {
                str.append(nums[i]);
            }
        }
        if (str.charAt(str.length() - 1) == ',') {
            str.deleteCharAt(str.length() - 1);
        }
        str.append("]");
        System.out.println(str);
    }

    @Test
    void testPalindromes() {
        int num = 21312;
//        Scanner scanner = new Scanner(System.in);
//        int num= scanner.nextInt();
        int gewei = num % 10;
        int shiwei = num % 100 / 10;
        int baiwei = num % 1000 / 100;
        int qianwei = num % 10000 / 1000;
        int waiwei = num % 100000 / 10000;
        if (gewei == waiwei && shiwei == qianwei) {
            System.out.println("回文数");
        } else {
            System.out.println("不是回文数");
        }
        int[] number = getNumber(String.valueOf(num));
    }

    int[] getNumber(String num) {
        int result[] = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            result[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    @Test
    void testDelect() {
        int nums[] = new int[]{11, 22, 22, 22, 22, 22, 33, 44, 22, 55, 22};
//        int[] ints = delectByIndex(nums, 1);
//        System.out.println(Arrays.toString(ints));
        int[] ints = delectByNumber(nums, 22);
        System.out.println(Arrays.toString(ints));
    }

    int[] delectByIndex(int[] arr, int index) {
        for (int i = index; i < arr.length - 1; i++) {
            if (i > index) {
                arr[i] = arr[i + 1];
            }
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    int[] delectByNumber(int[] arr, int target) {
        int count = 0;
        //循环arr
        //把需要删除的元素从后面移到前面
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                arr[i] = arr[i + 1];
                if (arr[i + 1] == -1) {
                    break;
                }
                for (int j = i; j < arr.length; j++) {
                    if (j == arr.length - 1/*|| arr[j+1]==-1*/) {
                        arr[j] = -1;
                    } else {
                        arr[j] = arr[j + 1];
                    }
                    count++;
                }
//                System.out.println(i);
                i--;
                System.out.println(Arrays.toString(arr));
                System.out.printf("循环了%2d次", count);
            }

        }
//        int index = indexOf(arr, target);
//        if (index == -1) return null;
//        for (int i = index; i < arr.length; i++) {
//            if (i == arr.length - 1 || arr[i + 1] == -1) {
//                arr[i] = -1;
//                break;
//            }
//            arr[i] = arr[i + 1];
//        }

        return arr;
    }


    int indexOf(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Test
    void testPrimeNumber() {
        Assertions.assertTrue(isPrimenumber(5));
    }

    boolean isPrimenumber(int number) {
        if (number < 1) return false;
        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    void printPractice() {

    }

    void print() {
        System.out.println("*****************************************");
    }
}
