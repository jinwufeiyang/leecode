package tree.binarytree;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: dj
 * @Date: 2019/11/30 16:19
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BiTreeDto {
    BiTree node;
    Boolean flag;
}
