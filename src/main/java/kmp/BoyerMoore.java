package kmp;

/**
 * Description
 * DATE 2019/11/26.
 *
 * @author daijinwu.
 */
public class BoyerMoore {


    private int SIZE = 256;

    public static void main(String[] args) {
        BoyerMoore bm = new BoyerMoore();
        bm.BM("bcababab", "bcabababbcababab");
    }

    private void BM(String pattern, String text) {
        int i,j = 0;
        int m = pattern.length();
        int n = text.length();
        int[] bmBc = new int[SIZE];
        int[] bmGs = new int[m];
        //处理坏字符算法
        preBmBc(pattern, m, bmBc);
        System.out.println("c = " + bmBc['c']);
        //处理好后缀算法
        preBmGs(pattern, m, bmGs);

        while (j <= n - m) {
            for (i = m - 1;i >= 0 && pattern.charAt(i) == text.charAt(i + j); --i){}
            if (i < 0) {
                System.out.println(" find it index: " + j);
                return;
            } else {
                j += Math.max(bmGs[i], bmBc[text.charAt(i)] - (m - 1 -i));
            }

        }

        System.out.println("result is not find");
    }

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

        System.out.println("----------- ");
        for (int k = 0;k<m;k++) {
            System.out.println("k = " + k + "\t value = " + suff[k]);
        }
        System.out.println("----------- ");

        /**
         * 全部初始为自己的长度，处理第三种情况
         */
        for (i = 0;i<m;i++) {
            bmGs[i] = m;
        }

        // 处理第二种情况
        j = 0;
        for (i = m - 1;i>=0;i--) {
            //找到合适位置
            if (suff[i] == i+1) {
                for (;j<m-1-i;j++) {
                    //保证每个位置最多只能被修改一次
                    if (bmGs[j] == m) {
                        bmGs[j] = m-1-i;
                    }
                }
            }
        }

        //处理第一种情况，顺序是从前到后
        for (i = 0; i<m-1;i++) {
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
