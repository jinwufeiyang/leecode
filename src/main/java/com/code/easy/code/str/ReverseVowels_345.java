package com.code.easy.code.str;

import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: ReverseVowels_345
 * @Description: 编写一个函数，以字符串作为输入，反转该字符串中的元音字母
 * @Author: JW
 * @Date: 2020/1/1 19:00
 */
public class ReverseVowels_345 {

    /*
    超时
     */
    public static String reverseVowels(String s) {
        String y = "aeiouAEIOU";
        //存储元音字母下标和值
        List<Character> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        //遍历塞值到map集合
        for (int i=0;i<s.length();i++) {
            if (y.indexOf(s.charAt(i)) != -1) {
                list.add(s.charAt(i));
                sb.append("#");
                continue;
            }
            sb.append(s.charAt(i));
        }
        int size = list.size();
        String rs = sb.toString();
        for (int i=size-1;i>=0;i--) {
            rs = rs.replaceFirst("#", list.get(i).toString());
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels2("leetcode"));
    }

    /*
    双向指针转换
     */
    public static String reverseVowels2(String s) {
        int length = s.length();
        int left = 0;
        int right = length - 1;
        String y = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        Character temp;
        while (left < right) {
            if ((y.indexOf(chars[left]) != -1) && y.indexOf(chars[right]) != -1) {
                temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            } else if (y.indexOf(chars[left]) == -1) {
                left++;
            } else {
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
