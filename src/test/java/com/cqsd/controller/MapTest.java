package com.cqsd.controller;

import com.cqsd.utils.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MapTest {
    static class Student {
        String name;
        Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Test
    void testInsertAndPrint() {
        Map<Integer, Student> map = new LinkedList<>();
        map.put(1, new Student("张三", 18));
        map.put(5, new Student("李s", 16));
        map.put(2, new Student("李四", 19));
        map.forEach((k, v) -> System.out.printf("id is %d name is %s age is %d\n", k, v.name, v.age));
    }
    @Test
    void testRemove(){
        Map<Integer, Student> map = new LinkedList<>();
        map.put(1, new Student("张三", 18));
        map.put(5, new Student("李s", 16));
        map.put(2, new Student("李四", 19));
        map.forEach((k, v) -> System.out.printf("id is %d name is %s age is %d\n", k, v.name, v.age));
        System.out.printf("size is %d\n", map.keySet().size());
        map.keySet().forEach(System.out::println);
        System.out.println("remove 2");
        map.remove(2);
        map.forEach((k, v) -> System.err.printf("id is %d name is %s age is %d\n", k, v.name, v.age));
        System.out.println("replace 张三 with 李四");
        map.replace(1, new Student("李四", 19));
        map.forEach((k, v) -> System.err.printf("id is %d name is %s age is %d\n", k, v.name, v.age));

    }

}
