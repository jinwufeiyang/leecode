package tree.rb;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 保持红黑树规则，主要通过两类操作来实现，一换色，二旋转
 * 红黑树插入主要解决的是红-红冲突，删除主要解决的是“双黑”
 *
 * @version v1.0
 * @ClassName: RedBlackBST
 * @Description: 红黑树相关操作
 * @Author: JW
 * @Date: 2019/12/5 0:26
 */
public class RedBlackBST<Key extends Comparable, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root; //root of the BST

    //is node x red?
    private boolean isRed(Node x) {
        if(x == null) {
            return false;
        }
        return x.getColor() == RED;
    }

    //number of node in subtree rooted at x; 0 if x is null
    private int size(Node x) {
        if(x == null) {
            return 0;
        }
        return x.getSize();
    }

    /**
     * return the number of key-value pairs in this symbol table
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size(root);
    }

    /**
     * is this symbol table empty?
     * @return true if this symbol table is empty and false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * return the value associated with the given key
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table, and null if it is not.
     */
    public Value get(Key key) {
        if(key == null) {
            throw new NullPointerException("argument to get() is null");
        }
        return get(root, key);
    }

    //value associated with the given key in subtree rooted at x; null if no such key
    private Value get(Node node, Key key) {
        while(node != null) {
            int cmp = key.compareTo(node.getKey());
            if(cmp < 0) {
                node = node.getLeft();
            }
            else if(cmp > 0) {
                node = node.getRight();
            }
            else {
                return (Value) node.getVal();
            }
        }
        return null;
    }

    /**
     * @param key the key
     * @return true if this symbol table contains key and false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /***************************************************************************
     *  Red-black tree insertion.
     ***************************************************************************/

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is null.
     *
     * @param key the key
     * @param val the value
     * @throws NullPointerException if key is null
     */
    public void put(Key key, Value val) {
        if (key == null) {
            throw new NullPointerException("first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        root.setColor(BLACK);
    }

    // insert the key-value pair in the subtree rooted at h
    private Node put(Node h, Key key, Value val) {
        if(h == null) {
            return new Node(key, val, RED, 1);
        }

        int cmp = key.compareTo(h.getKey());
        if(cmp < 0) {
            h.setLeft(put(h.getLeft(), key, val));
        }
        else if(cmp > 0) {
            h.setRight(put(h.getRight(), key, val));
        }
        else {
            h.setVal(val);
        }

        if(isRed(h.getRight()) && !isRed(h.getLeft())) {
            h = rotateLeft(h);
        }
        if(isRed(h.getLeft()) && isRed(h.getLeft().getLeft())) {
            h = rotateRight(h);
        }
        if(isRed(h.getLeft()) && isRed(h.getRight())) {
            flipColors(h);
        }

        h.setSize(size(h.getLeft()) + size(h.getRight()) + 1);
        return h;
    }

/***************************************************************************
 *  Red-black tree deletion.
 ***************************************************************************/


    /**
     * Removes the smallest key and associated value from the symbol table.
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        // if both children of root are black, set root to red
        if (!isRed(root.getLeft()) && !isRed(root.getRight()))
            root.setColor(RED);

        root = deleteMin(root);
        if (!isEmpty()) {
            root.setColor(BLACK);
        }
        // assert check();
    }

    // delete the key-value pair with the minimum key rooted at h
    // delete the key-value pair with the minimum key rooted at h
    private Node deleteMin(Node h) {
        if (h.getLeft() == null){
            return null;
        }

        if (!isRed(h.getLeft()) && !isRed(h.getLeft().getLeft())) {
            h = moveRedLeft(h);
        }

        h.setLeft(deleteMin(h.getLeft()));
        return balance(h);
    }

    /**
     * Removes the largest key and associated value from the symbol table.
     * @throws NoSuchElementException if the symbol table is empty
     */
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        // if both children of root are black, set root to red
        if (!isRed(root.getLeft()) && !isRed(root.getRight()))
            root.setColor(RED);

        root = deleteMax(root);
        if (!isEmpty()) {
            root.setColor(BLACK);
        }
        // assert check();
    }

    // delete the key-value pair with the maximum key rooted at h
    // delete the key-value pair with the maximum key rooted at h
    private Node deleteMax(Node h) {
        if (isRed(h.getLeft()))
            h = rotateRight(h);

        if (h.getRight() == null)
            return null;

        if (!isRed(h.getRight()) && !isRed(h.getRight().getLeft()))
            h = moveRedRight(h);

        h.setRight(deleteMax(h.getRight()));

        return balance(h);
    }

    /**
     * remove the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * @throws NullPointerException if key is null
     */
    public void delete(Key key) {
        if (key == null) {
            throw new NullPointerException("argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }
        //if both children of root are black, set root to red
        if(!isRed(root.getLeft()) && !isRed(root.getRight())) {
            root.setColor(RED);
        }
        root = delete(root, key);
        if(!isEmpty()) {
            root.setColor(BLACK);
        }
    }

    // delete the key-value pair with the given key rooted at h
    // delete the key-value pair with the given key rooted at h
    private Node delete(Node h, Key key) {
        if(key.compareTo(h.getKey()) < 0) {
            if(!isRed(h.getLeft()) && !isRed(h.getLeft().getLeft())) {
                h = moveRedLeft(h);
            }
            h.setLeft(delete(h.getLeft(), key));
        }
        else {
            if(isRed(h.getLeft())) {
                h = rotateRight(h);
            }
            if (key.compareTo(h.getKey()) == 0 && (h.getRight() == null)) {
                return null;
            }
            if (!isRed(h.getRight()) && !isRed(h.getRight().getLeft())) {
                h = moveRedRight(h);
            }
            if (key.compareTo(h.getKey()) == 0) {
                Node x = min(h.getRight());
                h.setKey(x.getKey());
                h.setVal(x.getVal());
                h.setRight(deleteMin(h.getRight()));
            }
            else {
                h.setRight(delete(h.getRight(), key));
            }
        }
        return balance(h);
    }

    /***************************************************************************
     *  Red-black tree helper functions.
     ***************************************************************************/

    // make a left-leaning link lean to the right

    // make a left-leaning link lean to the right
    private Node rotateRight(Node h) {
        // assert (h != null) && isRed(h.left);
        Node x = h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);
        x.setColor(x.getRight().getColor());
        x.getRight().setColor(RED);
        x.setSize(h.getSize());
        h.setSize(size(h.getLeft()) + size(h.getRight()) + 1);
        return x;
    }

    // make a right-leaning link lean to the left
    // make a right-leaning link lean to the left
    private Node rotateLeft(Node h) {
        // assert (h != null) && isRed(h.right);
        Node x = h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);
        x.setColor(x.getLeft().getColor());
        x.getLeft().setColor(RED);
        x.setSize(h.getSize());
        h.setSize(size(h.getLeft()) + size(h.getRight()) + 1);
        return x;
    }

    // flip the colors of a node and its two children
    // flip the colors of a node and its two children
    private void flipColors(Node h) {
        // h must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        h.setColor(!h.getColor());
        h.getLeft().setColor(!h.getLeft().getColor());
        h.getRight().setColor(!h.getRight().getColor());
    }

    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private Node moveRedLeft(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

        flipColors(h);
        if (isRed(h.getRight().getLeft())) {
            h.setRight(rotateRight(h.getRight()));
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private Node moveRedRight(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
        flipColors(h);
        if (isRed(h.getLeft().getLeft())) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }

    // restore red-black tree invariant
    // restore red-black tree invariant
    private Node balance(Node h) {
        // assert (h != null);
        if (isRed(h.getRight())) {
            h = rotateLeft(h);
        }
        if (isRed(h.getLeft()) && isRed(h.getLeft().getLeft())) {
            h = rotateRight(h);
        }
        if (isRed(h.getLeft()) && isRed(h.getRight())) {
            flipColors(h);
        }

        h.setSize(size(h.getLeft()) + size(h.getRight()) + 1);
        return h;
    }

    /***************************************************************************
     *  Utility functions.
     ***************************************************************************/

    /**
     * Returns the height of the BST (for debugging).
     * @return the height of the BST (a 1-node tree has height 0)
     */
    public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) {
            return -1;
        }
        return 1 + Math.max(height(x.getLeft()), height(x.getRight()));
    }

    /***************************************************************************
     *  Ordered symbol table methods.
     ***************************************************************************/

    /**
     * Returns the smallest key in the symbol table.
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("called min() with empty symbol table");
        }
        return (Key) min(root).getKey();
    }

    // the smallest key in subtree rooted at x; null if no such key
    private Node min(Node x) {
        // assert x != null;
        if (x.getLeft() == null) {
            return x;
        }
        else {
            return min(x.getLeft());
        }
    }

    /**
     * Returns the largest key in the symbol table.
     * @return the largest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("called max() with empty symbol table");
        }
        return (Key) max(root).getKey();
    }

    // the largest key in the subtree rooted at x; null if no such key
    private Node max(Node x) {
        // assert x != null;
        if (x.getRight() == null) {
            return x;
        }
        else {
            return max(x.getRight());
        }
    }

    /**
     * Returns the largest key in the symbol table less than or equal to key.
     * @param key the key
     * @return the largest key in the symbol table less than or equal to key
     * @throws NoSuchElementException if there is no such key
     * @throws NullPointerException if key is null
     */
    public Key floor(Key key) {
        if (key == null) {
            throw new NullPointerException("argument to floor() is null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("called floor() with empty symbol table");
        }
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        else {
            return (Key) x.getKey();
        }
    }

    // the largest key in the subtree rooted at x less than or equal to the given key
    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0)  {
            return floor(x.getLeft(), key);
        }
        Node t = floor(x.getRight(), key);
        if (t != null) {
            return t;
        }
        else {
            return x;
        }
    }

    /**
     * Returns the smallest key in the symbol table greater than or equal to key.
     * @param key the key
     * @return the smallest key in the symbol table greater than or equal to key
     * @throws NoSuchElementException if there is no such key
     * @throws NullPointerException if key is null
     */
    public Key ceiling(Key key) {
        if (key == null) {
            throw new NullPointerException("argument to ceiling() is null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("called ceiling() with empty symbol table");
        }
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }
        else {
            return (Key) x.getKey();
        }
    }

    // the smallest key in the subtree rooted at x greater than or equal to the given key
    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp == 0) {
            return x;
        }
        if (cmp > 0) {
            return ceiling(x.getRight(), key);
        }
        Node t = ceiling(x.getLeft(), key);
        if (t != null) {
            return t;
        }
        else {
            return x;
        }
    }

    /**
     * Return the kth smallest key in the symbol table.
     * @param k the order statistic
     * @return the kth smallest key in the symbol table
     * @throws IllegalArgumentException unless k is between 0 and
     *     <em>N</em> − 1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException();
        }
        Node x = select(root, k);
        return (Key) x.getKey();
    }

    // the key of rank k in the subtree rooted at x
    private Node select(Node x, int k) {
        // assert x != null;
        // assert k >= 0 && k < size(x);
        int t = size(x.getLeft());
        if      (t > k) {
            return select(x.getLeft(),  k);
        }
        else if (t < k) {
            return select(x.getRight(), k-t-1);
        }
        else {
            return x;
        }
    }

    /**
     * Return the number of keys in the symbol table strictly less than key.
     * @param key the key
     * @return the number of keys in the symbol table strictly less than key
     * @throws NullPointerException if key is null
     */
    public int rank(Key key) {
        if (key == null) {
            throw new NullPointerException("argument to rank() is null");
        }
        return rank(key, root);
    }

    // number of keys less than key in the subtree rooted at x
    private int rank(Key key, Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.getKey());
        if      (cmp < 0) {
            return rank(key, x.getLeft());
        }
        else if (cmp > 0) {
            return 1 + size(x.getLeft()) + rank(key, x.getRight());
        }
        else {
            return size(x.getLeft());
        }
    }

    /***************************************************************************
     *  Range count and range search.
     ***************************************************************************/

    /**
     * Returns all keys in the symbol table as an Iterable.
     * To iterate over all of the keys in the symbol table named st,
     * use the foreach notation: for (Key key : st.keys()).
     * @return all keys in the symbol table as an Iterable
     */
    public Iterable<Key> keys() {
        if (isEmpty()) {
            return new LinkedBlockingQueue<Key>();
        }
        return keys(min(), max());
    }

    /**
     * Returns all keys in the symbol table in the given range,
     * as an Iterable.
     * @return all keys in the symbol table between lo
     *    (inclusive) and hi (exclusive) as an Iterable
     * @throws NullPointerException if either lo or hi
     *    is null
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) {
            throw new NullPointerException("first argument to keys() is null");
        }
        if (hi == null) {
            throw new NullPointerException("second argument to keys() is null");
        }

        Queue<Key> queue = new LinkedBlockingQueue<>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root, queue, lo, hi);
        return queue;
    }

    // add the keys between lo and hi in the subtree rooted at x
    // to the queue
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) {
            return;
        }
        int cmplo = lo.compareTo(x.getKey());
        int cmphi = hi.compareTo(x.getKey());
        if (cmplo < 0) {
            keys(x.getLeft(), queue, lo, hi);
        }
        if (cmplo <= 0 && cmphi >= 0) {
            queue.add((Key) x.getKey());
        }
        if (cmphi > 0) {
            keys(x.getRight(), queue, lo, hi);
        }
    }

    /**
     * Returns the number of keys in the symbol table in the given range.
     * @return the number of keys in the symbol table between lo
     *    (inclusive) and hi (exclusive)
     * @throws NullPointerException if either lo or hi
     *    is null
     */
    public int size(Key lo, Key hi) {
        if (lo == null) {
            throw new NullPointerException("first argument to size() is null");
        }
        if (hi == null) {
            throw new NullPointerException("second argument to size() is null");
        }

        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        }
        else {
            return rank(hi) - rank(lo);
        }
    }

    /***************************************************************************
     *  Check integrity of red-black tree data structure.
     ***************************************************************************/
    private boolean check() {
        if (!isBST())            System.out.println("Not in symmetric order");
        if (!isSizeConsistent()) System.out.println("Subtree counts not consistent");
        if (!isRankConsistent()) System.out.println("Ranks not consistent");
        if (!is23())             System.out.println("Not a 2-3 tree");
        if (!isBalanced())       System.out.println("Not balanced");
        return isBST() && isSizeConsistent() && isRankConsistent() && is23() && isBalanced();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) {
            return true;
        }
        if (min != null && ((Key)x.getKey()).compareTo(min) <= 0) {
            return false;
        }
        if (max != null && ((Key)x.getKey()).compareTo(max) >= 0) {
            return false;
        }
        return isBST(x.getLeft(), min, (Key) x.getKey()) && isBST(x.getRight(), (Key) x.getKey(), max);
    }

    // are the size fields correct?
    private boolean isSizeConsistent() {
        return isSizeConsistent(root);
    }

    private boolean isSizeConsistent(Node x) {
        if (x == null) {
            return true;
        }
        if (x.getSize() != size(x.getLeft()) + size(x.getRight()) + 1) {
            return false;
        }
        return isSizeConsistent(x.getLeft()) && isSizeConsistent(x.getRight());
    }

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
                return false;
            }
        }
        for (Key key : keys()) {
            if (key.compareTo(select(rank(key))) != 0) {
                return false;
            }
        }
        return true;
    }

    // Does the tree have no red right links, and at most one (left)
    // red links in a row on any path?
    private boolean is23() {
        return is23(root);
    }

    private boolean is23(Node x) {
        if (x == null) {
            return true;
        }
        if (isRed(x.getRight())) {
            return false;
        }
        if (x != root && isRed(x) && isRed(x.getLeft())){
            return false;
        }
        return is23(x.getLeft()) && is23(x.getRight());
    }

    // do all paths from root to leaf have same number of black edges?
    private boolean isBalanced() {
        int black = 0;     // number of black links on path from root to min
        Node x = root;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.getLeft();
        }
        return isBalanced(root, black);
    }

    // does every path from the root to a leaf have the given number of black links?
    private boolean isBalanced(Node x, int black) {
        if (x == null) {
            return black == 0;
        }
        if (!isRed(x)) {
            black--;
        }
        return isBalanced(x.getLeft(), black) && isBalanced(x.getRight(), black);
    }

    /**
     * Unit tests the RedBlackBST data type.
     */
    public static void main(String[] args) {
        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
        String data = "a b c d e f g h m n o p";
        Scanner sc = new Scanner(data);
        int i = 0;
        while (sc.hasNext()) {
            String key = sc.next();
            st.put(key, i);
            i++;
        }
        sc.close();

        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
        System.out.println();

        boolean result = st.check();
        System.out.println("check: " + result);
    }

}
