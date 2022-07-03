package com.cdkdl;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

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
    //TODO day3作业

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
                90, 78, 4, 5, 345
        };
        int index = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        print();
        while (index < testNumber.length) {
            if (testNumber[index] > max) {
                max = testNumber[index];
            }
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
    void drap() {
        var sb = new StringBuilder();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                sb.append("*");
            }
            sb.append("\n");
            System.out.println(sb);
        }
    }

    void print() {
        System.out.println("*****************************************");
    }
}
