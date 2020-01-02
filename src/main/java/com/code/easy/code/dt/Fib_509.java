package com.code.easy.code.dt;

public class Fib_509 {
    /**
     * 递归实现
     * @param N n
     * @return int
     */
    public static int fib(int N) {
        if (N < 2) {
            return N;
        }
        return fib(N-1) + fib(N-2);
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    /*
    记忆化自底向上算法
     */
    public int fib2(int N) {
        if (N < 1) {
            return N;
        }
        return memoize(N);
    }

    private int memoize(int N) {
        int[] cache = new int[N + 1];
        cache[1] = 1;
        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[N];
    }
}
