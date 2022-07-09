package com.cdkdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Power2 {
    @Test
    void testRepetition() {
        assertFalse(isRepetition(1, 2, 3, 4, 5));
        assertTrue(isRepetition(1, 2, 3, 4, 1));
    }

    //这里判断元素是否重复
    boolean isRepetition(int... arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return true;
            }
        }
        return false;
    }

    int hash(Object o) {
        return Objects.hash(o) ^ Objects.hash(o);
    }
}
