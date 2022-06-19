package com.cqsd.utils.juit;

import com.cqsd.utils.juit.annotation.MyAfter;
import com.cqsd.utils.juit.annotation.MyBefore;
import com.cqsd.utils.juit.annotation.MyTest;

public class EmployeeDaoTest {
    @MyBefore
    void init(){
        System.out.println("init");
    }
    @MyAfter
    void destroy(){
        System.out.println("销毁");
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
