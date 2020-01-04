package com.code.easy.code.sort;

/**
 * @version v1.0
 * @ClassName: GuessNumber_374
 * @Description: 猜数字大小
 * @Author: JW
 * @Date: 2020/1/4 18:36
 */
public class GuessNumber_374 {

    /**
     * 二分查找
     * @param n
     * @return
     */
    public static int guessNumber(int n) {
        int left = 1, right=n;
        while (left<=right) {
            int temp = left + (right-left) / 2;
            if (guess(temp) == 0) {
                return temp;
            } else if (guess(temp) == 1) {
                left = temp + 1;
            } else {
                right = temp - 1;
            }
        }
        return -1;
    }

    private static int guess(int n) {
        if (n>6) {
            return 1;
        }
        if (n<6) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }

    /**
     * 三分查找
     * @param n
     * @return
     */
    public int guessNumber2(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int res1 = guess(mid1);
            int res2 = guess(mid2);
            if (res1 == 0)
                return mid1;
            if (res2 == 0)
                return mid2;
            else if (res1 < 0)
                high = mid1 - 1;
            else if (res2 > 0)
                low = mid2 + 1;
            else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return -1;
    }

}
