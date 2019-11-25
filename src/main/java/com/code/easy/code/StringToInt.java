package com.code.easy.code;

import java.util.regex.Pattern;

/**
 * Description
 * DATE 2019/11/14.
 *
 * @author daijinwu.
 */
public class StringToInt {

    /**
     * best
     * @param str str
     * @return int
     */
    public static int checkValue(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int firstParam = 0;
        int flag = 1;
        if (str.charAt(0) == '+') {
            firstParam = 1;
        } else if (str.charAt(0) == '-') {
            firstParam = 1;
            flag = -1;
        } else if (str.charAt(0) < '0' || str.charAt(0) > '9') {
            return 0;
        }

        int result = 0;
        while (firstParam < str.length()) {
            if (str.charAt(firstParam) < '0' || str.charAt(firstParam) > '9') {
                break;
            }
            int ans = str.charAt(firstParam) - '0';
            if (flag == -1 && (result * flag < Integer.MIN_VALUE / 10 || (result * flag == Integer.MIN_VALUE / 10 && ans > 8))) {
                return Integer.MIN_VALUE ;
            }
            if (flag == 1 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && ans > 7))) {
                return Integer.MAX_VALUE ;
            }
            result = result * 10 + ans;
            firstParam++;
        }

        return result * flag;
    }

    public static int myAtoi(String str) {
        str = str.trim();
        char[] array = str.toCharArray();
        if (Pattern.compile("^(\\-|\\+)?\\d+(\\.\\d+)?$").matcher(str).matches()) {
            try {
                return Double.valueOf(str).intValue();
            } catch (Exception e) {
                return -2147483648;
            }
        } else {
            int length = array.length;
            if (length > 0) {
                if (length > 1) {
                    if (Pattern.compile("^[0-9]*$").matcher(String.valueOf(array[0])).matches()) {
                        int codeValue = codeValue(str);
                        if (codeValue == -2147483648) {
                            return 2147483647;
                        }
                        return codeValue;
                    } else {
                        if (Pattern.compile("\\+").matcher(String.valueOf(array[0])).matches() ||
                                Pattern.compile("\\-").matcher(String.valueOf(array[0])).matches()) {
                            if (!Pattern.compile("^[0-9]*$").matcher(String.valueOf(array[1])).matches()) {
                                return 0;
                            }
                            if (Pattern.compile("\\-").matcher(String.valueOf(array[0])).matches()) {
                                return 0-codeValue(str.replace(String.valueOf(array[0]), ""));
                            }
                            int codeValue = codeValue(str.replace(String.valueOf(array[0]), ""));
                            if (codeValue == -2147483648) {
                                return 2147483647;
                            }
                            return codeValue;
                        } else {
                            return 0;
                        }
                    }

                }
                return codeValue(str);
            }
        }
        return 0;
    }

    private static int codeValue(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        for (char cc : charArray
             ) {
            if (Pattern.compile("^[0-9]*$").matcher(String.valueOf(cc)).matches()) {
                sb.append(cc);
            } else {
                break;
            }
        }
        try {
            if (sb.toString().toCharArray().length > 0) {
                return Integer.valueOf(sb.toString());
            }
            return 0;
        } catch (Exception e) {
            return -2147483648;
        }
    }

    public static void main(String[] args) {
        System.out.println("args = " + myAtoi("       +19574n"));
    }
}
