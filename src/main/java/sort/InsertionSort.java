package sort;

/**
 * @version v1.0
 * @ClassName: InsertionSort
 * @Description: 插入排序
 * @Author: JW
 * @Date: 2019/12/22 20:23
 */
public class InsertionSort extends SortTemp {

    public static void sort(Comparable[] a) {
        int arrayLength = a.length;
        for (int i=1; i < arrayLength; i++) {
            for (int j = i; j>0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{4,1,3,2,8,5,7};
        sort(a);
        System.out.println("排序过后是否有序：" + isSorted(a));
        show(a);
    }
}
