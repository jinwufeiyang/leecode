package com.code.easy.code;

import java.util.HashMap;

/**
 * @version v1.0
 * @ClassName: TwoSum_167
 * @Description: 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * @Author: JW
 * @Date: 2019/12/28 19:13
 */
public class TwoSum_167 {
    /*
    1
     */
    public static int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i= 0; i<numbers.length;i++) {
            for (int j = i + 1;j<numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i=0;i<numbers.length;i++) {
            map.put(numbers[i], i);
        }
        for (int j=0;j<numbers.length;j++) {
            int temp = target - numbers[j];
            if (map.keySet().contains(temp)) {
                result[0] = j + 1;
                result[1] = map.get(temp) + 1;
                return result;
            }
        }
        return result;
    }

    public static int[] twoSum3(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[] {low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        System.out.println(twoSum2(new int[]{2, 7, 11, 15}, 9));
    }
}
