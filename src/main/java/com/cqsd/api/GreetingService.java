package com.cqsd.api;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
public interface GreetingService {
    // 1.定义一个接口方法 需要传入一个String字符串
    void sayGreeting(String message);
}
class test{
    public static void main(String[] args) {
        // 2.创建一个GreetingService接口的实现类
        GreetingService greetingService = message -> {
            System.out.println(message.charAt(0));
            final char[] chars = message.toCharArray();
            for (char aChar : chars) {
                System.out.println(aChar);
            }
        };
        // 3.调用接口方法
        greetingService.sayGreeting("Hello");
        greetingService=message -> {
            List<String> list= List.of(message);
            list.forEach(System.out::println);
        };
        greetingService.sayGreeting("Hello");
    }
}
