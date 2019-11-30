package tree;

import java.util.Objects;

/**
 * 二叉排序树
 * 或者是一棵空树，或者具有以下性质树：左子树全小于根节点，右子树结点值全部大于根结点的值，它的左右子树也分别为二叉排序树
 * @Author: dj
 * @Date: 2019/11/30 15:39
 * @Version 1.0
 */
public class BinarySortTree {

    /**
     * 查询
     * @param tree 二叉树
     * @param key 索引值
     * @param parent 指向tree 的双亲，初始值为NULL
     * @return 查询成功，previous指向该结点，返回tree，否则，指向查找路径上访问的最后一个结点并返回false
     */
    private BiTreeDto search(BiTree tree, int key, BiTree parent) {
        BiTreeDto node = BiTreeDto.builder().build();
        if (tree == null) {
            node.setNode(parent);
            node.setFlag(false);
        } else if (key == tree.data) {
            node.setNode(tree);
            node.setFlag(true);
        } else if (key < tree.data) {
            return search(tree.lchild, key, tree);
        } else if (key > tree.data) {
            return search(tree.rchild, key, tree);
        }
        return node;
    }

    /**
     * 插入
     * @param tree tree
     * @param key key
     * @return boolean
     */
    private BiTreeDto insert(BiTree tree, int key) {
        BiTreeDto createTree = BiTreeDto.builder().build();
        BiTreeDto treeDto = search(tree, key, null);
        if (!treeDto.getFlag()) {
            BiTree node = new BiTree(key, null, null);
            if (treeDto.getNode() == null) {
                tree = node;
            } else if (treeDto.getNode().data < key) {
                treeDto.getNode().rchild = node;
            } else {
                treeDto.getNode().lchild = node;
            }
            createTree.setFlag(true);
        } else {
            createTree.setFlag(false);
        }
        createTree.setNode(tree);
        return createTree;
    }

    /**
     * 删除
     * @param tree tree
     * @param parent parent
     * @param key key
     * @return boolean
     */
    private boolean deleteBST(BiTree tree, BiTree parent, int key) {
        if (tree == null) {
            return false;
        } else if (tree.data == key) {
            return delete(tree, parent);
        } else if (tree.data < key) {
            return deleteBST(tree.rchild, tree, key);
        } else {
            return deleteBST(tree.lchild, tree, key);
        }
    }

    private boolean delete(BiTree tree, BiTree parent) {
        if (tree == null) {
            return false;
        } else if (tree.getLchild() == null) {
//            tree = tree.getRchild();
            if (parent.getLchild() == tree) { //删除结点是左孩子且删除结点的左孩子为空
                parent.setLchild(tree.getRchild());
            } else {
                parent.setRchild(tree.getRchild());
            }
        } else if (tree.getRchild() == null) {
//            tree = tree.getLchild();
            if (parent.getLchild() == tree) { //删除结点是左孩子且删除结点的右孩子为空
                parent.setLchild(tree.getLchild());
            } else {
                parent.setRchild(tree.getLchild());
            }
        } else {
            BiTree pnode = tree;
            BiTree snode = tree.lchild;
            while (snode.rchild != null) {
                pnode = snode;
                snode = snode.rchild;
            }
            tree.data = snode.data;
            if (pnode != tree) {
                pnode.rchild = snode.lchild;
            } else {
                pnode.lchild = snode.lchild;
            }
        }
        return true;
    }

    /**
     * 中序遍历二叉排序树
     * 中序遍历的原因是：对于二叉排序树，中序遍历的结果就是从小到大排列的，所以可以用来判断二叉排序树是否成功创建.
     * @param tree tree
     */
    private void inOrder(BiTree tree) {
        if (Objects.nonNull(tree)) {
            inOrder(tree.lchild);
            System.out.print(tree.data + "\t");
            inOrder(tree.rchild);
        }
    }

    public static void main(String[] args) {
        int[] a = {62,88,58,47,35,73,51,99,37,93};
        BinarySortTree tree = new BinarySortTree();
        BiTreeDto treeDto = new BiTreeDto();
        //创建
        for (int i = 0; i<a.length;i++) {
            treeDto = tree.insert(treeDto.node, a[i]);
        }
        BiTree treeDtoNode = treeDto.getNode();
        System.out.println("-----create----------");
        //中序遍历
        tree.inOrder(treeDtoNode);
        System.out.println();
        //删除
        int key = 37;
        boolean result = tree.deleteBST(treeDtoNode, null, key);
        System.out.println("-----delete: " + key + "---------- result:" + result);
        //删除操作后中序遍历
        tree.inOrder(treeDtoNode);
    }


}
