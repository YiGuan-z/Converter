package com.cqsd.utils;

import static com.cqsd.utils.Operator.*;

public class Calcuator {

    //数字栈
    private final ArrayStack<Integer> numStack = new ArrayStack<>(10);
    //符号栈
    private final ArrayStack<Operator> opStack = new ArrayStack<>(10);

    //扫描器
    void scan(String expression) {
        int index = 0;
        while (index < expression.length()) {
            char c = expression.charAt(index);
            //是否是空格 空格匹配为true
            if (!Character.isSpaceChar(c)) {
                //是否为数字 数字匹配为true
                if (Character.isDigit(c)) {
                    //从char中获取数字
                    Integer num = Character.getNumericValue(c);
                    //数字直接入栈
                    numStack.push(num);
                } else {
                    //如果符号栈为空，直接入栈
                    if (opStack.isEmpty()) {
                        opStack.push(isOper(c));
                    }
                    //如果当前操作符大于栈顶符号，将当前操作符入栈
                    //
                    var currentOper = isOper(c);
                    assert currentOper != null;
                    //如果当前是* 栈顶是+ 那么就先入符号栈
                    if (priority(currentOper) > priority(opStack.peek())) {
                        opStack.push(currentOper);
                        continue;
                    }
                    //这里或许不应该判断是否为乘除
                    //if (opStack.peek() == DIV || opStack.peek() == MUL) {
                    //这里计算有问题，拿到了乘除没拿到下一个数字，例如"3+4*5-6的时候3 + 4 入栈 一扫描到*就立即对3和2计算
                    //不过好像可以对逆波兰表达式进行计算
                    //逆波兰表达式也不行，例如3 4 + 5 * 6 -的时候4和5遇上乘法也是直接对4 5 进行求值
                    Integer p1 = numStack.pop();
                    Integer p2 = numStack.pop();
                    Operator pop = opStack.pop();
                    int cal = cal(p1, p2, pop);
                    numStack.push(cal);
                    //} else {
                    //计算3 5 * 2 4 * + 6 -的时候加号多入一次
                    //opStack.push(currentOper);
                    //}
                }
            }
            index++;
        }
    }

    /**
     * 根据符号返回操作符
     *
     * @param c char [+,-,*,/]
     * @return Operator
     */
    private Operator isOper(char c) {
        switch (c) {
            case '+':
                return ADD;
            case '-':
                return SUB;
            case '*':
                return MUL;
            case '/':
                return DIV;
            default:
                return null;
        }
    }

    /**
     * 这里通过运算符计算表达式
     *
     * @param num1 数字1
     * @param num2 数字2
     * @param oper 操作符
     * @return 表达式计算结果
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

    /**
     * 运算符优先级
     * 乘除法运算优先级为1 加减法优先级为0 其它为-1
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
                return 0;
            default:
                return -1;
        }
    }

    /**
     * 还是有Bug，没有考虑到运算符优先级
     * 开始计算
     *
     * @param expression 表达式
     * @return 计算结果
     */
    public int run(String expression) {
        scan(expression);
        while (numStack.size > 1) {
            Operator oper = opStack.pop();
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            //这里是乘除 怎么先算乘除啊！！！
            numStack.push(cal(num1, num2, oper));
        }
        return numStack.pop();
    }

    /**
     * 打印栈存储，如果有值就代表没计算完
     */
    public void print() {
        System.out.println("---------------------");
        System.out.println("符号栈");
        opStack.print();
        System.out.println("---------------------");
        System.out.println("数字栈");
        numStack.print();
    }
}
