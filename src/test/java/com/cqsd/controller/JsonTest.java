package com.cqsd.controller;

import com.cqsd.utils.JsonEntry;
import com.cqsd.utils.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class JsonTest {
    JsonObject json = new JsonObject(new HashMap<>());

     static class Student {
        @JsonEntry("name")
        String name;
        @JsonEntry("age")
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    @BeforeEach
    void atrer() {
        //找到这些注解，然后把它们转换成json
        Student[] students = new Student[]{
                new Student("张三", 18),
                new Student("李四", 19),
                new Student("王武", 20),
        };
        String jsonObj[] = {"Java", "C++", "Python", "Object-C"};
        json.put("name", "cqsd");
        json.put("age", 18);
        json.put("hobbies", jsonObj);
//        json.put("students", students);
    }

    @Test
    void JsonTestPrint() {
        System.out.println(json);
    }
}
