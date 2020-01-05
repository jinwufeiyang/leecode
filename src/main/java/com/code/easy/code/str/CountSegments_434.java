package com.code.easy.code.str;

/**
 * @version v1.0
 * @ClassName: CountSegments_434
 * @Description: 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符
 * @Author: JW
 * @Date: 2020/1/5 17:17
 */
public class CountSegments_434 {
    public static int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

    public static void main(String[] args) {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }
}
