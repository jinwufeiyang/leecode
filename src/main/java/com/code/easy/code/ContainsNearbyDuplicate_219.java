package com.code.easy.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @version v1.0
 * @ClassName: ContainsNearbyDuplicate_219
 * @Description: 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k
 * @Author: JW
 * @Date: 2019/12/29 17:19
 */
public class ContainsNearbyDuplicate_219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
//        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<length;i++) {
            if (!map.containsKey(nums[i])) {
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                map.put(nums[i], list);
                map.put(nums[i], i);
            } else {
//                List<Integer> list = map.get(nums[i]);
//                for (Integer index :
//                        list) {
//                    if (Math.abs(i-index) <= k) {
//                        return true;
//                    }
//                }
//                list.add(i);
//                map.put(nums[i], list);
                Integer index = map.get(nums[i]);
                if (Math.abs(i-index) <= k) {
                    return true;
                }
                map.remove(nums[i]);
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{99,99}, 2));
    }

    /**
     * 哈希
     * @param nums 数组
     * @param k 大小
     * @return boolean
     */
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
