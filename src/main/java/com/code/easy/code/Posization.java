package com.code.easy.code;

import java.util.Arrays;

/**
 * Description
 * DATE 2019/2/26.
 *
 * @author daijinwu.
 */
public class Posization {
    public static void main(String[] args) {
        int[] nums = {3,5,7,9,10};
        int t = 8;
        int pz = pz(nums, t);
        System.out.println(pz);
    }
    public static int pz(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

}
