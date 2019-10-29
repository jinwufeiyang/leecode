/**
 * @Author: dj
 * @Date: 2019/10/29 23:22
 * @Version 1.0
 */
public class YmmetricTree {
    /**
     * 给定一个二叉树，检查它是否是镜像对称的
     */

    public static void main(String[] args) {
        /**
         * 假装已经有树结构数据了
         */
        YmmetricTree ymmetricTree = new YmmetricTree();
        boolean result = ymmetricTree.isSymmetric(null);
        System.out.println(result);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (right == null || left == null) {
            return false;
        }
        return left.val == right.val
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

//    public class TreeNode {
//        int val;
//        YmmetricTree.TreeNode left;
//        YmmetricTree.TreeNode right;
//        TreeNode(int x) { val = x; }
//    }

}
