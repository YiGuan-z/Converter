package com.cdkdl;

import org.junit.jupiter.api.Test;

public class PracticeTest {
    @Test
    void print() {
        int size = 9;
        int n = (size + 1) / 2;
        for (int line = 0; line < n; line++) {
            for (int i = 0; i < (n - line - 1); i++) {
                System.out.print(" ");
            }
            for (int i = 0; i <= line; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        int m = n - 1;
        for (int i = m; i >= 1; i--) {
            for (int j = 0; j < m + 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
