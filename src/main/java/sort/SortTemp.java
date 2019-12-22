package sort;

/**
 * @version v1.0
 * @ClassName: SortTemp
 * @Description: 模板排序类
 * @Author: JW
 * @Date: 2019/12/22 18:43
 */
public abstract class SortTemp {

    public static void sort(Comparable[] a) {}

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void  show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.print(comparable + "");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

}
