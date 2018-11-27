package com.lilu.swordFingerOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 《剑指offer》
 * 面试题6：输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Question_06 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 分析：使用栈，先进后出
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 创建私有arrayList
     */
    private static ArrayList<Integer> arrayList = new ArrayList<>();

    /**
     * 方法二：
     * 利用递归实现栈
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHeadByRecursion(ListNode listNode) {
        if (listNode == null) {
            return arrayList;
        }
        printListFromTailToHeadByRecursion(listNode.next);
        arrayList.add(listNode.val);
        return arrayList;
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        //要想直接创建内部类的对象,必须使用外部类的对象来创建内部类对象
        ListNode listNode = new Question_06().new ListNode(10);
        System.out.println(printListFromTailToHeadByRecursion(listNode));
    }
}
