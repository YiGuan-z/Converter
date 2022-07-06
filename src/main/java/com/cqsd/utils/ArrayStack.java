package com.cqsd.utils;

import java.util.Stack;

public class ArrayStack<V> extends Stack<V> {
    /*------------------------Fields------------------------*/
    int size;
    int maxSize;
    Node<V> top;

    /*------------------------Constructor------------------------*/
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
    }

    /* ---------------- Public operations -------------- */
    public boolean isFull() {
        return size == maxSize;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V push(V value) {
        if (isFull()) {
            System.out.println("stack is full");
            return value;
        }
//        stact[++top]=value;
        Node<V> temp = top;
        top = new Node<>(value);
        top.next = temp;
        size++;
        return value;
    }

    public V pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈中无数据");
        }
        Node<V> temp = top;
        top = temp.next;
        size--;
        return temp.value;
    }

    public V peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈中无数据");
        }
        return top.value;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        Node<V> cur = top;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

    public void reverse() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        Node<V> cur = top.next;
        Node<V> pre;
        Node<V> reverseHead = new Node<>(top.value);
        while (cur != null) {
            pre = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = pre;
        }
        top.next = reverseHead.next;
    }

    /*--------------------Static Class--------------------*/
    static class Node<V> {
        V value;
        Node<V> next;
//        Node<V> previous;

        public Node(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

}