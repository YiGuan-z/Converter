package com.cqsd.controller;

import com.cqsd.utils.JsonEntry;

public class Student {
    @JsonEntry("用户名")
    private String name;
    @JsonEntry("年龄")
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name:'").append(name).append('\'');
        sb.append(", age:").append(age);
        sb.append('}');
        return sb.toString();
    }
}
