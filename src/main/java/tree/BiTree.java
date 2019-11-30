package tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: dj
 * @Date: 2019/11/30 16:19
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BiTree {
    int data;
    BiTree lchild;
    BiTree rchild;
}
