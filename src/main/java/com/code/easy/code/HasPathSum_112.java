package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: HasPathSum_112
 * @Description:
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * @Author: JW
 * @Date: 2019/12/26 23:29
 */
public class HasPathSum_112 {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            return hasNodePath(root, sum, 0);
        }
    }

    /**
     * 方法1，求加法  递归实现
     * @param root 根节点
     * @param sum 目标和
     * @param currentSum 当前节点到根节点路径上总和
     * @return boolean
     */
    private static boolean hasNodePath(TreeNode root, int sum, int currentSum) {

        if (root == null) {
            return false;
        } else {
            if (root.right != null || root.left != null) {
                boolean result1 = hasNodePath(root.left, sum, currentSum + root.val);
                boolean result2 = hasNodePath(root.right, sum, currentSum + root.val);
                if (result1 || result2) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return ((currentSum + root.val) == sum);
            }
        }
    }

    public static void main(String[] args) {

    }


    /**
     * 方式2，求减法  递归实现
     * @param root 根节点
     * @param sum 当前节点所剩总和
     * @return boolean
     */
    public static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right ==  null && root.val == sum) {
            return true;
        }
        return hasPathSum2(root.left, sum-root.val) || hasPathSum2(root.right, sum-root.val);
    }

}
