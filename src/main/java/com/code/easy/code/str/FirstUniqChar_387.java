package com.code.easy.code.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @ClassName: FirstUniqChar_387
 * @Description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。您可以假定该字符串只包含小写字母。
 * @Author: JW
 * @Date: 2020/1/4 21:50
 */
public class FirstUniqChar_387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i=0;i<length;i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i=0;i<length;i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
