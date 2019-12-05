package tree.rb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 红黑树节点类
 * 红黑树是对二叉搜索树的改进，只不过在其基础上添加一个Boolean类型变量来表示节点的颜色。
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RBNode<T extends Comparable<T>> {
    T key;
    Boolean color;
    RBNode<T> left;
    RBNode<T> right;
    RBNode<T> parent;

    public String toString() {
        return "" + key + (this.color ? "R" : "B");
    }
}
