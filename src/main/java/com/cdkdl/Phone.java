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

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("phone:{");
            sb.append("name='").append(name).append('\'');
            sb.append(", price=").append(price);
            sb.append(", weight=").append(weight);
            sb.append(", color='").append(color).append('\'');
            sb.append(", size=").append(size);
            sb.append(", fiveg=").append(fiveg);
            sb.append('}');
            return sb.toString();
        }
    }

    private final Data data;

    public Phone() {
        data = new Data();
    }

    public Phone setName(String name) {
        data.name = name;
        return this;
    }

    public Phone setPrice(int price) {
        data.price = price;
        return this;
    }

    public Phone setWeight(int weight) {
        data.weight = weight;
        return this;
    }

    public Phone setColor(String color) {
        data.color = color;
        return this;
    }

    public Phone setFiveg(boolean fiveg) {
        data.fiveg = fiveg;
        return this;
    }

    public Phone setSize(Float size) {
        data.size = size;
        return this;
    }


    public Data build() {
        return data;
    }
}
