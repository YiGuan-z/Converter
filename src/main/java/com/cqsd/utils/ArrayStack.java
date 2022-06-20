package com.cqsd.utils;

public class ArrayStack<V> {
//    int [] stact;
    /*------------------------Fields------------------------*/
    V [] stact;
    int maxSize;
    int top=-1;

    /*------------------------Constructor------------------------*/
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        if (maxSize>0){
            stact= (V[]) new Object[maxSize];
        }
    }
    /* ---------------- Public operations -------------- */
    public boolean isFull(){
        return maxSize -1==top;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void push(V value){
        if(isFull()){
            System.out.println("stack is full");
            return;
        }
        stact[++top]=value;
    }

    public V pop(){
        if(isEmpty()){
            throw new RuntimeException("栈中无数据");
        }
        return stact[top--];
    }

    public void print(){
        if (isEmpty()){
            System.out.println("stack is empty");
            return;
        }
        for (int i =top; i >=0 ; i--) {
            System.out.printf("index:%d value:%s\n",i,stact[i]);
        }
    }

    /*--------------------Static Class--------------------*/
//    class Node<V>{
//        V value;
//        Node<V> next;
//        Node<V> previous;
//
//        public Node(V value) {
//            this.value = value;
//        }
//
//        public String toString() {
//            return "Node{" +
//                    "value=" + value +
//                    ", next=" + next +
//                    ", previous=" + previous +
//                    '}';
//        }
//    }

}
