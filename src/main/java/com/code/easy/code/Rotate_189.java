package com.code.easy.code;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @version v1.0
 * @ClassName: Rotate_189
 * @Description: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @Author: JW
 * @Date: 2019/12/28 16:15
 */
public class Rotate_189 {

    /*
     * 最简单的方法是旋转 k 次，每次将数组旋转 1 个元素。
     * 时间复杂度：O(n*k)O(n∗k) 。每个元素都被移动 1 步（O(n)O(n)） k次（O(k)O(k)） 。
空间复杂度：O(1)O(1) 。没有额外空间被使用。
     */
    public static void rotate3(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /*
    我们可以用一个额外的数组来将每个元素放到正确的位置上，也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。
    然后把新的数组拷贝到原数组中。
    时间复杂度： O(n) 。将数字放到新的数组中需要一遍遍历，另一边来把新数组的元素拷贝回原数组。
    空间复杂度： O(n)。另一个数组需要原数组长度的空间。
     */
    public static void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /*
    这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
    在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
    假设 n=7n=7 且 k=3k=3 。
    原始数组                  : 1 2 3 4 5 6 7
    反转所有数字后             : 7 6 5 4 3 2 1
    反转前 k 个数字后          : 5 6 7 4 3 2 1
    反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果

    时间复杂度：O(n)O(n) 。 nn 个元素被反转了总共 3 次。
    空间复杂度：O(1)O(1) 。 没有使用额外的空间。

     */
    public static void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void rotate1(int[] nums, int k) {
        int length = nums.length;
        //该指针用于标记移动元素起始位置
        int newIndex = length;
        //主要是为了解决数组长度小于移动长度，当移动长度大于数组长度，取余后就是经过循环实际移动的长度。
        k = k%length;
        //不移动
        if (length == 0 || k == 0) {
            return;
        }
        //用于存储后几位要移动的元素
        Deque deque = new LinkedList();
        while (length >= 0) {
            int i = 0;
            //该循环用于待移动元素进队列以及确定后移元素起始位置
            while (k>0) {
                deque.add(nums[length-1 - i]);
                k--;
                i++;
                newIndex--;
            }
            //后移元素
            if (newIndex > 0) {
                //前面元素后移k位
                nums[length-1] = nums[newIndex-1];
                length--;
                newIndex--;
            } else {
                //出队列
                while (!deque.isEmpty()) {
                    nums[length-1] = (int)deque.pop();
                    length--;
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] aa = new int[]{1,2};
        pt(aa);
        rotate1(aa, 3);
        System.out.println();
        pt(aa);
    }
    private static void pt(int[] num) {
        for (int i=0;i<num.length;i++) {
            System.out.print(num[i] + "\t");
        }
    }
}
