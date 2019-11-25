package kmp;

/**
 * @Author: dj
 * @Date: 2019/11/24 0:23
 * @Version 1.0
 */
public class Kmp {


    /**
     * 通过计算返回子串T的next数组
     * @param T 模式子串
     * @param next next数组
     */
    private void getNext(String T, int[] next) {
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < T.length() - 1) {
            //k表示前缀，j表示后缀
            if (k == -1 || T.charAt(j) == T.charAt(k))
            {
                ++k;
                ++j;
                next[j] = k;
            }
            else
            {
                k = next[k];
            }

        }
    }

    /**
     * 对next数组优化
     * 通过计算返回子串T的nextVal数组
     * @param T 模式子串
     * @param nextVal nextVal数组
     */
    private void getNextVal(String T, int[] nextVal) {
        nextVal[0] = -1;
        int k = -1;
        int j = 0;
        while (j < T.length() - 1) {
            //k表示前缀，j表示后缀
            if (k == -1 || T.charAt(j) == T.charAt(k))
            {
                ++k;
                ++j;
                if (T.charAt(j) != T.charAt(k)) {
                    nextVal[j] = k;
                } else {
                    nextVal[j] = nextVal[k];
                }
            }
            else
            {
                k = nextVal[k];
            }

        }
    }

    /**
     * 返回子串t在主串s中第pos个字符之后的位置。不存在，则函数返回-1
     * @param s 主串
     * @param t 子串
     * @param pos 第几位开始查询
     * @return 首位
     */
    private int Index_KMP(String s, String t, int pos) {
        int i = pos;
        int j = 0;
        int sLen = s.length();
        int tLen = t.length();

        int[] next = new int[t.length()];
        getNext(t, next);

        while (i < sLen && j < tLen) {
            //如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j==-1 || s.charAt(i) == t.charAt(j)) {
                ++i;
                ++j;
            } else {
                //如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        System.out.println("下标j:" + j);
        if (j == tLen) {
            if (pos != 0) {
                return i - j -pos;
            }
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Kmp k = new Kmp();
        String T = "ABCDABD";
        String S = "BBC ABCDAB ABCDABCDABDE";
        System.out.println(k.Index_KMP(S,T,0));
        System.out.println("----------------");
        int[] next = new int[T.length()];
        k.getNext(T, next);
        for (int i = 0; i < next.length; i++) {
            System.out.println(T.charAt(i) + "--:" + i + ":" + next[i]);
        }
        System.out.println("----------------");
        int[] nextVal = new int[T.length()];
        k.getNextVal(T, nextVal);
        for (int i = 0; i < nextVal.length; i++) {
            System.out.println(T.charAt(i) + "--:" + i + ":" + nextVal[i]);
        }
    }

}
