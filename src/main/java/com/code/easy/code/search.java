package com.code.easy.code;

import java.util.Arrays;

/**
 * Description
 * DATE 2019/2/19.
 *
 * @author daijinwu.
 */
public class search {

    public static void main(String[] args) {
        int[] array = {5,2,1,8,7,9};
        Arrays.sort(array);
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i]);
        }
        System.out.println("----");
        int result = secondSearch(5, array);
        System.out.println(result);
    }

    private static int secondSearch(int key, int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (key == array[mid]) {
                return mid;
            }
            if (key < array[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
