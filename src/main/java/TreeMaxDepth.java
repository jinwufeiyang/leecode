/**
 * @Author: dj
 * @Date: 2019/10/29 23:49
 * @Version 1.0
 */
public class TreeMaxDepth {
    /**
     * 给定一个二叉树，找出其最大深度。
     二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     */
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        depth = maxDepth(root.left, depth + 1);
        return depth;
    }

    private int maxDepth(TreeNode left, int depth) {

        return 0;
    }
}
