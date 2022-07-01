package com.cqsd.utils;

import org.junit.jupiter.api.Test;

import static com.cqsd.utils.Operator.*;


class CalcuatorTest {
    @Test
    void scanTest() {
        Calcuator calcuator = new Calcuator();
        calcuator.scan("1+2*3-4");
        calcuator.priority(ADD);
        calcuator.priority(DIV);
        calcuator.priority(MUL);
        calcuator.priority(SUB);
    }

    @Test
    void CalcuatorMain(){
       // String expression="3* 5 + 2* 4-6";
        //修改为逆波兰表达式表达式
//        String expression="3 5 * 2 4 * + 6 -";
        String expression="3 3 * 2 6 * + 4 -";
        Calcuator calcuator=new Calcuator();
        int res = calcuator.run(expression);
        System.out.printf("%s=%d\n",expression,res);
        calcuator.print();
    }
}