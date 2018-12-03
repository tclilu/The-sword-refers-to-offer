package com.lilu.swordFingerOffer.Question_09;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 《剑指offer》
 * 面试题9相关题目：用两个队列来实现一个栈
 */
public class Question_09_02 {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    public void push(int node) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(node);
        }
        if (queue1.isEmpty() && !queue2.isEmpty()) {
            queue2.add(node);
        }
        if (!queue1.isEmpty() && queue2.isEmpty()) {
            queue1.add(node);
        }
    }
    public int pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new RuntimeException("error");
        }
        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            return queue2.remove();
        }
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.remove();
        }
        return (Integer)null;
    }

    public static void test1(Integer a){
        System.out.println("a");
    }
    public static void test1(int b){
        System.out.println("b");
    }
    public static void main(String[] args) {
        // System.out.println((Integer)null);
        test1(1);
    }
}