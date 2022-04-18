package com.cqsd.api;

import com.cqsd.annotation.MyAfter;
import com.cqsd.annotation.MyBefore;
import com.cqsd.annotation.MyTest;

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
    public void run() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        var method = clazz.getDeclaredConstructor().newInstance();
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
//                System.out.println(Info.VERSION);
                before.invoke(method);
            }
            test.invoke(method);
            for (Method after : afterList) {
                after.invoke(method);
            }
        }
    }
}
