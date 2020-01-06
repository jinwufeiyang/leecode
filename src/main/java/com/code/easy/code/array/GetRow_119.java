package com.code.easy.code.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: GetRow_119
 * @Description: 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行
 * @Author: JW
 * @Date: 2020/1/6 22:55
 */
public class GetRow_119 {

    /***
     *我们只需要一层一层的求。但是不需要把每一层的结果都保存起来，只需要保存上一层的结果，就可以求出当前层的结果了。
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        for (int i=0;i<=rowIndex;i++) {
            cur = new ArrayList<>();
            for (int j=0;j<=i;j++) {
                if (j==0||j==i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return cur;
    }
}
