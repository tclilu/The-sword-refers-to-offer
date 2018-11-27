package com.lilu.swordFingerOffer;

/**
 *《剑指offer》
 * 面试题7：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */
public class Question_07 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    /**
     * 分析：先序遍历序列第0位置元素为根节点，
     * 在中续遍历序列中，根节点左边的为左子树中序遍历序列，根节点右边的为右子树中序遍历
     * 于是可以得到左子树和右子树序列长度
     * 在先序遍历序列中，根据长度得到左子树和右子树的先序遍历序列，其对应第0位置元素分别为左右子树根节点
     * 再根据左右子树根节点去中序遍历序列中找到左右子树的左右子树
     * 重复上述过程
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        // 合法性检验
        if (pre == null || in == null || pre.length != in.length || pre.length < 1) {
            return null;
        }
        return reConstructBinaryTree(pre,0,pre.length - 1,in,0,in.length - 1);
    }

    /**
     * @param pre 先序遍历序列    例如 {1,2,4,7,3,5,6,8}
     * @param startPre 先序遍历开始位置
     * @param endPre 先序遍历结束位置
     * @param in 中序遍历序列     例如 {4,7,2,1,5,3,8,6}
     * @param startIn 中序遍历开始位置
     * @param endIn 中序遍历结束位置
     * @return
     */
    private static TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn) {
        // 遍历序列结束位置一定大于等于开始序列，等于时为叶子节点
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        // 先序遍历开始位置元素为二叉树根节点
        TreeNode root = new Question_07().new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            // 找到根节点在中序遍历中的位置
            if (in[i] == pre[startPre]) {
                // 对左右子树重复过程
                root.left = reConstructBinaryTree(pre,startPre + 1,i - startIn + startPre,in,startIn,i - 1);
                root.right = reConstructBinaryTree(pre,i - startIn + startPre + 1,endPre,in,i + 1,endIn);
                break;
            }
        }
        return root;
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(reConstructBinaryTree(new int[] {1,2,4,7,3,5,6,8}, new int[] {4,7,2,1,5,3,8,6}));
    }
}
