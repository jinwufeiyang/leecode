package com.code.easy.code;

import java.util.Arrays;

/**
 * @version v1.0
 * @ClassName: CountPrimes_204
 * @Description: 统计所有小于非负整数 n 的质数的数量。
 * @Author: JW
 * @Date: 2019/12/29 14:43
 */
public class CountPrimes_204 {

    /**
     * 暴力方法，效率不高
     * @param n n
     * @return int
     */
    public static int countPrimes(int n) {
        int count = 0;
        for (int i=2;i<n;i++) {
            boolean flag = isPrimes(i);
            if (flag) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrimes(int n) {
        for (int i=2;i*i<=n;i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes3(10));
    }

    public static int countPrimes2(int n) {
        //数组1表示是素数，0表示不是素数
        //定义同大小的数组，然后初始化为1，
        int[] nums = new int[n];
        for (int i=0;i<n;i++) {
            nums[i] = 1;
        }
        //遍历数组，所有素数倍数的全都置为0
        for (int i=2;i<n;i++) {
            if (nums[i] == 1) {
                for (int j=2;i*j<n;j++) {
                    if (nums[i*j] == 1) {
                        nums[i*j] = 0;
                    }
                }
            }
        }
        //统计等于1的数量即为素数的数量
        int count = 0;
        for (int i=2;i<n;i++) {
            if (nums[i] == 1) {
                count++;
            }
        }
        return count;
    }


    /*
    Sieve of Eratosthenes 算法
     */
    public static int countPrimes3(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i=2;i*i<n;i++) {
            if (isPrim[i]) {
                for (int j = i*i;j<n;j+=i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int k=2;k<n;k++) {
            if (isPrim[k]) {
                count++;
            }
        }
        return count;
    }

}
