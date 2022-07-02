package com.cdkdl;

/**
 * 名称
 * 价格
 * 重量
 * 颜色
 * 屏幕尺寸
 * 是否是5G
 */
public class Phone {
    public class Data {
        String name;
        Integer price;
        Integer weight;
        String color;
        Float size;
        boolean fiveg;
    }

    private final Data data;

    public Phone() {
        data = new Data();
    }

    public Phone setName(String name) {
        data.name=name;
        return this;
    }
    public Phone setPrice(int price){
        data.price=price;
        return this;
    }
    public Phone setWeight(int weight){
        data.weight=weight;
        return this;
    }

    public Data build(){
        return data;
    }
}
