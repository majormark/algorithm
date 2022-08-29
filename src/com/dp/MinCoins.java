package com.dp;

/**
 * 换钱的最少货币数
 */
public class MinCoins {
    public int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MAX_VALUE;
        int n = arr.length;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j < aim + 1; j++) {
            dp[0][j] = max;
            if (j >= arr[0] && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < aim + 1; j++) {
                int left = max;
                if (j >= arr[i] && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]];
                }
                dp[i][j] = Math.min(dp[i - 1][j], left);
            }
        }
        return dp[n - 1][aim] == max ? -1 : dp[n - 1][aim];
    }

    public int minCoin2(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        //dp[0] = 0;
        for (int j = 1; j < aim + 1; j++) {
            dp[j] = max;
            if (j >= arr[0] && dp[j - arr[0]] != max) {
                dp[j] = dp[j - arr[0]] + 1;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < aim + 1; j++) {
                int left = max;
                if (j >= arr[i] && dp[j - arr[i]] != max) {
                    left = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        return dp[aim] == max ? -1 : dp[aim];
    }

    public int minCoin3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int max = Integer.MAX_VALUE;
        int n = arr.length;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j < aim + 1; j++) {
            dp[0][j] = max;
            if (j == arr[0]) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < aim + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i] && dp[i - 1][j - arr[i]] != max) {
                    dp[i][j] = Math.min(dp[i - 1][j - arr[i]] + 1, dp[i][j]);
                }
            }
        }
        return dp[n-1][aim] == max ? -1 : dp[n-1][aim];
    }

    public int minCoin4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int max = Integer.MAX_VALUE;
        int n = arr.length;
        int[] dp = new int[aim+1];
        for (int j=1;j<aim+1;j++) {
            dp[j] = max;
        }
        if (aim >= arr[0]) {
            dp[arr[0]] = 1;
        }
        for (int i=1;i<n;i++) {
            for (int j=1;j<aim+1;j++) {
                int leftUp = max;
                if (j >= arr[i] && dp[j-arr[i]] != max) {
                    leftUp = dp[j-arr[i]] + 1;
                }
                dp[j] = Math.min(dp[j], leftUp);
            }
        }
        return dp[aim] == max ? -1 : dp[aim];
    }
}
