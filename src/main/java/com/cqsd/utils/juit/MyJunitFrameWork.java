package com.cqsd.utils.juit;

import com.cqsd.utils.juit.annotation.MyAfter;
import com.cqsd.utils.juit.annotation.MyBefore;
import com.cqsd.utils.juit.annotation.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyJunitFrameWork {
    //测试类
    private final Class<?> clazz;

    public MyJunitFrameWork(final Class<?> cla) {
        this.clazz = cla;
    }

    //执行测试
    public void run() {
        Object method;
        try {
            method = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> beforeList = new ArrayList<>();
        List<Method> afterList = new ArrayList<>();
        List<Method> testList = new ArrayList<>();

        for (Method m : methods) {
            if (m.isAnnotationPresent(MyBefore.class))
                beforeList.add(m);
            else if (m.isAnnotationPresent(MyAfter.class))
                afterList.add(m);
            else if (m.isAnnotationPresent(MyTest.class))
                testList.add(m);
        }
        for (Method test : testList) {
            for (Method before : beforeList) {
                beforeFunc(before,method);
            }
            testFunc(test,method);
            for (Method after : afterList) {
                afterFunc(after,method);
            }
        }
    }
    void beforeFunc(Method before, Object method){
        try {
            before.invoke(method);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    void testFunc(Method test, Object method){
        try {
            test.invoke(method);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    void afterFunc(Method after, Object method){
        try {
            after.invoke(method);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
