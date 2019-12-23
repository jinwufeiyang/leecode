package sort;

/**
 * @version v1.0
 * @ClassName: SelectionSort
 * @Description: 选择排序
 * @Author: JW
 * @Date: 2019/12/22 18:58
 */
public class SelectionSort extends SortTemp {

    public static void sort(Comparable[] a) {
        int arrayLength = a.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
        }
    }

    public static void main(String[] args) {
        Comparable[] a = new Comparable[]{4,1,3,2,8,5,7};
        sort(a);
        System.out.println("排序过后是否有序：" + isSorted(a));
        show(a);
    }

}
