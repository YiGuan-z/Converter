package com.cqsd.api;

import java.lang.reflect.InvocationTargetException;

public class JunitTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        MyFunctionInterface myFunctionInterface = () -> {
            MyJunitFrameWork frameWork = new MyJunitFrameWork(EmployeeDaoTest.class);
            frameWork.run();
        };
        myFunctionInterface.method();
    }
}
