package tree.binarytree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version v1.0
 * @ClassName: TreeNode
 * @Description: 二叉树实体类
 * @Author: JW
 * @Date: 2019/12/1 20:28
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
