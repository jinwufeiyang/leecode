package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: isPowerOfTwo_231
 * @Description: 给定一个整数，编写一个函数来判断它是否是 2/3/4 的幂次方。
 * @Author: JW
 * @Date: 2019/12/29 23:02
 */
public class isPowerOfTwo_231 {

    /*
    2的幂
     */
    public static boolean isPowerOfTwo(int n) {
        if (n == 0)return false;
        if (n == 1)return true;
        if (n%2==1)return false;
        while(n%2==0){
            n = n>>1;
        }
        return n==1;
    }

    /*
    3的幂
     */
    public static boolean isPowerOfThree(int n) {
        if (n == 0)return false;
        if (n == 1)return true;
        while(n%3==0){
            n = n/3;
        }
        return n==1;
    }

    /*
    4的幂
     */
    public static boolean isPowerOfFour(int num) {
        if (num == 0)return false;
        if (num == 1)return true;
        while(num%4==0){
            num = num/4;
        }
        return num==1;
    }

    public static void main(String[] args) {

    }
}
