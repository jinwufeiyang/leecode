package com.code.easy.code;

public class StrReserve_344 {

    public static void reverseString(char[] s) {
        int mid = (s.length - 0) / 2;
        for (int i=0; i<mid; i++) {
            swap(i,s.length, s);
        }
    }

    private static void swap(int startIndex, int endIndex, char[] s) {
        char start = s[startIndex];
        char end = s[endIndex-1-startIndex];
        s[startIndex] = end;
        s[endIndex - 1 - startIndex] = start;
    }

    public static void main(String[] args) {
        char[] chars = {'c', 's', 'd', 'y', 'e', 'h'};
//        char[] chars = new char[]{};
//        reverseString(chars);
        reverseString2(chars);
        st(chars);
    }

    /**
     * 方式2，时间空间上更优
     * @param s 数组
     */
    private static void reverseString2(char[] s) {
        int mid = (s.length - 0) / 2;
        for (int i=0, j=s.length-1-i; i<mid; i++,j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    private static void st(char[] chars) {
        for (char c : chars) {
            System.out.print(c + "\t");
        }
        System.out.println();
    }
}
