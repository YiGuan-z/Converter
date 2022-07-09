package com.cqsd.controller;

import com.cqsd.utils.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class JsonTest {
    JsonObject json = new JsonObject(new HashMap<>());


    @BeforeEach
    void atrer() {
        Thread thread = new Thread(this::JsonTestPrint);
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
        json.put("爷爷", "大爷");
        json.toJSONString("student", new Student("王武", 23));
        json.toJSONString("students", students);
        thread.start();

    }

    @Test
    void JsonTestPrint() {
        System.out.println(json);
    }
}
