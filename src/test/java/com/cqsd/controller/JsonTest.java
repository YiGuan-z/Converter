package com.cqsd.controller;

import com.cqsd.utils.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class JsonTest {
    JsonObject json=new JsonObject(new HashMap<>());
    @BeforeEach
    void atrer(){
        String jsonObj[]={"Java","C++","Python","Object-C"};
        json.put("name","cqsd");
        json.put("age",18);
        json.put("hobbies",jsonObj);
    }

    @Test
    void JsonTestPrint(){
        System.out.println(json);
    }
}
