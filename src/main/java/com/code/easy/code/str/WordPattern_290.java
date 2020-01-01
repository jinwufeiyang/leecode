package com.code.easy.code.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version v1.0
 * @ClassName: WordPattern_290
 * @Description: 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律
 * @Author: JW
 * @Date: 2020/1/1 14:41
 */
public class WordPattern_290 {
    /*
输入: pattern = "abba", str = "dog cat cat dog"
输出: true
输入:pattern = "abba", str = "dog cat cat fish"
输出: false
     */
    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) {
            return true;
        }
        if (pattern == null || str == null) {
            return false;
        }
        String[] strings = str.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        int pIndex = 1;
        List<Integer> pList = new ArrayList<>();
        Map<Character, Integer> pMap = new HashMap<>();
        for (int i=0;i<pattern.length();i++) {
            if (!pMap.containsKey(pattern.charAt(i))) {
                pMap.put(pattern.charAt(i), pIndex);
                pList.add(pIndex);
                pIndex++;
            } else {
                pList.add(pMap.get(pattern.charAt(i)));
            }
        }
        int sIndex = 1;
        List<Integer> sList = new ArrayList<>();
        Map<String, Integer> sMap = new HashMap<>();
        for (int i=0;i<strings.length;i++) {
            if (!sMap.containsKey(strings[i])) {
                sMap.put(strings[i], sIndex);
                sList.add(sIndex);
                sIndex++;
            } else {
                sList.add(sMap.get(strings[i]));
            }
        }
        for (int i=0;i<pList.size();i++) {
            if (pList.get(i) != sList.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
    }

    public static boolean wordPattern2(String pattern, String str) {
        String[] s = str.split(" ");
        if (pattern.length() != s.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>(); //存放映射
        for (int i=0;i<s.length;i++) {
            if (!map.containsKey(pattern.charAt(i))) { //1. 没有映射时执行
                if (map.containsValue(s[i])) { //2. 没有映射的情况下s[i]已被使用，则不匹配返回false
                    return false;
                } else { //3. 构建映射
                    map.put(pattern.charAt(i), s[i]);
                }
            } else {
                if(!map.get(pattern.charAt(i)).equals(s[i])) return false; //当前字符串与映射不匹配,返回false
            }
        }
        return true;
    }

    /*
    还可以使用indexOf() 函数来判断每个模式串的每个字符的indexof，以及字符串每个字符串对应的indexof，相等true，否则false
     */
    public boolean wordPattern3(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) return false;
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            if(pattern.indexOf(pattern.charAt(i)) != indexOf(arr, arr[i])){
                return false;
            }
        }
        return true;
    };

    public static int indexOf(String[] arrays, String searchString) {
        int ans = -1;
        for(int i = 0; i < arrays.length; i++) {
            if (arrays[i].equals(searchString)) {
                ans = i;
                break;
            };
        };
        return ans;
    }

}
