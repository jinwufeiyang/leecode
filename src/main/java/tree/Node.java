package tree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: dj
 * @Date: 2019/12/1 0:08
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    int val;
    private Node left;
    private Node right;
    /**
     * 节点高度,高度是指节点到一片树叶的最长路径的长
     */
    private int height;

    /**
     * construct
     * @param val val
     */
    public Node(int val) {
        this.val = val;
        height = 1;
    }

}
