package com.code.easy.code;

/**
 * Description
 * DATE 2019/2/28.
 *
 * @author daijinwu.
 */

/**
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 */
public class OHe {
    public static void main(String[] args) {
        int[] A= {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] b = sumEvenAfterQueries(A, queries);
        for (int j=0;j<b.length;j++) {
            System.out.print(j);
        }
    }

    private static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int size = A.length;
        int[] result = new int[size];
//        int[] qa = new int[size];
//        int[] qb = new int[size];
        int sum = getSum(A);
        for (int m=0;m<size;m++) {
//            A[queries[m][1]] += queries[m][0];
            int tem = queries[m][0];
            int index = queries[m][1];
            int t = A[index]+tem;
            if (Math.abs(t)%2==0) {
                sum+=t;
            }
            result[m] = sum;
//            A[queries[m][1]] = queries[m][0] + A[queries[m][1]];
//            queries[m][0] = getSum(A);
//            result[m] = getSum(A);
//            qa[m] = queries[m][0];
//            qb[m] = queries[m][1];
        }
//        for (int t=0;t<size;t++) {
//            A[qb[t]] = qa[t] + A[qb[t]] ;
//            result[t] = getSum(A);
//        }
//        return result;

        return result;
    }

    public static int getSum(int[] a) {
        int sum = 0;
        for (int i = 0;i<a.length;i++) {
            if (Math.abs(a[i])%2==0){
                sum += a[i];
            }
        }
        return sum;
    }

}
