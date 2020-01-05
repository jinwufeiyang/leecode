package com.code.easy.code.tree;

import com.code.easy.code.TreeNode;

/**
 * @version v1.0
 * @ClassName: PathSum_437
 * @Description: 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数
 *
 * @Author: JW
 * @Date: 2020/1/5 17:30
 */
public class PathSum_437 {
    /**
     * 最Naive的想法就是，以每个节点为根节点，都算一遍路径和为sum的有几条，然后加起来
     * 不过效率不高，存在大量重复计算
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return count(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int count(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + count(root.left, sum) + count(root.right, sum);
    }


    /**
     * 上面是减法，这是加法方式：性质都是一样
     * 求以 root 为根的二叉树，所有和为 sum 的路径；
     * 路径的开头不一定是 root，结尾也不一定是叶子节点；
     * @param root
     * @param sum
     * @return
     */
    public int pathSum3(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        return paths(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private int paths(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val == sum) {
            res += 1;
        }

        res += paths(root.left, sum - root.val);
        res += paths(root.right, sum - root.val);

        return res;
    }

    public static void main(String[] args) {

    }

    /**
     * 1、遍历每个节点。 关键点：递归
     * 2、计算以当前节点为路径终点的所有路径和。 关键点：用一个数组保存从根节点到当前节点路径
     * @param root
     * @param sum
     * @return
     */
    public int pathSum2(TreeNode root, int sum) {
        return pathSum(root, sum, new int[1000], 0);
    }

    public int pathSum(TreeNode root, int sum, int[] array/*保存路径*/, int p/*指向路径终点*/) {
        if (root == null) {
            return 0;
        }
        int tmp = root.val;
        int n = root.val == sum ? 1 : 0;
        for (int i = p - 1; i >= 0; i--) {
            tmp += array[i];
            if (tmp == sum) {
                n++;
            }
        }
        array[p] = root.val;
        int n1 = pathSum(root.left, sum, array, p + 1);
        int n2 = pathSum(root.right, sum, array, p + 1);
        return n + n1 + n2;
    }


}
