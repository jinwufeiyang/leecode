package com.code.easy.code;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class singleNumber_136 {

    public int singleNumber(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            } else {
                list.remove(list.indexOf(nums[i]));
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {

    }
}
