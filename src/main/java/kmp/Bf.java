package kmp;

/**
 * Description
 * 字符串朴素算法--暴力破解
 * DATE 2019/11/27.
 *
 * @author daijinwu.
 */
public class Bf {
    public static void main(String[] args) {
        String s = "ABCDABABHNABA";
        String p = "ABAB";
        int index = bf(s, p);
        System.out.println("find it index = " + index);
    }

    private static int bf(String text, String pattern) {
        int result = -1;
        int tl = text.length();
        int pl = pattern.length();
        if (text == null || tl == 0) {
            return result;
        }
        if (pattern == null || pl == 0) {
            return result;
        }
        if (tl < pl) {
            return result;
        }

        int i,j;
        for (i=0,j=0; i< tl && j< pl;) {
            if (text.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
            } else {
                i = i - j + 1;
                j = 0;
                //一旦开始从pattern头开始比较的时候，source后面待匹配的长度应该至少大于pattern的长度
                if(i > tl - pl) {
                    break;
                }
            }
        }

        if(j == pl) {
            result = i - j;
        }

        return result;
    }

}
