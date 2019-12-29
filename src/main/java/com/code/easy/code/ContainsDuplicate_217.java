package com.code.easy.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @version v1.0
 * @ClassName: ContainsDuplicate_217
 * @Description: 给定一个整数数组，判断是否存在重复元素.
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false
 * @Author: JW
 * @Date: 2019/12/29 16:49
 */
public class ContainsDuplicate_217 {

    /*
    如果存在重复元素，排序后它们应该相邻。
    本方法使用排序算法。由于比较排序算法，如堆排序，可以在最坏情况下具有 O(n \log n)O(nlogn) 的时间复杂度。
    因此，排序经常是很好的预处理方法。排序之后，我们可以扫描已排序的数组,以查找是否有任何连续的重复元素。
     */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i=0,j=i+1;j<nums.length;i++,j++) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{3,1}));
    }

    /*
    哈希表：利用支持快速搜索和插入操作的动态数据结构。
    从方法3中我们知道，对无序数组的查找操作的时间复杂度为 O(n)，而我们会重复调用查找操作。因此，使用搜索时间更快的数据结构将加快整个算法的速度。

    有许多数据结构常用作动态集合,如二进制搜索树和哈希表。这里我们需要的操作是 search 和 insert。
    对于平衡二叉搜索树（Java 中的 TreeSet 或 TreeMap），search 和 insert 的时间复杂度均为 O(\log n)。
    对于哈希表（Java 中的 HashSet 或 HashMap），search 和 insert 的平均时间复杂度为 O(1)。
    因此，通过使用哈希表，我们可以达到在线性时间复杂度解决问题。
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

    /*
    朴素线性查找 【超时】
     */
    public boolean containsDuplicate3(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] == nums[i]) return true;
            }
        }
        return false;
    }
    // Time Limit Exceeded

}
