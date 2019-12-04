package tree.rb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 * @ClassName: Node
 * @Description: TODO(一句话描述该类的功能)
 * @Author: JW
 * @Date: 2019/12/5 0:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node<Key, Value> {
    private Key key;            //key
    private Value val;          //associated data
    private Node left, right;   //links to left and right subtrees
    private Boolean color;      //color of parent link
    private int size;           //subtree count

    public Node(Key key, Value value, Boolean color, int size) {
        this.key = key;
        this.val = value;
        this.color = color;
        this.size = size;
    }
}
