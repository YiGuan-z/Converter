package com.cqsd.controller;

import com.cqsd.utils.JsonEntry;

public class Student {
    @JsonEntry("user")
    private final String name;
    @JsonEntry("age")
    private final Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
