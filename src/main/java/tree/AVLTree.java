package tree;

/**
 * @Author: dj
 * @Date: 2019/12/1 0:08
 * @Version 1.0
 */
public class AVLTree {

    private Node root;

    /**
     * 计算AVL节点的高度的方法
     *
     * @param node node
     * @return int
     */
    private int height(Node node) {
        //如果为空，返回height为0
        return node == null ? 0 : node.getHeight();
    }

    /**
     * 计算两个的最大值
     *
     * @param a a
     * @param b b
     * @return 较大值
     */
    private int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * 右旋转
     *
     * @param y y
     * @return 新根节点
     */
    Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T1 = x.getRight();
        x.setRight(y);
        y.setLeft(T1);
        //更新高度
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        return x;
    }

    /**
     * 左旋转
     *
     * @param x x
     * @return 新根节点
     */
    Node leftRotate(Node x) {

        Node y = x.getRight();
        Node T2 = y.getLeft();
        y.setLeft(x);
        x.setRight(T2);
        //更新高度
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        return y;
    }

    /**
     *  获取平衡因子
     *
     * @param node node
     * @return 平衡因子
     */
    int getBalance(Node node) {
        return node == null ? 0 : (height(node.getLeft()) - height(node.getRight()));
    }

    /**
     * 插入操作
     *
     * @param node node
     * @param val val
     * @return node
     */
    Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.setLeft(insert(node.getLeft(), val));
        } else if (val > node.val) {
            node.setRight(insert(node.getRight(), val));
        } else {
            return node;
        }
        //更新节点高度
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));;
        //这是插入完毕后的
        int balance = getBalance(node);
        if (balance > 1 && val < node.getLeft().val) {
            //右旋
            return rightRotate(node);
        }
        if (balance < -1 && val > node.getRight().val) {
            //左旋
            return leftRotate(node);
        }
        if (balance > 1 && val > node.getLeft().val) {
            //先左旋，再右旋
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
        if (balance < -1 && val < node.getRight().val) {
            //先右旋再左旋
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
        return node;
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        //创造AVL树
        int i = 0;
        avlTree.root = avlTree.insert(avlTree.root, 3);
        System.out.println("插入" + i++ +"个结点头结点为: " + avlTree.root.val);
        avlTree.root = avlTree.insert(avlTree.root, 2);
        System.out.println("插入" + i++ +"个结点头结点为: " + avlTree.root.val);
        avlTree.root = avlTree.insert(avlTree.root, 1);
        System.out.println("插入" + i++ +"个结点头结点为: " + avlTree.root.val);
        avlTree.root = avlTree.insert(avlTree.root, 4);
        System.out.println("插入" + i++ +"个结点头结点为: " + avlTree.root.val);
        avlTree.root = avlTree.insert(avlTree.root, 5);
        System.out.println("插入" + i++ +"个结点头结点为: " + avlTree.root.val);
        avlTree.root = avlTree.insert(avlTree.root, 6);
        System.out.println("插入" + i++ +"个结点头结点为: " + avlTree.root.val);
        avlTree.root = avlTree.insert(avlTree.root, 7);
        System.out.println("插入" + i++ +"个结点头结点为: " + avlTree.root.val);
        avlTree.root = avlTree.insert(avlTree.root, 10);
        System.out.println("插入" + i++ +"个结点头结点为: " + avlTree.root.val);
        avlTree.root = avlTree.insert(avlTree.root, 9);
        System.out.println("插入" + i++ +"个结点头结点为: " + avlTree.root.val);
        avlTree.root = avlTree.insert(avlTree.root, 8);
        System.out.println("插入" + i++ +"个结点头结点为: " + avlTree.root.val);
        System.out.println("前序遍历：");
        avlTree.preOrder(avlTree.root);
        System.out.println("\n-----------");
        System.out.println("中序遍历：");
        avlTree.inOrder(avlTree.root);
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.val+" ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.val+" ");
            inOrder(node.getRight());
        }
    }


}
