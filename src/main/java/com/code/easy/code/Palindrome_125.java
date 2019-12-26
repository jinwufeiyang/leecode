package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: Palindrome_125
 * @Description: 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
 * @Author: JW
 * @Date: 2019/12/25 23:59
 */
public class Palindrome_125 {

    /**
     * 验证字符串是否是回文串
     * @param s 待校验字符串
     * @return boolean
     */
    public static boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        char[] chars = s.toCharArray();
        int length = s.toCharArray().length;
        int i=0;
        int j = length - 1;
        while (i <= j) {
            if (!validChar(chars[i])) {
                i++;
                continue;
            }
            if (!validChar(chars[j])) {
                j--;
                continue;
            }
            if (isEqual(chars[i], chars[j])) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符是否相等【忽略大小写】
     * @param c1 c1
     * @param c2 c2
     * @return boolean
     */
    private static boolean isEqual(char c1, char c2) {
        if (String.valueOf(c1).equalsIgnoreCase(String.valueOf(c2))) {
            return true;
        }
        return false;
    }

    /**
     * 是否是特定字符
     * @param c c
     * @return boolean
     */
    private static boolean validChar(char c) {
        if (Utils.letterAndNums(c)) {
            return true;
        }
        return false;
    }




    public static void main(String[] args) {
        // C:67	 c:99
        System.out.println("C:" + (int)'C' + "\t c:" + (int)'c');
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
