package com.code.easy.code.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @version v1.0
 * @ClassName: Intersect_350
 * @Description: 给定两个数组，编写一个函数来计算它们的交集。
 * @Author: JW
 * @Date: 2020/1/1 21:01
 */
public class Intersect_350 {
    /*
    不同之处在于可以重复
    输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i=0;i<nums1.length;i++) {
            if (!map1.containsKey(nums1[i] + "")) {
                map1.put(nums1[i] + "", 1);
            } else {
                Integer count = map1.get(nums1[i]) + 1;
                map1.put(nums1[i] + "", count);
            }
        }
        Map<String, Integer> map2 = new HashMap<>();
        for (int i=0;i<nums2.length;i++) {
            if (!map2.containsKey(nums2[i] + "")) {
                map2.put(nums2[i] + "", 1);
            } else {
                Integer count = map2.get(nums2[i]) + 1;
                map2.put(nums2[i] + "", count);
            }
        }
        int sumCount = 0;
        Set<String> keySet = map1.keySet();
        keySet.retainAll(map2.keySet());
        for (String key :
                keySet) {
            sumCount += Math.min(map1.get(key), map2.get(key));
        }
        int[] result = new int[sumCount];
        int index = 0;
        int count = 0;
        for (String key :
                keySet) {
            int temp = 0;
            temp = Math.min(map1.get(key), map2.get(key));
            Arrays.fill(result, index+count, count+temp, Long.valueOf(key).intValue());
            count += temp;
        }
        return result;
    }

    public static void main(String[] args) {

    }

    /*
    哈希映射
   1、 如果 nums1 元素个数大于 nums2，则交换数组元素。
    2、对于 nums1 的每个元素，添加到 HashMap m 中，如果元素已经存在则增加对应的计数。
    3、初始化 k = 0，记录当前交集元素个数。
    4、遍历数组 nums2：
        4.1、检查元素在 m 是否存在，若存在且计数为正：
            4.1.1、将元素拷贝到 nums1[k]，且 k++。
            4.1.2、减少 m 中对应元素的计数。
    5、返回 nums1 前 k 个元素。
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    /*
    排序：
    1、对数组 nums1 和 nums2 排序。
    2、初始化指针 i，j 和 k 为 0。
    3、指针 i 指向 nums1，指针 j 指向 nums2：
        3.1、如果 nums1[i] < nums2[j]，则 i++。
        3.2、如果 nums1[i] > nums2[j]，则 j++。
        3.3、如果 nums1[i] == nums2[j]，将元素拷贝到 nums1[k]，且 i++，j++，k++。
    4、返回数组 nums1 前 k 个元素。
     */
    public int[] intersect3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

}
