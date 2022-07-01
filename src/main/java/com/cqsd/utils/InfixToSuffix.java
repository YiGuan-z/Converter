package com.cqsd.utils;

public class InfixToSuffix {
    //枚举值 加 减 乘 除
    enum Operaor{
        ADD,SUB,MUL,DIV
    }
    //运算符栈
    private ArrayStack<Operaor> operaorStack=new ArrayStack<>(10);
    //中间结果栈
    private ArrayStack<String> resultStack=new ArrayStack<>(10);

    /**
     * 从左到右扫描中缀表达式
     * 遇到操作数将其压入resultStack
     * 遇到运算符的时候比较它与operaorStack栈顶运算符的优先级
     *  如果operatorStack栈顶为空，活着栈顶运算符为(，则将其压入operatorStack
     *  如果优先级比栈顶运算符高，也将其压入符号栈operatorStack
     *   如果优先级比栈顶运算符底或相等，将operatorStack栈顶运算符弹出并压入resultStack
     * @param expression
     */
    public void scan(String expression){
        int i=0;
        while (i<expression.length()){
            char c = expression.charAt(i);
            if (Character.isDigit(c)){
                resultStack.push(String.valueOf(c));
            }else {

            }

            i++;
        }
    }


    int priority(Operaor operaor){
        switch (operaor){
            case SUB:
            case ADD:
                return 0;
            case MUL:
            case DIV:
                return 1;
            default:
                return -1;
        }
    }





}
