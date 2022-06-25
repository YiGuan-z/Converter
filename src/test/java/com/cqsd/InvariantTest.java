package com.cqsd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InvariantTest {
    //只要是继承了Number的类都可以写入
    //去找Number的儿子
    void testNumber(List<? extends Number> numbers) {
        numbers.forEach(System.out::println);
    }
    //只要Integer里有实现该类就能使用
    //可以放Integer的爹
    void testNumbers(List<? super Integer> numbers) {
        numbers.forEach(System.out::println);
    }

    @Test
    void main() {
        final List<Double> lists = new ArrayList<>();
        lists.add(2.0);
        lists.add(2.1);
        lists.add(2.2);
        lists.add(2.3);
        lists.add(2.4);
        this.testNumber(lists);
        final List<Number> list=new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        testNumbers(list);
    }


}
