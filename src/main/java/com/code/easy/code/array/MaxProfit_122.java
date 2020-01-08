package com.code.easy.code.array;

/**
 * 买卖股票的最佳时机2
 * @version v1.0
 * @ClassName: MaxProfit_122
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @Author: JW
 * @Date: 2020/1/6 23:38
 */
public class MaxProfit_122 {

    /**
     * 峰谷法
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int i = 0;
        int min;
        int max;
        int maxProfit  = 0;
        while (i<prices.length-1){
            while (i<prices.length-1 && prices[i] >= prices[i+1]) {
                i++;
            }
            min = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            max = prices[i];
            maxProfit += max-min;
        }
        return maxProfit ;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[]{1,2,3,4,5}));
    }

    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i=0;i<prices.length-1;i++) {
            if (prices[i+1] > prices[i]) {
                maxProfit += prices[i+1] - prices[i];
            }
        }
        return maxProfit;
    }
}
