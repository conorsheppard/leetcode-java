package com.leetcode.best_time_to_buy_and_sell_stock;

import org.junit.jupiter.api.Test;

import static com.leetcode.best_time_to_buy_and_sell_stock.BestTimeToBuyAndSellStock.maxProfit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockTest {
    @Test
    public void testCase1() {
        var prices = new int[]{7, 1, 5, 3, 6, 4};

        assertEquals(5, maxProfit(prices));
    }


    @Test
    public void testCase2() {
        var prices = new int[]{7, 6, 4, 3, 1};

        assertEquals(0, maxProfit(prices));
    }
}
