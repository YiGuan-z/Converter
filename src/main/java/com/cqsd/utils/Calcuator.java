package com.cqsd.utils;

import static com.cqsd.utils.Calcuator.Operator.*;

public class Calcuator {
    enum Operator {
        ADD, SUB, MUL, DIV
    }

    private final ArrayStack<Integer> numStack = new ArrayStack<>(10);
    private final ArrayStack<Operator> opStack = new ArrayStack<>(10);

    void scan(String expression) {
        int index = 0;
        while (index < expression.length()) {
            char c = expression.charAt(index);
            if (Character.isDigit(c)) {
                int num = Character.getNumericValue(c);
                numStack.push(num);
            } else {
                switch (c) {
                    case '+':
                        opStack.push(ADD);
                        break;
                    case '-':
                        opStack.push(SUB);
                        break;
                    case '*':
                        opStack.push(MUL);
                        break;
                    case '/':
                        opStack.push(DIV);
                        break;
                }
            }
            index++;
        }
    }

    /**
     * 运算符优先级
     *
     * @param op 运算符
     * @return 优先级
     */
    int priority(Operator op) {
        switch (op) {
            case MUL:
            case DIV:
                return 1;
            case ADD:
            case SUB:
            default:
                return 0;
        }
    }

    /**
     * 还是有Bug，没有考虑到运算符优先级
     *
     * @param expression
     * @return
     */
    public int run(String expression) {
        scan(expression);
        while (numStack.size > 1) {

            Operator oper = opStack.pop();
            if (priority(oper) > priority(opStack.peek())) {
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                //这里是乘除 怎么先算乘除啊！！！
                numStack.push(cal(num1, num2, oper));
            } else {
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                //这里算加减
                numStack.push(cal(num1, num2, oper));
            }
        }
        return numStack.pop();
    }

    /**
     * 需要在这里实现运算逻辑，乘除先，后加减
     *
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    int cal(int num1, int num2, Operator oper) {
        switch (oper) {
            case MUL:
                return num1 * num2;
            case DIV:
                return num1 / num2;
            case ADD:
                return num1 + num2;
            case SUB:
                return num1 - num2;
            default:
                return 0;
        }
    }

    int nextCal() {
        System.out.println("符号栈");
        opStack.print();
        while (!opStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            Operator oper = opStack.pop();
            int res = cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println("数字栈");
        numStack.print();
        return numStack.pop();
    }

    public void print() {
        System.out.println("符号栈");
        opStack.print();
        System.out.println("数字栈");
        numStack.print();
    }
}
