package com.cdkdl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shopping {
    static class Shop {
        Double price;
        Integer count;

        public Shop(Double price, Integer count) {
            this.price = price;
            this.count = count;
        }
    }

    private static final Scanner sc = new Scanner(System.in);
    private static final Map<String, Shop> data = new HashMap<>();

    static {
        data.put("iphoneSE", new Shop(3000.00, 12));
    }

    public static void main(String[] args) {
        back:
        while (true) {
            select:
            switch (print_()) {
                case 1:
                    list();
                    break select;
                case 2:
                    input();
                    break select;
                case 3:
                    Change();
                    break select;
                case 0:
                    break back;
            }
        }
    }


    static int print_() {
        System.out.print("****************************\n");
        System.out.print("************菜单*************\n");
        System.out.print("1.显示所有\n");
        System.out.print("2.添加数据\n");
        System.out.print("3.修改数据\n");
        System.out.print("0.退出系统\n");
        System.out.print("****************************\n");
        return sc.nextInt();
    }

    private static void Change() {
        //请输入需要修改的商品名
        while (true) {
            Shop shop;
            re:
            {
                System.out.println("请输入需要修改的商品名:");
                String key = sc.next();
                shop = data.get(key);
                if (shop == null) {
                    System.out.println("请重新输入:");
                    break re;
                }
            }
            if (shop!=null){
                System.out.println("请输入价格");
                shop.price= sc.nextDouble();
            }

        }

    }

    static void list() {
        if (data.isEmpty()) {
            System.out.println("当前没有数据");
            return;
        }
        data.forEach((k, v) -> {
            System.out.printf("商品名称%s,价格为%.2f,数量为%d\n", k, v.price, v.count);
        });
    }

    static void input() {
        while (true) {
            int size = data.size();
            System.out.printf("请键入第%d个数据,键入0退出", size);
            System.out.println("请键入名称");
            String str = sc.next();
            System.out.println("请键入价格");
            double price = sc.nextDouble();
            System.out.println("请键入数量");
            int count = sc.nextInt();
            var item = new Shop(price, count);
            data.put(str, item);
            System.out.println("是否继续?\n y or n");
            String s = sc.next();
            if (s.equals("n")) {
                break;
            }
        }


    }


}
