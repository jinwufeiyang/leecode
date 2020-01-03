package com.code.easy.code.str;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

/*
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class AddStrings_415 {

    /**
     * 很帅很巧妙
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;
        int carry = 0;
        while (length1 >= 0 || length2 >= 0) {
            int n1 = length1 >= 0 ? num1.charAt(length1) - '0' : 0;
            int n2 = length2 >= 0 ? num2.charAt(length2) - '0' : 0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            result.append(temp%10);
            length1--;
            length2--;
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings2("4", "69"));
    }


    /**
     * 最朴素算法
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings2(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;
        int carry = 0;
        while (length1>=0&&length2>=0) {
            int sum = (num1.charAt(length1) - '0') + (num2.charAt(length2) - '0') + carry;
            if (sum>=10) {
                carry = 1;
                sum=sum%10;
            } else {
                carry = 0;
            }
            result.append(sum);
            length1--;
            length2--;
        }
        while (length1 >= 0) {
            if (carry == 1) {
                int sum = (num1.charAt(length1) - '0') + 1;
                if (sum >= 10) {
                    sum=sum%10;
                } else {
                    carry = 0;
                }
                result.append(sum);
            } else {
                int sum = num1.charAt(length1) - '0';
                result.append(sum);
            }
            length1--;
        }
        while (length2 >= 0) {
            if (carry == 1) {
                int sum = (num2.charAt(length2) - '0') + 1;
                if (sum >= 10) {
                    sum=sum%10;
                } else {
                    carry = 0;
                }
                result.append(sum);
            } else {
                int sum = num2.charAt(length2) - '0';
                result.append(sum);
            }
            length2--;
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

}
