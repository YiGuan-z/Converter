package com.cqsd.utils;

import org.junit.jupiter.api.Test;

import static com.cqsd.utils.Calcuator.Operator.*;


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
    void main(){
        String expression="3*3+2";
        Calcuator calcuator=new Calcuator();
        int res = calcuator.run(expression);
        System.out.printf("%s=%d\n",expression,res);
        calcuator.print();
    }
}