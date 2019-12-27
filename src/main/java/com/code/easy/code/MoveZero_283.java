package com.code.easy.code;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZero_283 {

    /**
     * 最优解
     * @param nums 数组
     */
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int currentIndex = 0;
        for (int i=0; i<length; i++) {
            if (nums[i] != 0) {
                nums[currentIndex] = nums[i];
                if (currentIndex != i) {
                    nums[i] = 0;
                }
                currentIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] originArrays = {0, 0, 1, 2, 3, 0, 8, 0, 9};
        moveZeroes(originArrays);
        for (int i=0;i<originArrays.length;i++) {
            System.out.print(originArrays[i] + "\t");
        }
    }
}
