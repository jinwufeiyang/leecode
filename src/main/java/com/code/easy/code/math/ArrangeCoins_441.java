package com.code.easy.code.math;

/**
 * @version v1.0
 * @ClassName: ArrangeCoins_441
 * @Description: 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内
 * @Author: JW
 * @Date: 2020/1/5 22:03
 */
public class ArrangeCoins_441 {

    /**
     * 公式反推：k(K+1)/2=n
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {
        return (int)(Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }

    public static void main(String[] args) {

    }
}
