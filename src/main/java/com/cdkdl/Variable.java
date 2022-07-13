package com.cdkdl;

import static java.lang.System.in;
import static java.lang.System.out;

public class Variable {
    int[][] sanjiao = new int[5][5];

    void create() {
        for (int line = 0; line < sanjiao.length; line++) {
            for (int row = 0; row <= line; row++) {
                if (row == 0 || row == line) {
                    sanjiao[line][row] = 1;
                } else {
                    sanjiao[line][row] = sanjiao[line - 1][row - 1] + sanjiao[line - 1][row];
                }
                out.printf("%-3d", sanjiao[line][row]);
            }
            out.println();
        }
    }

    void draw() {
        for (int i = 0; i < sanjiao.length; i++) {
            //从4递减
            for (int j = 0; j < sanjiao.length - 1 - i; j++) {
                out.print(" ");
            }
            //输出一个数字加一个空格
            for (int j = 0; j <= i; j++) {
                out.print(sanjiao[i][j] + " ");
            }
            //换行
            out.println();
        }

    }

    void test(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (count == 2) {
                    return;
                } else {
                    if (arr[i] + arr[j] == 14) {
                        out.println(arr[i] + "+" + arr[j] + "=" +( arr[i] + arr[j]));
                        count++;
                    }
                }
            }
        }
    }
}
