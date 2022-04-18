package com.cqsd.api;

import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
public interface MyFunctionInterface {
    void method() throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException;
    default void exec(){
        System.out.println("exec");
    }
}
