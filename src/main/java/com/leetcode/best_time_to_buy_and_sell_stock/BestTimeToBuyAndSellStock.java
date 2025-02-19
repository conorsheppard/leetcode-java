package com.leetcode.best_time_to_buy_and_sell_stock;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        var minPrice = Integer.MAX_VALUE;
        var maxProfit = 0;

        for (var price : prices) {
            if (price < minPrice) minPrice = price;
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
