package com.code.easy.code.array;

/**
 * 统计位数为偶数的数字
 */
public class FindNumbers_1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i=0;i<nums.length;i++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
