package com.lilu.swordFingerOffer;

/**
 * 《剑指offer》
 * 面试题7：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Question_08 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 分析：
     * 1.二叉树为空，返回空。
     * 2.节点右子节点存在，则设置一个指针从该节点的右子节点出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
     * 3.节点不是根节点，如果该节点是父节点的左子节点，则下一个节点为父节点。
     *   如果该节点是父节点的右子节点，
     *   则找它的父节点的父节点的父节点...直到当前节点是其父节点的左子节点。下一节点是其父节点。
     *   如果没有，则为尾节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 1.二叉树为空
        if (pNode == null) {
            return null;
        }
        // 节点右子节点存在，下一节点为最左子节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 节点不是根节点
        while (pNode.next != null) {
            // 该节点是父节点的左子节点，下一节点为父节点。
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            // 该节点是父节点的右子节点
            pNode = pNode.next;
        }
        // 没找到下一节点，为尾节点。
        return null;
    }
}
