package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: AddDigits_258
 * @Description: 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数
 * @Author: JW
 * @Date: 2019/12/31 0:06
 */
public class AddDigits_258 {
    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num = num / 10;
        }
        return addDigits(result);
    }

    public static void main(String[] args) {

    }

    /**
     * todo
     * @param num
     * @return
     */
    public int addDigits2(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }

}
