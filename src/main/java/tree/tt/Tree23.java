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

//        tree23.insert(4, 4);
//        System.out.println("4444");
//        tree23.root.displayNode();
//        System.out.println(tree23.root.isFull());
//        System.out.println(tree23.root.getParent());
//        Node23<Integer, Integer>[] childNodes4 = tree23.root.getChildNodes();
//        for (int i = 0; i < childNodes4.length; i++) {
//            if (childNodes4[i] != null) {
//                childNodes4[i].displayNode();
//                System.out.println("节点4是否已满：" + childNodes4[i].isFull());
//                System.out.println("节点4数：" + childNodes4[i].getItemNum());
//            }
//        }

        tree23.insert(5, 5);
        System.out.println("55555");
        tree23.root.displayNode();
        System.out.println(tree23.root.isFull());
        System.out.println(tree23.root.getParent());
        Node23<Integer, Integer>[] childNodes5 = tree23.root.getChildNodes();
        for (int i = 0; i < childNodes5.length; i++) {
            if (childNodes5[i] != null) {
                childNodes5[i].displayNode();
                System.out.println("节点5是否已满：" + childNodes5[i].isFull());
                System.out.println("节点5数：" + childNodes5[i].getItemNum());
            }
        }

        tree23.insert(6, 6);
        tree23.insert(7, 7);
        tree23.insert(8, 8);

        tree23.insert(4,4);

        //中序遍历
        System.out.println("\n\n中序遍历2-3树如下：");
        tree23.inOrder(tree23.root);
        //查找
        int key = 5;
        System.out.println("\n查找 key:" + key);
        Integer value = tree23.find(key);
        System.out.println("查找 key: " + key + " 对应的value: " + value);

        tree23.delete(1);
        System.out.println("\n\n删除中序遍历2-3树如下：");
        tree23.inOrder(tree23.root);
    }


    /**
     * 查找key相等的树结点
     * @param curNode curNode
     * @param key key
     * @return
     */
    public Node23<Integer, Integer> contain(Node23<Integer, Integer> curNode, Key key) {
        if (curNode.findItem((Integer) key) != -1) {
            return curNode;
        } else if (curNode.isLeaf()) {
            return null;
        } else {
            return contain(getNextChild(curNode, key), key);
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
     * 2-3树删除操作
     * @param key key
     */
    public void delete(Key key) {
        Node23<Integer, Integer> currentNode = contain(root, key);
        //存在
        if (currentNode != null) {
            //该key存在的是几结点（2||3）
            int itemNum = currentNode.getItemNum();
            boolean isLeaf = currentNode.isLeaf();
            if (isLeaf) {
                //是叶子节点
                if (itemNum == 2) {
                    //1：待删除节点在叶子节点且叶子节点为3节点。。直接删除即可。
                    currentNode.removeAppointKey((Integer) key);
                } else {

                    boolean fullTwoTreeFlag = isFullTwoTree(root);

                    if (!fullTwoTreeFlag) {

                        //2：叶子节点为2节点。。
                        //父节点
                        Node23<Integer, Integer> currentNodeParent = currentNode.getParent();
                        //父节点数据个数
                        int parentItemNum = currentNodeParent.getItemNum();
                        /**
                         * case1： 双亲也是2节点且拥有一个3节点的孩子
                         * case2： 双亲也是2节点，孩子也是2节点
                         * case3： 双亲是3节点，
                         * case4： 当前树是一个满二叉树，删除任何一个都不能满足2-3树的定义。可以考虑降级
                         */
                        //当前结点在父节点的索引位置决定是左旋还是右旋
                        int childIndex = currentNodeParent.getChildIndex(currentNode);
                        //case1
                        if (parentItemNum == 1) {
                            //case1.1,此时只需要左旋操作，即可
                            if (currentNodeParent.getChild(1).getItemNum() == 2 && childIndex == 0) {
                                leftRotate(currentNodeParent);
                            }
                            //case1.2,此时只需要右旋操作
                            if (currentNodeParent.getChild(0).getItemNum() == 2 && childIndex == 1) {
                                rightRotate(currentNodeParent);
                            }
                        }
                        //case2  垃圾，，，垃圾啊
                        if (parentItemNum == 1) {
                            //case2.1
                            if (childIndex == 0 && currentNodeParent.getChild(1).getItemNum() ==1) {

                            }
                            //case2.2
                            if (childIndex == 1 && currentNodeParent.getChild(0).getItemNum() == 1) {

                            }
                        }
                        //case3
                        if (parentItemNum == 2) {
                            //0左1中2右
                            int nodeParentChildIndex = currentNodeParent.getChildIndex(currentNode);
                            if (nodeParentChildIndex == 2) {
                                currentNode.removeItem();
                                currentNodeParent.disconnectChild(2);
                                Data<Integer, Integer> integerData = currentNodeParent.removeItem();
                                currentNodeParent.getChild(1).insertData(integerData);
                            } else if (nodeParentChildIndex == 1){
                                currentNode.removeItem();
                                currentNodeParent.disconnectChild(1);
                                Data<Integer, Integer> integerData = currentNodeParent.removeItem();
                                currentNodeParent.getChild(2).insertData(integerData);
                            } else {
                                Data<Integer, Integer> integerDataMax = currentNodeParent.removeItem();
                                Data<Integer, Integer> integerDataMin = currentNodeParent.removeItem();
                                currentNodeParent.insertData(integerDataMax);
                                currentNode.removeItem();
                                currentNodeParent.disconnectChild(0);
                                currentNodeParent.getChild(1).insertData(integerDataMin);
                            }
                        }
                    } else {
                        //满二叉树，降级处理
                        Node23<Integer, Integer> currentNodeParent = currentNode.getParent();
                        currentNode.removeItem();

                        int childIndex = currentNodeParent.getChildIndex(currentNode);
                        Node23<Integer, Integer> otherNode = currentNodeParent.getChild(1-childIndex);
                        currentNodeParent.disconnectChild(childIndex);
                        currentNodeParent.disconnectChild(1-childIndex);

                        Data<Integer, Integer> otherData = otherNode.removeItem();
                        currentNodeParent.insertData(otherData);

                        Node23<Integer, Integer> parentParent = currentNodeParent.getParent();
                        while (parentParent != null) {
                            parentParent = currentNodeParent.getParent();
                            int parentChildIndex = parentParent.getChildIndex(currentNodeParent);
                            Node23<Integer, Integer> parentParentChild = parentParent.getChild(1 - parentChildIndex);
                            Data<Integer, Integer> parentParentChildData = parentParentChild.getData(0);
                            if (parentChildIndex == 0) {
                                Node23<Integer, Integer> childChild = parentParentChild.getChild(0);
                                parentParentChild.disconnectChild(0);
                                parentParent.insertData(parentParentChildData);
                                parentParent.connectChild(1, childChild);
                                parentParent.connectChild(0, currentNodeParent);//???????
                            } else {
                                Node23<Integer, Integer> childChild = parentParentChild.getChild(1);
                                parentParentChild.disconnectChild(1);
                                parentParent.insertData(parentParentChildData);
                                parentParent.connectChild(1, childChild);
                                parentParent.connectChild(2, currentNodeParent);//???????
                            }
                        }



                    }
                }
            } else {
                //非叶子节点：先中序遍历得到前驱或后继，然后补位

                int nodeItemNum = currentNode.getItemNum();
                if (nodeItemNum == 1) {
                    //case1:删除的节点是两节点的元素

                } else {
                    //case2：删除的节点是三节点的元素

                }
            }
        }
    }

    /**
     * 判断当前树是否是满二叉树  ????
     * @param root root
     * @return boolean
     */
    boolean isFullTwoTree(Node23 root) {
        boolean flag = true;
        if (root == null) {
            return flag;
        }
        if (root.getItemNum() != 1) {
            return false;
        }
        boolean leftFlag = isFullTwoTree(root.getChild(0));
        boolean rightFlag = isFullTwoTree(root.getChild(1));
        return leftFlag && rightFlag;
    }




    /**
     * 删除左旋操作
     * case：双亲是2节点且有一个3节点的右孩子
     * @param node23 node
     */
    private void leftRotate(Node23<Integer, Integer> node23) {
        System.out.println("左旋操作 删除节点 的父节点数据如下:");
        node23.getItemDatas()[0].displayData();
        Node23<Integer, Integer> leftNode = node23.getChild(0);
        Node23<Integer, Integer> rightNode = node23.getChild(1);
        leftNode.removeItem();
        leftNode.insertData(node23.removeItem());
        Data<Integer, Integer> item1 = rightNode.removeItem();
        Data<Integer, Integer> item2 = rightNode.removeItem();
        rightNode.insertData(item1);
        node23.insertData(item2);
    }

    /**
     * 删除右旋操作
     * @param node23 node
     */
    private void rightRotate(Node23<Integer, Integer> node23) {
        System.out.println("右旋操作 删除节点 的父节点数据如下:");
        node23.getItemDatas()[0].displayData();
        Node23<Integer, Integer> leftNode = node23.getChild(0);
        Node23<Integer, Integer> rightNode = node23.getChild(1);
        rightNode.removeItem();
        rightNode.insertData(node23.removeItem());
        Data<Integer, Integer> item1 = leftNode.removeItem();
        node23.insertData(item1);
    }


    /**
     * 中序遍历
     * @param root root
     */
    public void inOrder(Node23 root) {
        if (root != null) {
            int itemNum = root.getItemNum();
            if (itemNum == 0) {
                root.displayNode();
            } else if (itemNum == 1) {
                inOrder(root.getChild(0));
                root.displayNode();
                inOrder(root.getChild(1));
            } else {
                inOrder(root.getChild(0));
                root.getItemDatas()[0].displayData();
                inOrder(root.getChild(1));
                root.getItemDatas()[1].displayData();
                inOrder(root.getChild(2));
            }
        }
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
