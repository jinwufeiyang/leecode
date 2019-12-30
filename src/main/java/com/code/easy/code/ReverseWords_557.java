package com.code.easy.code;

public class ReverseWords_557 {

    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<split.length;i++) {
            String s1 = split[i];
            sb.append(reverseWord(s1)).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    private static String  reverseWord(String word) {
        StringBuilder rev = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            rev.append(word.charAt(i));
        }
        return rev.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

}
