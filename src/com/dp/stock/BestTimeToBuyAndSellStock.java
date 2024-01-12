package com.dp.stock;

public class BestTimeToBuyAndSellStock {
    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int rightMax = prices[n - 1];
        int maxDiff = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            maxDiff = Math.max(maxDiff, rightMax - prices[i]);
            rightMax = Math.max(rightMax, prices[i]);
        }
        return maxDiff;
    }

    // 122. Best Time to Buy and Sell Stock II
    public int maxProfit2(int[] prices) {
        int min = 10001;
        int max = -1;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]);
            if (i + 1 < prices.length && prices[i + 1] < prices[i]) {
                profit += max - min;
                min = 10001;
                max = -1;
            }
        }
        if (max == prices[prices.length - 1]) {
            profit += max - min;
        }
        return profit;
    }

    //123. Best Time to Buy and Sell Stock III
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        // 列状态: 0 不操作，1 第一次买入，2 第一次卖出，3第二次买入，4 第二次卖出
        int[][] dp = new int[n][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[n - 1][4];
    }

    //188. Best Time to Buy and Sell Stock IV
    public int maxProfit4(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2 * k + 1];
        for (int i = 1; i < dp[0].length; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < dp[0].length; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
            }
            for (int j = 2; j < dp[0].length; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
            }
        }
        return dp[n - 1][2 * k];
    }

    //309. Best Time to Buy and Sell Stock with Cooldown
    public int maxProfit5(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    // 714. Best Time to Buy and Sell Stock with Transaction Fee
    public int maxProfit6(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[n - 1][1];
    }
}
