package com.cdkdl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {
    @Test
    void testBuild() {
        Phone.Data phone = new Phone()
                .setName("苹果")
                .setPrice(3000)
                .setWeight(5)
                .setColor("Red")
                .setFiveg(true)
                .setSize(5.7f)
                .build();
        System.out.printf("这个手机的信息是%s", phone);
    }
}