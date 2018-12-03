package com.lilu.swordFingerOffer.Question_09;

import java.util.Stack;

/**
 * 《剑指offer》
 * 面试题9：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Question_09 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 进队列
     * 所有元素全部进入栈1
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 出队列
     * 如果栈2不为空，直接弹出栈2的栈顶元素
     * 如果栈2为空，则将栈1元素依次出栈到栈2，在弹出栈2的栈顶元素
     * @return
     */
    public int pop() {
        // 栈2非空
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        // 栈1，栈2都为空，队列为空
        if (stack1.isEmpty()) {
            throw new RuntimeException("queue empty");
        }
        // 栈2为空,栈1不为空，即队列中有元素
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}