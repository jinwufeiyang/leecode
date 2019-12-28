package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: ConvertToTitle_168
 * @Description: 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * @Author: JW
 * @Date: 2019/12/28 18:22
 */
public class ConvertToTitle_168 {
    /*
    不好理解
     */
    public static String convertToTitle(int n) {
        if(n==0) return "";
        String code = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
        StringBuilder buf = new StringBuilder();
        int remainder;
        while (n != 0) {
            remainder = n % 26;// 求余数
            n = n / 26;// 除以基数
            if (remainder == 0) {
                n--;
            }
            buf.append(code.charAt(remainder));
        }
        buf.reverse();
        return buf.toString();
    }

    /*
    这个比较好理解一点
     */
    private static String covert2(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n --;//这里稍作处理，因为它是从1开始
            stringBuilder.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(11));
    }
}
