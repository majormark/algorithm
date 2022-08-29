package com.dp;

public class ChangeCoinMethodNum {
    public int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }
    public int process(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        } else {
            for (int i=0;arr[index] * i <= aim;i++) {
                res += process(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length+1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    public int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i=0;arr[index] * i <= aim;i++) {
                int value = map[index+1][aim - arr[index] * i];
                if (value != 0) {
                    res += value == -1 ? 0 : value;
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        map[index][aim] = res;
        return res;
    }

    public int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n][aim + 1];
        for (int i=0;i<n;i++) {
            dp[i][0] = 1;
        }
        for (int j=1;arr[0] * j<aim + 1;j++) {
            dp[0][arr[0] * j] = 1;
        }
        for (int i=1;i<n;i++) {
            for (int j=1;j< aim + 1;j++) {
                int left = 0;
                if (j >= arr[i]) {
                    for (int k=0;arr[i] * k <= j;k++) {
                        left += dp[i-1][j - arr[i] * k];
                    }
                }
                dp[i][j] = left;
            }
        }
        return dp[n-1][aim];
    }

    public int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n][aim + 1];
        for (int i=0;i<n;i++) {
            dp[i][0] = 1;
        }
        for (int j=1;arr[0] * j <= aim;j++) {
            dp[0][arr[0] * j] = 1;
        }
        for (int i=1;i<n;i++) {
            for (int j=1;j<aim + 1;j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] += j >= arr[i] ? dp[i][j-arr[i]] : 0;
            }
        }
        return dp[n-1][aim];
    }

    public int coins5(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int n = arr.length;
        int[] dp = new int[aim + 1];
        dp[0] = 1;
        for (int j=1;arr[0] * j <= aim;j++) {
            dp[arr[0] * j] = 1;
        }
        for (int i=1;i<n;i++) {
            for (int j=1;j<aim+1;j++) {
                dp[j] += j >= arr[i] ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }
}
