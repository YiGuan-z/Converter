package com.cqsd.utils;

import org.junit.jupiter.api.Test;

import static com.cqsd.utils.Operator.*;


class CalculatorTest {
    @Test
    void scanTest() {
        Calculator calculator = new Calculator();
        calculator.scan("1+2*3-4");
        calculator.priority(ADD);
        calculator.priority(DIV);
        calculator.priority(MUL);
        calculator.priority(SUB);
    }

    @Test
    void CalcuatorMain(){
       // String expression="3* 5 + 2* 4-6";
        //修改为逆波兰表达式表达式
//        String expression="3 5 * 2 4 * + 6 -";
        String expression="3 3 * 2 6 * + 4 -";
        Calculator calculator =new Calculator();
        var res = calculator.run(expression);
        System.out.printf("%s=%s\n",expression,res);
        calculator.print();
    }
}