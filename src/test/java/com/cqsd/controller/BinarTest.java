package com.cqsd.controller;

import org.junit.jupiter.api.Test;


class BinarTest {

    @Test
    void getBinary() {
        System.out.printf("+127D的二进制结果是:%s\n",Binar.getBinary("127"));
        assert Binar.getBinary("127").equals("01111111");
    }

    @Test
    void getBinaryNegative() {
        System.out.printf("-127D的二进制结果是:%s\n", Binar.getBinaryNegative("127"));
        assert Binar.getBinaryNegative("127").equals("10000001");
    }

    @Test
    void addBinary() {
        System.out.printf("11B+11B=3D+3D的结果是:%s\n", Binar.addBinary("11", "11"));
        assert Binar.addBinary("11", "11").equals("110");
    }

    @Test
    void subBinary() {
        System.out.printf("101B+11B=5D+3D的结果是:%s\n", Binar.subBinary("101", "11"));
        assert Binar.subBinary("101", "11").equals("010");
    }

    @Test
    void mulBinary() {
        System.out.printf("101B*11B=5D*3D的结果是:%s\n", Binar.mulBinary("101", "11"));
        assert Binar.mulBinary("101", "11").equals("1111");
    }

//    @Test
    void divBinary() {
    }
}