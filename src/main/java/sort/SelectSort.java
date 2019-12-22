package sort;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {6,2,5,4,7,8,1};
        array = selectSort(array);
        sout(array);
    }

    private static void sout(int[] array) {
        for (int temp : array) {
            System.out.print(temp + "\t");
        }
    }

    /**
     * 核心算法
     * @param origin 原数组
     * @return 有序数组
     */
    private static int[] selectSort(int[] origin) {
        int arrayLength = origin.length;
        for (int i = 0; i < arrayLength - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (origin[j] < origin[min]) {
                    min = j;
                }
            }
            swap(origin, min, i);
        }
        return origin;
    }

    /**
     * 交换 origin[min] & origin[i] 值
     * @param origin 数组
     * @param min 下标1
     * @param i 下标2
     */
    private static void swap(int[] origin, int min, int i) {
        int temp = origin[min];
        origin[min] = origin[i];
        origin[i] = temp;
    }

}
