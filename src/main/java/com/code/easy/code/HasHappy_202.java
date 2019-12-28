package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: HasHappy_202
 * @Description: 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数
 * @Author: JW
 * @Date: 2019/12/28 22:37
 */
public class HasHappy_202 {

    public static int bitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int mid = n % 10;
            sum += mid * mid;
            n = n / 10;
        }
        return sum;
    }

    /**
     * 通过快慢指针来解决是否有循环问题
     * @param n 正整数
     * @return 是否快乐
     */
    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(22));
    }

}
