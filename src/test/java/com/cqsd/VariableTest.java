package com.cqsd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class VariableTest {
    class Strings {

    }

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

}
