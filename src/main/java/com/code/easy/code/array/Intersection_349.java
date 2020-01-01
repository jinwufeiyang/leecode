package com.code.easy.code.array;

import java.util.*;

/**
 * 两个数组的交集
 * @version v1.0
 * @ClassName: Intersection_349
 * @Description: 给定两个数组，编写一个函数来计算它们的交集
 * @Author: JW
 * @Date: 2020/1/1 20:02
 */
public class Intersection_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (list1.indexOf(nums1[i]) == -1) {
                list1.add(nums1[i]);
            }
        }
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (list1.indexOf(nums2[i]) != -1 && list2.indexOf(nums2[i]) == -1) {
                list2.add(nums2[i]);
            }
        }
        int length = list2.size();
        int[] nums = new int[length];
        for (int i=0;i<length;i++) {
            nums[i] = list2.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
    }
}
