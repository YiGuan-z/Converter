package com.cdkdl;

import org.junit.jupiter.api.Test;

class VariableTest {

    @Test
    void draw() {
        var sanjiao=new Variable();
        sanjiao.create();
        sanjiao.draw();
    }

    @Test
    void test1() {
        int [] arr={13,1,12,2};
        var suanshu=new Variable();
        suanshu.test(arr);
    }
}