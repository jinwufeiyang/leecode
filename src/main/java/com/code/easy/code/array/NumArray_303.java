package com.code.easy.code.array;

import com.google.common.collect.Maps;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 区域和检索-数组不可变
 * @version v1.0
 * @ClassName: NumArray_303
 * @Description: 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * @Author: JW
 * @Date: 2020/1/1 17:51
 */
public class NumArray_303 {

//    private int[] sum;
//    public NumArray_303(int[] nums) {
//        sum = new int[nums.length + 1];
//        for (int i=0;i<nums.length;i++) {
//            sum[i+1] = nums[i] + sum[i];
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return sum[j+1] - sum[j];
//    }

    public static void main(String[] args) {

    }


    /*
    暴力方法=-==超时警告
     */
    private int[] data;
    public NumArray_303(int[] nums) {
        data = nums;
    }
    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += data[k];
        }
        return sum;
    }
}
