package tree.tt;

public class Node23<Key extends Comparable<Key>, Value> {
    private static final int N = 3;
    //父节点
    private Node23<Integer, Integer> parent;
    //子节点，左中右
    private Node23<Integer, Integer>[] childNodes = new Node23[N];
    //节点保存数据
    private Data<Integer, Integer>[] itemDatas = new Data[N - 1];
    //当前数据个数
    private int itemNum = 0;

    public Data<Integer, Integer>[] getItemDatas() {
        return this.itemDatas;
    }

    public void displayNode() {
        for (int i = 0; i < itemNum; i++) {
            itemDatas[i].displayData();
        }
        System.out.println("/");
    }

    public Node23<Integer, Integer>[] getChildNodes() {
        return this.childNodes;
    }

    /**
     * 判断是否是叶子节点
     * @return boolean
     */
    public boolean isLeaf() {
        // 假如不是叶子节点，必有左子树  ？？？？
        return childNodes[0] == null;
    }

    /**
     * 判断结点储存数据是否满了
     * @return boolean
     */
    public boolean isFull() {
        return itemNum == N - 1;
    }

    /**
     * 返回该节点的父节点
     * @return node
     */
    public Node23<Integer, Integer> getParent() {
        return this.parent;
    }

    /**
     * 将子节点连接
     * @param index 连接的位置（左子树，中子树，还是右子树）
     * @param child child
     */
    public void connectChild(int index, Node23<Integer, Integer> child) {
        childNodes[index] = child;
        if (child != null) {
            child.parent = (Node23<Integer, Integer>) this;
        }
    }

    /**
     * 解除该节点和某个节点之间的连接
     * @param index 解除连接的位置
     * @return node
     */
    public Node23<Integer, Integer> disconnectChild(int index) {
        Node23<Integer, Integer> temp = childNodes[index];
        childNodes[index] = null;
        return temp;
    }

    /**
     * 获取结点左或右的键值对
     * @param index 0为左，1为右
     * @return Data
     */
    public Data<Integer, Integer> getData(int index){
        return itemDatas[index];
    }

    /**
     * 获得某个位置的子树
     * @param index 0为左指数，1为中子树，2为右子树
     * @return
     */
    public Node23<Integer, Integer> getChild(int index){
        return childNodes[index];
    }

    /**
     * @return 返回结点中键值对的数量，空则返回0
     */
    public int getItemNum(){
        return itemNum;
    }

    /**
     * 寻找key在结点的位置
     * @param key key
     * @return 结点没有key则放回-1
     */
    public int findItem(Key key){
        for (int i = 0; i < itemNum; i++) {
            if (itemDatas[i] == null){
                break;
            }else if (itemDatas[i].getKey().compareTo((Integer) key) == 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 向结点插入键值对：前提是结点未满
     * @param data data
     * @return 返回插入的位置 0或则1
     */
    public int insertData(Data<Integer, Integer> data){
        itemNum ++;
        for (int i = N -2; i >= 0 ; i--) {
            if (itemDatas[i] == null){
                continue;
            }else{
                if (data.getKey().compareTo(itemDatas[i].getKey())<0){
                    itemDatas[i+1] = itemDatas[i];
                } else {
                    itemDatas[i+1] = data;
                    return i+1;
                }
            }
        }
        itemDatas[0] = data;
        return 0;
    }

    /**
     * 移除最后一个键值对（也就是有右边的键值对则移右边的，没有则移左边的）
     * @return 返回被移除的键值对
     */
    public Data<Integer, Integer> removeItem() {
        Data<Integer, Integer> temp = itemDatas[itemNum - 1];
        itemDatas[itemNum - 1] = null;
        itemNum--;
        return temp;
    }

}
