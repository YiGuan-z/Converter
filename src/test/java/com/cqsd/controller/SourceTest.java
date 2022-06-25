package com.cqsd.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SourceTest {
    void demo() {
        String[] language = {
                "java",
                "python",
                "c++",
                "c#",
                "javascript",
                "php",
        };
        List<String> list = Arrays.asList(language);
        list.forEach(System.out::println);
    }

    @Test
    void main() {
//        demo();
        int testFunc = testFunc(5);
        System.out.printf("n=%d",testFunc);
    }

    int testFunc(int n) {
        if (n==1){
            return 1;
        }else {
            return testFunc(n-1)*n;
        }
    }
}
// End of file