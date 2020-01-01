package com.code.easy.code;

/**
 * 有效的完全平方数
 * @version v1.0
 * @ClassName: IsPerfectSquare_367
 * @Description: 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * @Author: JW
 * @Date: 2020/1/1 22:57
 */
public class IsPerfectSquare_367 {

    /*
    二分法
     */
    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        //long类型主要为了防止溢出
        long left = 2;
        long right = num / 2;
        long x, guess;
        while (left <= right) {
            x = left + (right - left) / 2;
            guess = x * x;
            if (guess == num) {
                return true;
            }
            if (guess > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201) + "--" + Math.sqrt(808201));
    }

    /*
    暴力
     */
    public static boolean isPerfectSquare2(int num) {
        long i = 1;
        while (i*i <= num) {
            i++;
        }
        return i*i == num;
    }

    /*
    解法三：数学定理(1 + 3 + 5 + ... + (2n - 1) = n ^ 2)
     */
    public static boolean isPerfectSquare3(int num) {
        //解法三：数学定理(1 + 3 + 5 + ... + (2n - 1) = n ^ 2)
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }


}
