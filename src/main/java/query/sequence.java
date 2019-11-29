package query;

/**
 * Description
 * DATE 2019/11/29.
 *
 * @author daijinwu.
 */
public class sequence {

    public static void main(String[] args) {

    }

    /**
     * 顺序表查询--从第一个到最后一个逐次对比判断
     * 有则是当前索引位置，无则是-1
     * @param a 数组
     * @param key 关键字
     * @return 索引地址
     */
    private static int Sequence_search(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 有序表查找
     * 二分查找：前提线性表记录必须是关键码有序
     * 相关查找算法：插值查找&斐波那契查找
     * @param a 数组
     * @param key 关键字
     * @return 索引位置
     */
    private static int Binary_search(int[] a, int key) {
        int low,high,mid;
        low = 0;
        high = a.length;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
