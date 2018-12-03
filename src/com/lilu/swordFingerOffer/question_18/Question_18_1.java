package com.lilu.swordFingerOffer.question_18;

/**
 * O(1)时间内删除单链表的节点
 * 给定单链表的头节点和待删除节点
 * 假定待删除节点一定在链表中
 */
public class Question_18_1 {
    public static ListNode deleteNode(ListNode head,ListNode node) {
        if (head == null || node == null) {
            return null;
        }
        // 待删除节点不是尾节点
        if (node.next != null) {
            // 有多个节点的链表，删除中间（不是尾节点）节点
            // 将当前节点的下一个节点的内容（数据域）复制到当前节点
            node.val = node.next.val;
            // 将当前节点的指向下一个节点的指针（指针域）指向当前节点的下一个节点的下一个节点
            node.next = node.next.next;
        } else if (head == node) {
            // 只有一个节点的链表，头节点就是尾节点
            return null;
        } else {
            // 有多个节点的链表，待删除节点是尾节点
            ListNode curNode = head;
            while (node != curNode.next) {
                curNode = curNode.next;
            }
            curNode.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(123);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        System.out.println(deleteNode(head,head).next.val);
    }
}