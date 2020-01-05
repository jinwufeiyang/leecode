package com.code.easy.code.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文串
 * @version v1.0
 * @ClassName: LongestPalindrome_409
 * @Description: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串
 * @Author: JW
 * @Date: 2020/1/5 14:56
 */
public class LongestPalindrome_409 {

    /**
     * 借助map实现成对出现就删除
     * 出现一对就从map删除，最后留下的就是单个的数量
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            if (map.get(s.charAt(i)) != null) {
                if (map.get(s.charAt(i)) == 1) {
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        //map集合等于0，说明该字符串全部成对出现，即字符串长度等于回文串长度
        if (map.size() == 0){
            return s.length();
        }
        //map集合等于字符串长度，即说明全都是单个出现，那么长度即为某一个字符
        if (map.size() == s.length()){
            return 1;
        }
        int num = s.length() - map.keySet().size();
        return num > 0 ? num + 1 : num;
    }

    public static void main(String[] args) {

    }

    /**
     * 官方贪心：
     *
     * 对于每个字母，假设它出现了 v 次。我们可以让 v // 2 * 2 个字母左右对称。例如，对于字符串 'aaaaa'，
     * 其中 'aaaa' 是左右对称，其长度为 5 // 2 * 2 = 4。
     *
     * 最后，如果有任何一个满足 v % 2 == 1 的 v，那么这个字符就可能是回文串中唯一的那个中心。针对这种情况，
     * 我们需要判断 v % 2 == 1 && ans % 2 == 0，后面的判断主要是为了防止重复计算
     * @param s
     * @return
     */
    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

}
