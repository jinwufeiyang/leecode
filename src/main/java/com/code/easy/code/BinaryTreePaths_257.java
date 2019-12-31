package com.code.easy.code;

import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: BinaryTreePaths_257
 * @Description: 给定一个二叉树，返回所有从根节点到叶子节点的路径。说明: 叶子节点是指没有子节点的节点
 * @Author: JW
 * @Date: 2019/12/31 23:01
 */
public class BinaryTreePaths_257 {


    /**
     * 递归实现
     * 最直观的方法是使用递归。在递归遍历二叉树时，需要考虑当前的节点和它的孩子节点。
     * 如果当前的节点不是叶子节点，则在当前的路径末尾添加该节点，并递归遍历该节点的每一个孩子节点。
     * 如果当前的节点是叶子节点，则在当前的路径末尾添加该节点后，就得到了一条从根节点到叶子节点的路径，可以把该路径加入到答案中
     */
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> list = new LinkedList<>();
        if (root == null) {
            return null;
        }
        createPath(root, "", list);
        return list;
    }

    public void createPath(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.right == null) && (root.left == null)) {  // 当前节点是叶子节点
                paths.add(path);  // 把路径加入到答案中
            } else {
                path += "->";  // 当前节点不是叶子节点，继续递归遍历
                createPath(root.left, path, paths);
                createPath(root.right, path, paths);
            }
        }
    }

    public static void main(String[] args) {

    }
}
