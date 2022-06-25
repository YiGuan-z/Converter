package com.cqsd.utils;

import org.junit.jupiter.api.Test;

class ArrayStackTest {
    class Student{
        int age;
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    @Test
    void pushTest(){
        ArrayStack<Integer> stack=new ArrayStack<>(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        stack.push(5);
    }

    @Test
    public void popTest(){
        ArrayStack<Integer> stack = new ArrayStack<>(4);
        stack.push(1);
        stack.push(2);
        stack.print();
        System.out.println("pop 数据：" + stack.pop());
        stack.print();
        System.out.println("pop 数据：" + stack.pop());
        stack.print();
    }
    @Test
    public void stuTest(){
        ArrayStack<Student> stack = new ArrayStack<>(4);
        stack.push(new Student(1,"张三"));
        stack.push(new Student(2,"李四"));
        stack.push(new Student(3,"王五"));
//        stack.print();
        stack.push(new Student(4,"赵六"));
//        stack.print();
        stack.pop();
//        stack.print();
        System.out.printf("栈顶元素：%s\n",stack.peek());
    }

}