package com.cqsd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class VariableTest {
    @Test
    void test() {
        byte c = 9;
        System.out.println("c = " + c);
        short s = 90;
        System.out.println("s = " + s);
        int i = 39;
        System.out.println("i = " + i);
        long l = 3999L;
        System.out.println("l = " + l);
        float f = 39.95f;
        System.out.println("f = " + f);
        double d = 93947.3243;
        System.out.println("d = " + d);
        char c1 = 'c';
        System.out.println("c1 = " + c1);
        boolean b = true;
        System.out.println("b = " + b);
        String str = "你好师姐";
        System.out.println("str = " + str);

        char chars[][] = new char[][]{
                new char[]{
                        '你', '我'
                },
                new char[]{
                        '他', '这'
                }
        };
        System.out.println(Arrays.deepToString(chars));
    }

    @Test
    void testPrint() {
        int[] arr = new int[]{
                23, 12, 3213, 4
        };
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.print(sb);
    }

    @Test
    void getAverage() {
        int num[] = new int[]{124, 324, 53, 6457, 58, 9};
        System.out.printf("平均数是%-2f", average(num));
    }

    double average(int[] nums) {
        double count = 0;
        for (var item : nums) {
            count += item;
        }
        return count / nums.length;
    }
}
