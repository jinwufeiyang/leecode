package tree.rb;

/**
 * 红黑树操作类
 * 保持红黑树的规则，主要通过两类操作，一类是换色，一类还是旋转
 * 红黑树插入主要要解决红-红冲突，而删除主要则解决“双黑”
 * @param <T>
 */
public class RBTree<T extends Comparable<T>> {

    private RBTNode<T> mRoot;  //根节点

    private static final boolean RED   = false;
    private static final boolean BLACK = true;



}
