package com.code.easy.code.str;

/**
 * 赎金信
 * @version v1.0
 * @ClassName: CanConstruct_383
 * @Description: 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * @Author: JW
 * @Date: 2020/1/4 19:43
 */
public class CanConstruct_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int length1 = ransomNote.length();
        int length2 = magazine.length();
        if (length1 > length2) {
            return false;
        }
        int[] buckets = new int[26];
        for(int i = 0; i < length2; i++) {
            buckets[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0; i < length1; i++) {
            if(--buckets[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
