package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: BalanceTreeIs_110
 * @Description: 给定二叉树是否是高度平衡的二叉树
 * @Author: JW
 * @Date: 2019/12/25 22:13
 */
public class BalanceTreeIs_110 {
    public static boolean isBalanced(TreeNode root) {
        return balanceTree(root);
    }

    private static boolean balanceTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root) > 0;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (lh >= 0 && rh >= 0 && Math.abs(lh-rh) < 2) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(isBalanced(TreeNode.builder().build()));
    }

    /*
    方式2 暴力方式
     */
    public static boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height2(root.left) - height2(root.right)) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
    }

    private static int height2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height2(node.left), height2(node.right)) + 1;
    }


}
