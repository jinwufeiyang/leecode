package com.code.easy.code;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeDepth {

    public static void main(String[] args) {
        /*
        3,9,20,null,null,15,7
         */
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

    /**
     * bfs(广度优先) 层级遍历
     * @param root root
     * @return int
     */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            result++;
            int currentSize = deque.size();
            for (int i=0; i<currentSize; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return result;
    }

}
