package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: TitleToNumber_171
 * @Description: 给定一个Excel表格中的列名称，返回其相应的列序号
 * @Author: JW
 * @Date: 2019/12/27 23:00
 */
public class TitleToNumber_171 {

    /**
     * 只能处理两位以下的字母
     * @param s s
     * @return int
     */
    public static int titleToNumber(String s) {
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars = s.toCharArray();
        int result;
        if (chars.length == 1) {
            result = word.indexOf(s) + 1;
        } else {
            int index1 = word.indexOf(chars[0]) + 1;
            int index2 = word.indexOf(chars[1]) + 1;
            result = (index1 - 1) * 26 + index2 + 26;
        }
        return result;
    }

    /**
     * 精选题解
     * @param s s
     * @return int
     */
    public static int titleToNumber2(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    /**
     * 恩，我的也挺靠谱
     * @param s s
     * @return int
     */
    public static int titleToNumber3(String s) {
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = s.length();
        int result = 0;
        for (int i=0;i<length;i++) {
            int charIndex = word.indexOf(s.charAt(i)) + 1;
            result += Math.pow(26, length - 1 -i) * charIndex;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber3("AAA"));
    }
}
