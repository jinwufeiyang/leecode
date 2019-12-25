package com.code.easy.code;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StockProfit_121 {

    private static int maxProfit(int[] prices) {
        int maxPrice = 0;
        if (prices.length> 0) {
            Map<String, Integer> map = new HashMap<>();
            for (int i=0; i<prices.length; i++) {
                for (int j=i+1; j<prices.length; j++) {
                    if (prices[i] < prices[j]) {
                        continue;
                    }
                    String key = prices[i] + "-" + prices[j];
                    if (!map.containsKey(key)) {
                        map.put(key, prices[j] - prices[i]);
                    }
                }
            }
            Integer result = map.values().stream().max(Comparator.comparingInt(Integer::intValue)).orElse(0);
            if (result > maxPrice) {
                maxPrice = result;
            }
        }

        return maxPrice;
    }

    /**
     * 暴力破解
     * @param prices 数组
     * @return int
     */
    private static int maxProfit2(int[] prices) {
        int maxPrice = 0;
        for (int i=0; i<prices.length; i++) {
            for (int j=i+1; j<prices.length; j++) {
                int maxResult = prices[j] - prices[i];
                if (maxResult > maxPrice) {
                    maxPrice = maxResult;
                }
            }
        }
        return maxPrice;
    }

    /**
     * 遍历数据找到最小值，然后查找该最小值后相差最大的值
     * @param prices 数组
     * @return int
     */
    private static int maxProfit3(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int temp = prices[i] - minPrice;
                if (temp > maxProfit) {
                    maxProfit = temp;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{12,4,2,3}));
    }

}
