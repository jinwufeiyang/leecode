package com.code.easy.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @ClassName: IsAnagram_242
 * @Description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 * @Author: JW
 * @Date: 2019/12/30 23:04
 */
public class IsAnagram_242 {

    /**
     * 理解错题目意思。。。看下面的方案
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char st = '\0',tt = '\0';
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (st != '\0') {
                    if (st == t.charAt(i) && tt == s.charAt(i)) {
                        st = '\0';
                        tt = '\0';
                    } else {
                        return false;
                    }
                } else {
                    st = s.charAt(i);
                    tt = t.charAt(i);
                }
            }
        }
        //如果最后一个字母刚好不相等循环也刚好结束，此时st、tt都是有值的，所以需要判断下两者是否相等
        if (st != tt) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram2("aacc", "ccac"));
    }

    /*
    哈希：比较菜的算法
     */
    public static boolean isAnagram2(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                count++;
                map.put(s.charAt(i), count);
            } else {
                map.put(s.charAt(i), 1);
            }
            if (tm.containsKey(t.charAt(i))) {
                int tc = tm.get(t.charAt(i));
                tc++;
                tm.put(t.charAt(i), tc);
            } else {
                tm.put(t.charAt(i), 1);
            }
        }
        if (map.keySet().containsAll(tm.keySet())) {
            for (Character character : map.keySet()) {
                if (!map.get(character).equals(tm.get(character))) {
                    return false;
                }
            }
        }  else {
            return false;
        }
        return true;
    }

    /*
    排序：将当前两个字符串排序过后，生成的字符串是相同的，如果不同，那就是不想等。
     */
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /*
    哈希表：
    1、为了检查 tt 是否是 ss 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。因为 SS 和 TT 都只包含 A-ZA−Z 的字母，所以一个简单的 26 位计数器表就足够了
    2、们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 ss 字母的频率，用 tt 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零
     */
    public boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    /*
    哈希表：或者我们可以先用计数器表计算 ss，然后用 tt 减少计数器表中的每个字母的计数器。如果在任何时候计数器低于零，我们知道 tt 包含一个不在 ss 中的额外字母，并立即返回 FALSE
     */
    public boolean isAnagram5(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
