package com.code.easy.code.str;

/**
 * @version v1.0
 * @ClassName: FindTheDifference_389
 * @Description:给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母
 * @Author: JW
 * @Date: 2020/1/4 21:55
 */
public class FindTheDifference_389 {
    public char findTheDifference(String s, String t) {
        int[] buckets = new int[26];
        for (int i=0;i<s.length();i++) {
            buckets[s.charAt(i) - 'a']++;
        }
        for (int i=0;i<t.length();i++) {
            if(--buckets[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return ' ';
    }

    public static char findTheDifference2(String s, String t) {
        for(Character c : s.toCharArray()){
            t = t.replaceFirst(c.toString(),"");
        }
        return t.toCharArray()[0];
    }


}
