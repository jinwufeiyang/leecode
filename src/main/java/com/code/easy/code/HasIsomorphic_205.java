package com.code.easy.code;

import java.util.HashMap;

/**
 * @version v1.0
 * @ClassName: HasIsomorphic_205
 * @Description: 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身
 * @Author: JW
 * @Date: 2019/12/29 15:59
 */
public class HasIsomorphic_205 {

    /*
    高效算法：通过第三方来解决，按照字母出现的顺序，把两个字符串都映射到另外一个集合中。
    比如：一个人说韩文，一个人说日文，怎么知晓表达的是不是同一个意思，只需要把韩文和日文都转换为中文，看看最后是不是一样就好了。
     */
    public static boolean isIsomorphic(String s, String t) {
        return isIsomorphic(s).equals(isIsomorphic(t));
    }

    private static String isIsomorphic(String s) {
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i=0;i<n;i++) {
            char c = s.charAt(i);
            //当前字母是第一次出现,赋值
            if (map[c] == 0) {
                count++;
                map[c] = count;
            }
            sb.append(map[c]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "titleh"));
    }

    /*
    方式2：我们可以利用一个 map 来处理映射。对于 s 到 t 的映射，我们同时遍历 s 和 t ，假设当前遇到的字母分别是 c1 和 c2 。
    如果 map[c1] 不存在，那么就将 c1 映射到 c2 ，即 map[c1] = c2。
    如果 map[c1] 存在，那么就判断 map[c1] 是否等于 c2，也就是验证之前的映射和当前的字母是否相同。
     */
    public boolean isIsomorphic2(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }

}
