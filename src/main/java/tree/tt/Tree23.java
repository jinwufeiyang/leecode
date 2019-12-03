package tree.tt;

public class Tree23<Key extends Comparable<Key>, Value> {

    /**
     * 根节点
     */
    private Node23<Integer, Integer> root = new Node23<Integer, Integer>();


    public static void main(String[] args) {
        Tree23<Integer, Integer> tree23 = new Tree23();
        tree23.insert(1, 1);
        System.out.println("1111");
        tree23.root.displayNode();
        System.out.println(tree23.root.isFull());
        System.out.println(tree23.root.getParent());
        Node23<Integer, Integer>[] childNodes1 = tree23.root.getChildNodes();
        for (int i = 0; i < childNodes1.length; i++) {
            if (childNodes1[i] != null) {
                childNodes1[i].displayNode();
            }
        }
        tree23.insert(2, 2);
        System.out.println("2222");
        tree23.root.displayNode();
        System.out.println(tree23.root.isFull());
        System.out.println(tree23.root.getParent());
        Node23<Integer, Integer>[] childNodes2 = tree23.root.getChildNodes();
        for (int i = 0; i < childNodes2.length; i++) {
            if (childNodes2[i] != null) {
                childNodes2[i].displayNode();
            }
        }
        tree23.insert(3, 3);
        System.out.println("3333");
        tree23.root.displayNode();
        System.out.println(tree23.root.isFull());
        System.out.println(tree23.root.getParent());
        Node23<Integer, Integer>[] childNodes3 = tree23.root.getChildNodes();
        for (int i = 0; i < childNodes3.length; i++) {
            if (childNodes3[i] != null) {
                childNodes3[i].displayNode();
            }
        }

        tree23.insert(4, 4);
        System.out.println("4444");
        tree23.root.displayNode();
        System.out.println(tree23.root.isFull());
        System.out.println(tree23.root.getParent());
        Node23<Integer, Integer>[] childNodes4 = tree23.root.getChildNodes();
        for (int i = 0; i < childNodes4.length; i++) {
            if (childNodes4[i] != null) {
                childNodes4[i].displayNode();
                System.out.println("节点4是否已满：" + childNodes4[i].isFull());
                System.out.println("节点4数：" + childNodes4[i].getItemNum());
            }
        }

        tree23.insert(5, 5);
        System.out.println("55555");
        tree23.root.displayNode();
        System.out.println(tree23.root.isFull());
        System.out.println(tree23.root.getParent());
        Node23<Integer, Integer>[] childNodes5 = tree23.root.getChildNodes();
        for (int i = 0; i < childNodes5.length; i++) {
            if (childNodes5[i] != null) {
                childNodes5[i].displayNode();
                System.out.println("节点5是否已满：" + childNodes4[i].isFull());
                System.out.println("节点5数：" + childNodes4[i].getItemNum());
            }
        }

    }




    /**
     *查找含有key的键值对
     * @param key key
     * @return 返回键值对中的value
     */
    public Value find(Key key) {
        Node23<Integer, Integer> curNode = root;
        int childNum;
        while (true) {
            if ((childNum = curNode.findItem((Integer) key)) != -1) {
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
    private Node23<Integer, Integer> getNextChild(Node23<Integer, Integer> node, Key key) {
        for (int i = 0; i < node.getItemNum(); i++) {
            if (node.getData(i).getKey().compareTo((Integer) key)>0){
                return node.getChild(i);
            }
            else if (node.getData(i).getKey().compareTo((Integer) key) == 0){
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
        Data<Integer, Integer> data = new Data(key,value);
        Node23<Integer, Integer> curNode = root;
        // 一直找到叶节点
        while(true){
            if (curNode.isLeaf()){
                break;
            }else{
                curNode = getNextChild(curNode,key);
                for (int i = 0; i < curNode.getItemNum(); i++) {
                    // 假如key在node中则进行更新
                    if (curNode.getData(i).getKey().compareTo((Integer) key) == 0){
                        curNode.getData(i).setValue((Integer) value);
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
    private void split(Node23<Integer, Integer> node, Data<Integer, Integer> data) {
        Node23<Integer, Integer> parent = node.getParent();
        // newNode用来保存最大的键值对
        Node23<Integer, Integer> newNode = new Node23<Integer, Integer>();
        // newNode2用来保存中间key的键值对
        Node23<Integer, Integer> newNode2 = new Node23<Integer, Integer>();
        Data<Integer, Integer> mid;

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
    private void connectNode(Node23<Integer, Integer> parent, Node23<Integer, Integer> node) {
        Data<Integer, Integer> data = node.getData(0);
        if (node == root){
            return;
        }
        // 假如父节点为3-结点
        if (parent.isFull()){
            // 爷爷结点（爷爷救葫芦娃）
            Node23<Integer, Integer> gParent = parent.getParent();
            Node23<Integer, Integer> newNode = new Node23<Integer, Integer>();
            Node23<Integer, Integer> temp1,temp2;
            Data<Integer, Integer> itemData;

            if (data.getKey().compareTo(parent.getData(0).getKey())<0){
                temp1 = parent.disconnectChild(1);
                temp2 = parent.disconnectChild(2);
                newNode.connectChild(0,temp1);
                newNode.connectChild(1,temp2);
                newNode.insertData(parent.removeItem());

                // todo ???? 先移除该值，然后在插入进去：：应该是为了在移除的时候把参数重置为最初状态
                itemData = parent.removeItem();
                parent.insertData(itemData);
                parent.connectChild(0,node);
                parent.connectChild(1,newNode);
            }else if(data.getKey().compareTo(parent.getData(1).getKey())<0){
                temp1 = parent.disconnectChild(0);
                temp2 = parent.disconnectChild(2);
                Node23<Integer, Integer> tempNode = new Node23<Integer, Integer>();

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
                Node23<Integer, Integer> tempNode = parent.disconnectChild(1);
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
