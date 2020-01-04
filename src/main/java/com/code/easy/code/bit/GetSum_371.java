package com.code.easy.code.bit;

/**
 * @version v1.0
 * @ClassName: GetSum_371
 * @Description: 不使用运算符 + 和 - ，计算两整数 a 、b之和。
 * @Author: JW
 * @Date: 2020/1/4 16:40
 */
public class GetSum_371 {

    /*
    位运算
     */
    public static int getSum(int a, int b) {
        int sum = a, carry = b;
        while (carry != 0) {
            int temp = sum ^ carry;
            carry = (sum&carry)<<1;
            sum = temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(-2,3));
    }
}
