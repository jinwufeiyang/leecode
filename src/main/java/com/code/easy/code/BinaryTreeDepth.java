package com.code.easy.code;

public class BinaryTreeDepth {

    public static void main(String[] args) {
        System.out.println(depth(TreeNode.builder().build()));
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int ll = depth(node.left);
            int rl = depth(node.right);
            return Math.max(ll, rl) + 1;
        }
    }
}
