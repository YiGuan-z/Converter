package com.cqsd.controller;

import com.cqsd.api.MyFunctionInterface;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class MyTest {
    void demo(MyFunctionInterface myFunctionInterface) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        myFunctionInterface.method();
//        myFunctionInterface.exec();
    }
    @Test
    void exec() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        demo(() -> System.out.println("Hello World"));
        demo(new MyFunctionInterface() {
            @Override
            public void method() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
                System.out.println("Hello World");
            }
        });
        Object o=new Object();
        o="卧槽";
    }
}
