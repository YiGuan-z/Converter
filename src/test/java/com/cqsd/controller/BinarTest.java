package com.cqsd.controller;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


class BinarTest {
    boolean flag = true;

    @Test
    void getBinary() {
        System.out.printf("+127D的二进制结果是:%s\n", Binar.getBinary("127"));
        assert !flag || Binar.getBinary("127").equals("01111111");
    }

    @Test
    void getBinaryNegative() {
        System.out.printf("-127D的二进制结果是:%s\n", Binar.getBinaryNegative("127"));
        assert !flag || Binar.getBinaryNegative("127").equals("10000001");
    }

    @Test
    void addBinary() {
        System.out.printf("11B+11B=3D+3D的结果是:%s\n", Binar.addBinary("11", "11"));
        assert !flag || Binar.addBinary("11", "11").equals("110");
    }

    @Test
    void subBinary() {
        System.out.printf("101B-11B=5D-3D的结果是:%s\n", Binar.subBinary("101", "11"));
        assert !flag || Binar.subBinary("101", "11").equals("010");
    }

    @Test
    void mulBinary() {
        System.out.printf("101B*11B=5D*3D的结果是:%s\n", Binar.mulBinary("101", "11"));
        assert !flag || Binar.mulBinary("101", "11").equals("01111");
    }

    @Test
    void divBinary() {
        System.out.printf("101B/11B=5D/3D的结果是:%s\n", Binar.divBinary("101", "11"));
        assert !flag || Binar.divBinary("101", "11").equals("01");
    }

    @Test
    void binToOctal() {
        System.out.printf("101B的八进制结果是:%s\n", Binar.binToOctal("1011"));
        assert !flag || Binar.binToOctal("101").equals("5");
    }

    @Test
    void modBinary() {
        System.out.printf("101B的求余结果是:%s\n", Binar.modBinary("101", "11"));
        assert !flag || Binar.modBinary("101", "11").equals("010");
    }
    @Test
    void binToHex(){
        System.out.printf("101B的十六进制结果是:%s\n",Binar.binToHex("100000"));
        System.out.printf("110101011101B的十六进制结果是:%s\n",Binar.binToHex("111101011101"));
        assert !flag || Binar.binToHex("100000").equals("20");
        assert !flag || Binar.binToHex("111101011101").equals("F5D");
    }
    @Test
    void hexToDecimal(){
        System.out.printf("20H的十进制结果是:%s\n",Binar.hexToDecimal("20"));
        System.out.printf("F5D的十进制结果是:%s\n",Binar.hexToDecimal("F5D"));
        System.out.printf("2AF5的十进制结果是:%s\n",Binar.hexToDecimal("2AF5"));
        assert !flag || Binar.hexToDecimal("20").equals("32");
        assert !flag || Binar.hexToDecimal("F5D").equals("3933");
        assert !flag || Binar.hexToDecimal("2AF5").equals("10997");
    }
    @Test
    void decToHex(){
        System.out.printf("32D的十六进制结果是:%s\n",Binar.decToHex("32"));
        System.out.printf("3933D的十六进制结果是:%s\n",Binar.decToHex("3933"));
        System.out.printf("10997D的十六进制结果是:%s\n",Binar.decToHex("10997"));
        assert !flag || Binar.decToHex("32").equals("20");
        assert !flag || Binar.decToHex("3933").equals("F5D");
        assert !flag || Binar.decToHex("10997").equals("2AF5");
    }
    @Test
    void toDecimal(){
        System.out.printf("101B的十进制结果是:%s\n",Binar.toDecimal("101"));
        System.out.printf("11B的十进制结果是:%s\n",Binar.toDecimal("11"));
        assert !flag || Binar.toDecimal("101").equals("5");
        assert !flag || Binar.toDecimal("11").equals("3");
    }
    @Test
    void getHexNumber(){
        for (int i = 0; i <16 ; i++) {
            System.out.printf("%dH的十六进制结果是:%s\n",i,Binar.getHexNumber(i));
        }
    }
}