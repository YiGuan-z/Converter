package com.cdkdl;

public class Variable {
    public static void main(String[] args) {
        int c=0/10;
        System.out.printf("c=%s",c);
        //给定47天，计算共有多少月和多少天
        int days=47;
        int month,day;
        month=days/30;
        day=days%30;
        System.out.printf("%d天里面有%d月%d天",days,month,day);

    }

//    static void swap(int num1, int num2) {
//        int temp=num1;
//        num1=num2;
//        num2=temp;
//    }

}
