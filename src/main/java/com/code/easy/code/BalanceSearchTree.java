package com.code.easy.code;

import java.util.Objects;

/**
 * @version v1.0
 * @ClassName: BalanceSearchTree
 * @Description: 平衡二叉搜索树
 * @Author: JW
 * @Date: 2019/12/24 21:31
 */
public class BalanceSearchTree {

    TreeNode root;

    /**
     * 有序数组转换为高度平衡二叉搜索树
     * 一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * @param nums 有序数组
     * @return tree
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return root;
        } else {
            for (int i=0; i<length; i++) {
                root = insertNode(root, nums[i]);
            }
        }
        return root;
    }

    /**
     * 插入操作
     * @param root 根节点
     * @param value 当前节点值
     * @return 返回节点
     */
    private TreeNode insertNode(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value, null, null);
        } else {
             if (root.val > value) {
                root.left = insertNode(root.left, value);
            } else {
                root.right = insertNode(root.right, value);
            }
            //调整树高度
            int result = heightDifference(root);
            if (result > 1) {
                //右旋
                root = yx(root);
            }
            if (result < -1) {
                //左旋
                root = zx(root);
            }
        }
        return root;
    }

    /**
     * 左旋操作
     * @param root 当前需要调整的根节点
     * @return 调整后的新根节点
     */
    private TreeNode zx(TreeNode root) {
        TreeNode right = root.right;
        if (right.left != null) {
            root.right = right.left;
        } else {
            root.right = null;
        }
        right.left = root;
        return right;
    }

    /**
     * 右旋操作
     * @param root 当前需要调整的根节点
     * @return 调整后的新根节点
     */
    private TreeNode yx(TreeNode root) {
        TreeNode left = root.left;
        if (left.right != null) {
            root.left = left.right;
        } else {
            root.left = null;
        }
        left.right = root;
        return left;
    }

    /**
     * 当前节点的左右子树高度差
     * @param root 当前节点
     * @return 高度差
     */
    private int heightDifference(TreeNode root) {
        int lh = depth(root.left);
        int rh = depth(root.right);
        return lh - rh;
    }

    /**
     * 当前节点的深度
     * @param node 当前节点
     * @return 深度
     */
    private int depth(TreeNode node) {
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
     * 中序遍历
     * @param node 根节点
     */
    void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getVal()+" ");
            inOrder(node.getRight());
        }
    }

    public static void main(String[] args) {
        BalanceSearchTree balanceSearchTree = new BalanceSearchTree();
        int[] nums = new int[]{0,1,2,3,4,5};
        System.out.println("根节点是否为空： " + Objects.isNull(balanceSearchTree.root));
        balanceSearchTree.root = balanceSearchTree.sortedArrayToBST(nums);
        System.out.println("根节点是否为空： " + Objects.isNull(balanceSearchTree.root));
        System.out.println("中序遍历：");
        balanceSearchTree.inOrder(balanceSearchTree.root);
    }

    /**
     * 递归实现:
     * 按照二分思想：中点左边的数作为左子树，中点右边的数作为右子树。
     * @param nums nums
     * @return  TreeNode
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return help(nums, 0, nums.length - 1);
    }


    private TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid], null, null);
        node.left = help(nums, start, mid - 1);
        node.right = help(nums, mid + 1, end);
        return node;
    }


}
