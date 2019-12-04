package tree.rb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RBTNode<T extends Comparable<T>> {
    boolean color;
    T key;
    RBTNode<T> left;
    RBTNode<T> right;
    RBTNode<T> parent;
}
