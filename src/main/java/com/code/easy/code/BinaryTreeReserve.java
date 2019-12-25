package com.code.easy.code;


import com.google.common.collect.Lists;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class BinaryTreeReserve {

    public static void main(String[] args) {
        levelOrderBottom(TreeNode.builder().build());
    }

    /**
     * 方法1
     * @param root root
     * @return 集合
     */
    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if (root == null) {
            return listList;
        }

        //每层数据从左到右放到集合
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int currentSize = deque.size();
            for (int i=0; i<currentSize; i++) {
                TreeNode node = deque.pop();
                list.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            listList.add(list);
        }
        //反转
        Collections.reverse(listList);
        return listList;
    }

    /**
     * 方法2
     * @param root root
     * @return 集合
     */
    private static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> linkedList = Lists.newLinkedList();
        if (root == null) {
            return linkedList;
        }
        LinkedList<TreeNode> queue = Lists.newLinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = Lists.newLinkedList();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.pop();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //区别点：头插入
            linkedList.addFirst(list);
        }
        return linkedList;
    }

}
