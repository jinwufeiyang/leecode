package com.code.easy.code;

/**
 * @version v1.0
 * @ClassName: Utils
 * @Description: 工具类
 * @Author: JW
 * @Date: 2019/12/26 22:01
 */
public class Utils {
    /*
    匹配由26个英文字母组成的字符串
     */
    public static boolean isCapital(char c) {
        return String.valueOf(c).matches("^[A-Z]+$");
    }

    /*
    匹配由26个英文字母的小写组成的字符串
     */
    public static boolean lowerCase(char c) {
        return String.valueOf(c).matches("^[a-z]+$");
    }

    /*
    匹配由26个英文字母组成的字符串
     */
    public static boolean bigLowerLetter(char c) {
        return String.valueOf(c).matches("^[A-Za-z]+$");
    }

    /*
    匹配由数字和26个英文字母组成的字符串
     */
    public static boolean letterAndNums(char c) {
        return String.valueOf(c).matches("^[A-Za-z0-9]+$");
    }

}
