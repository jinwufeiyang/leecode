package com.code.easy.code;

/**
 * Description
 * DATE 2019/2/27.
 *
 * @author daijinwu.
 */

/**
 * 最后一个单词的长度
 */
public class StrMaxLength {
    public static void main(String[] args) {
        String s = "a";
        int length = getMaxStr(s);
        System.out.println(length);
    }

    private static int getMaxStr(String s) {
        String[] split = s.split(" ");
        int size = split.length;
//        if (size==1) {
//            return 0;
//        } else {
//            return split[size-1].length();
//        }
        return size;
    }
}
