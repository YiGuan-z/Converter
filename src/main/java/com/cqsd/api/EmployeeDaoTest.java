package com.cqsd.api;

import com.cqsd.annotation.MyAfter;
import com.cqsd.annotation.MyBefore;
import com.cqsd.annotation.MyTest;

public class EmployeeDaoTest {
    @MyBefore
    void init(){
        System.out.println("init");
    }
    @MyAfter
    void destroy(){
        System.out.println("销毁\n");
    }
    @MyTest
    void testSave(){
        System.out.println("保存");
    }
    @MyTest
    void testUpdate(){
        System.out.println("更新");
    }
}
