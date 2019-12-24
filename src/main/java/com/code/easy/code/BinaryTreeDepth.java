package com.code.easy.code;

public class BinaryTreeDepth {

    public static void main(String[] args) {
        System.out.println(depth(TreeNode.builder().build()));
    }

    /**
     * 递归实现二叉树深度
     * 时间复杂度O(n)
     * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
     * @param node root
     * @return int
     */
    private static int depth(TreeNode node) {
        //递归退出条件，到叶子节点
        if (node == null) {
            return 0;
        } else {
            //计算左子树最大深度
            int ll = depth(node.left);
            //计算右子树最大深度
            int rl = depth(node.right);
            //以某个节点为根节点的数的最大深度为max
            return Math.max(ll, rl) + 1;
        }
    }
}
