package com.code.easy.code;

/**
 * 打家劫舍
 */
public class Rob_198 {

    /*
    动态规划：
       动态规划方程：dp[n] = Max(dp[n-1], dp[n-2] + num)
     */

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i=2; i<=length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[length];
    }

    public static int rob2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int maxRob = 0;
        int pre = 0;
        int cur = 0;
        for (int i=0;i<length;i++) {
            maxRob = Math.max(cur, pre + nums[i]);
            pre = cur;
            cur = maxRob;
        }
        return maxRob;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,5};
        System.out.println(rob2(nums));
    }

}
