/**
 *
 * @Author: dj
 * @Date: 2019/10/29 0:07
 * @Version 1.0
 */
public class SameTree {
    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * @param args args
     */
    public static void main(String[] args) {
        SameTree st = new SameTree();
        SameTree.TreeNode t1 = new SameTree().new TreeNode(1);
        SameTree.TreeNode t1_left = new SameTree().new TreeNode(2);
        t1.left = t1_left;
        SameTree.TreeNode t2 = new SameTree().new TreeNode(1);
        SameTree.TreeNode t2_left = new SameTree().new TreeNode(1);
        t2.left = t2_left;
        boolean result = st.isSameTree(t1, t2);
        System.out.println(result);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
}
