package com.code.easy.code;

/*
 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。

J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 */
public class JewelsInStonesNum_771 {

    public static int numJewelsInStones(String J, String S) {
        int sLength = S.length();
        int jLength = J.length();
        if (sLength == 0 || jLength == 0) {
            return 0;
        }
        for (int i=0; i<jLength; i++) {
            S = S.replaceAll(J.substring(i, i+1), "");
        }
        return sLength - S.length();
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA",
                "aAAbbbb"));
    }
}
