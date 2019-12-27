package com.code.easy.code;

import java.util.Arrays;

public class MajorityElement_169 {

    public static int majorityElement(int[] nums) {
        int mid = nums.length / 2;
        Arrays.sort(nums);
        return nums[mid];
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,1,3,3,2}));
    }
}
