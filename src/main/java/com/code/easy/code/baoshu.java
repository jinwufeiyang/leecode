package com.code.easy.code;

/**
 * Description
 * DATE 2019/2/26.
 *
 * @author daijinwu.
 */

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */
public class baoshu {
    public static void main(String[] args) {

        String s = bs(6);
        System.out.println(s);
    }

    /**
     * @param n
     * @return
     */
    public static String bs(int n) {
        String sum = "";
        if (n == 1) {
            return n + "";
        } else {
            String result = "";
            result = bs(n - 1);
            int count = 0;
            for (int i = 0; i < result.length(); i++) {
                if ((i + 1) < result.length() && String.valueOf(result.charAt(i)).equals(String.valueOf(result.charAt(i + 1)))) {
                    count++;
                } else {
                    count = count + 1;
                    sum = sum + count + String.valueOf(result.charAt(i));
                    count=0;
                }
            }
            return sum;
        }
    }
}
