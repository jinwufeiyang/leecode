package com.code.easy.code.array;

import java.util.Arrays;

/**
 * @version v1.0
 * @ClassName: MissingNumber_268
 * @Description: 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * @Author: JW
 * @Date: 2019/12/31 23:29
 */
public class MissingNumber_268 {

    /**
     * 先排序，然后判断下标值和数组值不相等的
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        // 判断 n 是否出现在末位
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // 判断 0 是否出现在首位
        else if (nums[0] != 0) {
            return 0;
        }

        // 此时缺失的数字一定在 (0, n) 中
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        // 未缺失任何数字（保证函数有返回值）
        return -1;
//        for (int i=0;i<nums.length;i++) {
//            if (i != nums[i]) {
//                return i;
//            }
//        }
//        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1}));
    }
    /*
    方式2：采用高斯求和，然后减去数组所有值，剩余值就是所求数
    方式3：采用哈希表，判断每个数是否在数组中出现过来找出缺失数字
     */
}
