package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: IsUgly_263
 * @Description: 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数
 * @Author: JW
 * @Date: 2019/12/30 22:14
 */
public class IsUgly_263 {
    /**
     * 其实就是2的幂，3的幂，5的幂以及2*3/2*5/3*5的数字
     * @param num num
     * @return
     */
    public static boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
                continue;
            }
            if (num % 3 == 0) {
                num = num / 3;
                continue;
            }
            if (num % 5 == 0) {
                num = num / 5;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(6));
    }
}
