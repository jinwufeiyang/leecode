package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: LowestCommonAncestor_235
 * @Description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * @Author: JW
 * @Date: 2019/12/31 21:26
 */
public class LowestCommonAncestor_235 {

    /**
     * 巧妙算法实现
     */
    private static TreeNode res = null;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return res;
    }

    private static void lca(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val-p.val) * (root.val - q.val) <= 0) {
            res = root;
        } else if (root.val < p.val && root.val < q.val){
            lca(root.right, p , q);
        } else {
            lca(root.left, p , q);
        }
    }

    public static void main(String[] args) {
    }

    /**
     * 递归实现:
     * 从根节点开始遍历树
     * 如果节点 pp 和节点 qq 都在右子树上，那么以右孩子为根节点继续 1 的操作
     * 如果节点 pp 和节点 qq 都在左子树上，那么以左孩子为根节点继续 1 的操作
     * 如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 pp 和节点 qq 的 LCA 了
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    /**
     * 迭代实现，和递归类似，唯一不同的点使用迭代方式替代了递归来完成整棵树。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null) {
            int parentVal = node.val;
            if (pVal > parentVal && qVal > parentVal) {
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }

}
