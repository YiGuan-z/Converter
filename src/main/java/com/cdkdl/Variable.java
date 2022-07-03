package com.cdkdl;

import java.util.Scanner;
import static java.lang.System.*;
public class Variable {
    public static void main(String[] args) {
        /**
         * [0,5)无等级
         * [5,12)*
         * [12,21)**
         * [21,32)***
         * [32,~) 🌛
         */
        var sc = new Scanner(in);
        System.out.println("请输入等级：");
        int level = sc.nextInt();
        if (level>=0&&level<5){
            out.println("???");
        } else if (level >= 5 && level < 12) {
            out.println("🌟");
        } else if (level >= 12 && level < 21) {
            out.println("🌟🌟");
        } else if (level >= 21 && level < 32) {
            out.println("🌟🌟🌟");
        }else {
            out.println("🌛");
        }
    }


//    static void swap(int num1, int num2) {
//        int temp=num1;
//        num1=num2;
//        num2=temp;
//    }

}
