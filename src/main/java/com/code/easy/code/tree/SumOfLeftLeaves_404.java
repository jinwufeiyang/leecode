package com.code.easy.code.tree;

import com.code.easy.code.TreeNode;

/**
 * @version v1.0
 * @ClassName: SumOfLeftLeaves_404
 * @Description: 计算给定二叉树的所有左叶子之和
 * @Author: JW
 * @Date: 2020/1/4 23:44
 */
public class SumOfLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        //判断节点是否是左叶子节点，如果是则将它的和累计起来
        if(root.left != null && root.left.left == null && root.left.right == null){
            res += root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + res;
    }
}
