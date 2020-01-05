package com.code.easy.code.array;

import java.util.TreeSet;

/**
 * 第三大的数
 * @version v1.0
 * @ClassName: ThirdMax_414
 * @Description: 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)
 * @Author: JW
 * @Date: 2020/1/5 16:20
 */
public class ThirdMax_414 {

    /**
     * 最好算法，可以扩展求最大k的数
     * 借用TreeSet（红黑树）
     * 维护一个只有3个元素的TreeSet，如果大于三个元素就就把Set中的最小最小值remove掉。
     * 最后如果Set中元素小于3就返回Set最大值，否则返回最小值。
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("error");
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0;i<nums.length;i++) {
            set.add(i);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() < 3 ? set.last() : set.first();   // set.last() 里面最大的元素
    }

    public static void main(String[] args) {

    }

    private static long MIN = Long.MIN_VALUE;    // MIN代表没有在值

    public static int thirdMax2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("nums is null or length of 0");
        }
        int n = nums.length;

        int one = nums[0];
        long two = MIN;
        long three = MIN;

        for (int i = 1; i <  n; i++) {
            int now = nums[i];
            if (now == one || now == two || now == three) {
                continue;    // 如果存在过就跳过不看
            }
            if (now > one) {
                three = two;
                two = one;
                one = now;
            } else if (now > two) {
                three = two;
                two = now;
            } else if (now > three) {
                three = now;
            }
        }

        if (three == MIN) {
            return one;  // 没有第三大的元素，就返回最大值
        }
        return (int)three;
    }
}
