package tree.tt;

public class Tree23<Key extends Comparable<Key>, Value> {

    /**
     * 根节点
     */
    private Node23 root = new Node23();


    /**
     *查找含有key的键值对
     * @param key key
     * @return 返回键值对中的value
     */
    private Value find(Key key) {
        Node23 curNode = root;
        int childNum;
        while (true) {
            if ((childNum = curNode.findItem(key)) != -1) {
                return (Value) curNode.getItemDatas()[childNum].getValue();
            } else if (curNode.isLeaf()) {
                // 假如到了叶子节点还没有找到，则树中不包含key
                return null;
            } else {
                curNode = getNextChild(curNode, key);
            }
        }
    }

    /**
     * 在key的条件下获得结点的子节点（可能为左子结点，中间子节点，右子节点）
     * @param node node
     * @param key key
     * @return 返回子节点，若结点包含key,则返回传参结点
     */
    private Node23 getNextChild(Node23 node, Key key) {
        for (int i = 0; i < node.getItemNum(); i++) {
            if (node.getData(i).getKey().compareTo(key)>0){
                return node.getChild(i);
            }
            else if (node.getData(i).getKey().compareTo(key) == 0){
                return node;
            }
        }
        return node.getChild(node.getItemNum());
    }

    /**
     * 最重要的插入函数
     * @param key key
     * @param value value
     */
    public void insert(Key key,Value value){
        Data data = new Data(key,value);
        Node23 curNode = root;
        // 一直找到叶节点
        while(true){
            if (curNode.isLeaf()){
                break;
            }else{
                curNode = getNextChild(curNode,key);
                for (int i = 0; i < curNode.getItemNum(); i++) {
                    // 假如key在node中则进行更新
                    if (curNode.getData(i).getKey().compareTo(key) == 0){
                        curNode.getData(i).setValue(value);
                        return;
                    }
                }
            }
        }

        // 若插入key的结点已经满了，即3-结点插入
        if (curNode.isFull()){
            split(curNode,data);
        }
        // 2-结点插入
        else {
            // 直接插入即可
            curNode.insertData(data);
        }
    }

    /**
     * 这个函数是裂变函数，主要是裂变结点。
     * 这个函数有点复杂，我们要把握住原理就好了
     * @param node 被裂变的结点
     * @param data 要被保存的键值对
     */
    private void split(Node23 node, Data data) {
        Node23 parent = node.getParent();
        // newNode用来保存最大的键值对
        Node23 newNode = new Node23();
        // newNode2用来保存中间key的键值对
        Node23 newNode2 = new Node23();
        Data mid;

        if (data.getKey().compareTo(node.getData(0).getKey())<0){
            newNode.insertData(node.removeItem());
            mid = node.removeItem();
            node.insertData(data);
        }else if (data.getKey().compareTo(node.getData(1).getKey())<0){
            newNode.insertData(node.removeItem());
            mid = data;
        }else{
            mid = node.removeItem();
            newNode.insertData(data);
        }
        if (node == root){
            root = newNode2;
        }
        /**
         * 将newNode2和node以及newNode连接起来
         * 其中node连接到newNode2的左子树，newNode
         * 连接到newNode2的右子树
         */
        newNode2.insertData(mid);
        newNode2.connectChild(0,node);
        newNode2.connectChild(1,newNode);
        /**
         * 将结点的父节点和newNode2结点连接起来
         */
        connectNode(parent,newNode2);
    }

    /**
     * 链接node和parent
     * @param parent parent
     * @param node node中只含有一个键值对结点
     */
    private void connectNode(Node23 parent, Node23 node) {
        Data data = node.getData(0);
        if (node == root){
            return;
        }
        // 假如父节点为3-结点
        if (parent.isFull()){
            // 爷爷结点（爷爷救葫芦娃）
            Node23 gParent = parent.getParent();
            Node23 newNode = new Node23();
            Node23 temp1,temp2;
            Data itemData;

            if (data.getKey().compareTo(parent.getData(0).getKey())<0){
                temp1 = parent.disconnectChild(1);
                temp2 = parent.disconnectChild(2);
                newNode.connectChild(0,temp1);
                newNode.connectChild(1,temp2);
                newNode.insertData(parent.removeItem());

                itemData = parent.removeItem();
                parent.insertData(itemData);
                parent.connectChild(0,node);
                parent.connectChild(1,newNode);
            }else if(data.getKey().compareTo(parent.getData(1).getKey())<0){
                temp1 = parent.disconnectChild(0);
                temp2 = parent.disconnectChild(2);
                Node23 tempNode = new Node23();

                newNode.insertData(parent.removeItem());
                newNode.connectChild(0,newNode.disconnectChild(1));
                newNode.connectChild(1,temp2);

                tempNode.insertData(parent.removeItem());
                tempNode.connectChild(0,temp1);
                tempNode.connectChild(1,node.disconnectChild(0));

                parent.insertData(node.removeItem());
                parent.connectChild(0,tempNode);
                parent.connectChild(1,newNode);
            } else{
                itemData = parent.removeItem();

                newNode.insertData(parent.removeItem());
                newNode.connectChild(0,parent.disconnectChild(0));
                newNode.connectChild(1,parent.disconnectChild(1));
                parent.disconnectChild(2);
                parent.insertData(itemData);
                parent.connectChild(0,newNode);
                parent.connectChild(1,node);
            }
            // 进行递归
            connectNode(gParent,parent);
        }
        // 假如父节点为2结点
        else{
            if (data.getKey().compareTo(parent.getData(0).getKey())<0){
                Node23 tempNode = parent.disconnectChild(1);
                parent.connectChild(0,node.disconnectChild(0));
                parent.connectChild(1,node.disconnectChild(1));
                parent.connectChild(2,tempNode);
            }else{
                parent.connectChild(1,node.disconnectChild(0));
                parent.connectChild(2,node.disconnectChild(1));
            }
            parent.insertData(node.getData(0));
        }
    }

}
