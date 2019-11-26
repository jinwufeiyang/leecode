package kmp;

/**
 * Description
 * DATE 2019/11/26.
 *
 * @author daijinwu.
 */
public class BoyerMoore {


    private int SIZE = 256;

    /**
     * 计算坏字符数组bmBc[]
     * 如果字符在模式串中出现，bmBc['v'] 表示字符v在模式中最后一次出现的位置，距离模式串串尾的长度
     * 如果字符未出现在模式串中，则bmBc['v'] 等于模式串长度
     *
     * 这里数组下标为字符串：因为如果字符在模式串中出现多处，而我们需要的是最右边的位置。这样通过字符作为下标就可以解决重复出现多次的问题。
     * @param pattern 模式串
     * @param m 模式串长度
     * @param bmBc 模式串对应字符数组集
     */
    private void preBmBc(String pattern, int m, int bmBc[]) {
        for (int i = 0; i<256;i++) {
            bmBc[i] = m;
        }
        for (int i = 0; i<m-1;i++) {
            bmBc[pattern.charAt(i)] = m-1-i;
        }
    }

    private void preBmGs(String pattern, int m, int bmGs[]) {
        int i,j;
        int[] suff =  new int[256];
        //计算后缀数组
        suffix(pattern, m , suff);

        /**
         * 先赋值为m，包含case3
         */
        for (i = 0;i<m;i++) {
            bmGs[i] = m;
        }

        // case2
        j = 0;
        for (i = m - 1;i>=0;i--) {
            if (suff[i] == i+1) {
                for (;j < m-1-i;j++) {
                    if (bmGs[j] == m) {
                        bmGs[j] = m - 1-i;
                    }
                }
            }
        }
        //case1
        for (i = 0; i<m-2;i++) {
            bmGs[m-1-suff[i]] = m-1-i;
        }


    }


    /**
     * 辅助数组suff[] 表示好后缀的长度
     *
     * suff[i]就是求pattern中以i位置字符为后缀和以最后一个字符为后缀的公共后缀串的长度。
     * @param pattern 模式串
     * @param m 模式串长度
     * @param suff 辅助数组
     */
    private void suffix(String pattern, int m, int[] suff) {
        int i,j;

        suff[m-1] = m;

        for (i = m-2;i>=0;i--) {
            j = i;
            while (j>=0 && pattern.charAt(j) == pattern.charAt(m-1-i+j)) {
                j--;
            }
            suff[i] = i - j;
        }
    }

}
