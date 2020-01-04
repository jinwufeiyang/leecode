package com.code.easy.code.str;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version v1.0
 * @ClassName: IsSubsequence_392
 * @Description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）
 * @Author: JW
 * @Date: 2020/1/4 22:14
 */
public class IsSubsequence_392 {

    /**
     * 超时，算法 性能不好
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            List<Integer> list = map.getOrDefault(c, new LinkedList<>());
            list.add(i);
            map.put(c, list);
        }
        int temp = -1;
        for (int i=0;i<s.length();i++) {
            if (map.getOrDefault(s.charAt(i), new LinkedList<>()).size() == 0) {
                return false;
            } else {
                List<Integer> list = map.get(s.charAt(i));
                int j=0;
                for (;j<list.size();j++) {
                    if (list.get(j) > temp) {
                        temp = list.get(j);
                        break;
                    }
                }
                if (j==list.size()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc",
                "ahbgdc"));
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {
        int index = 0,i = 0;
        while(index < s.length() && t.indexOf(s.charAt(index),i) >= i){
            i = t.indexOf(s.charAt(index),i) + 1;
            index++;
        }
        return index == s.length();
    }

}
