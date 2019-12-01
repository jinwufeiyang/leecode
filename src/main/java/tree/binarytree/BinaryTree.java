package tree.binarytree;

import java.util.Objects;

/**
 * @version v1.0
 * @ClassName: BinaryTree
 * @Description: 二叉搜索树相关功能
 * @Author: JW
 * @Date: 2019/12/1 20:27
 */
public class BinaryTree {

    private TreeNode root;

    /**
     * 插入操作
     * @param root root
     * @param val val
     * @return TreeNode
     */
    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.getVal() > val) {
            root.setLeft(insert(root.getLeft(), val));
        } else if (root.getVal() < val) {
            root.setRight(insert(root.getRight(), val));
        }
        return root;
    }

    /**
     * 查找二叉树是否包含某个元素
     *
     * @param root root
     * @param val val
     * @return boolean
     */
    private boolean contains(TreeNode root, int val) {
        //二叉树为空时，返回false
        if (root == null) {
            return false;
        }
        if (root.getVal() > val) {
            return contains(root.getLeft(), val);
        } else if (root.getVal() < val) {
            return contains(root.getRight(), val);
        } else {
            return true;
        }
    }

    /**
     * 删除元素
     *
     * @param val val
     */
    private void remove(int val) {
        remove(root, val);
    }

    /**
     * 删除元素
     *
     * @param root root
     * @param val val
     * @return TreeNode
     */
    private TreeNode remove(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.getVal() > val) {
            root.setLeft(remove(root.getLeft(), val));
        } else if (root.getVal() < val) {
            root.setRight(remove(root.getRight(), val));
        } else {
            //节点只有一个儿子，或者说没有儿子
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            //当节点有两个儿子时,一般的策略是用其右子树的最小的数据来代替父节点的位置
            root.setVal(finaMin(root.getRight()));
            //然后再删除掉最小数据所在的节点
            root.setRight(remove(root.getRight(), root.getVal()));
        }
        return root;
    }

    /**
     * 找出右子树最小值
     *
     * @param right right
     * @return int
     */
    private int finaMin(TreeNode right) {
        if (right.getLeft() == null) {
            return right.getVal();
        } else {
            return finaMin(right.getLeft());
        }
    }

    public static void main(String[] args) {
        int[] a = {62,88,58,47,35,73,51,99,37,93};
        System.out.println("创建二叉树数据大小:" + a.length);
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < a.length; i++) {
            binaryTree.root = binaryTree.insert(binaryTree.root, a[i]);
        }
        //中序遍历
        System.out.println("中序遍历：");
        binaryTree.inOrder(binaryTree.root);
        int key = 37;
        binaryTree.remove(key);
        //删除操作后中序遍历
        System.out.println("\n删除" + key + "后中序遍历:");
        binaryTree.inOrder(binaryTree.root);
    }

    /**
     * 中序遍历二叉排序树
     * 中序遍历的原因是：对于二叉排序树，中序遍历的结果就是从小到大排列的，所以可以用来判断二叉排序树是否成功创建.
     * @param root root
     */
    private void inOrder(TreeNode root) {
        if (Objects.nonNull(root)) {
            inOrder(root.getLeft());
            System.out.print(root.getVal() + "\t");
            inOrder(root.getRight());
        }
    }

}
