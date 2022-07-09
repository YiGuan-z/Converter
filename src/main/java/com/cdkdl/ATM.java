package com.cdkdl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private static final Map<String, String> data = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int count = 3;
    private static String name;
    public static String password;

    static {
        data.put("admin", "123");
    }

    public static void main(String[] args) {
        while (true) {
            print();
            input();
            if (login(name, password)) {
                System.out.printf("提示:欢迎%-2s登陆xx很行网页版", name);
                break;
            } else {
                count--;
                if (count == 0) {
                    System.out.println("对不起，您已三次输错密码，请携带xxx到柜台办理");
                    System.exit(0);
                }
                System.out.printf("提示:对不起，您输入的密码有误，还有%d次输入机会\n", count);
            }
        }
    }

    static boolean login(String name, String password) {
        String s = data.get(name);
        return password.equals(s);
    }

    static void input() {
        System.out.print("请输入用户名:\r");
        name = scanner.next();
        System.out.print("请输入密码:\r");
        password = scanner.next();

    }

    static void print() {
        System.out.println("************************");
    }


}
