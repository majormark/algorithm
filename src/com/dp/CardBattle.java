package com.dp;

public class CardBattle {
    public int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), ss(arr, 0, arr.length - 1));
    }

    public int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + ss(arr, i + 1, j), arr[j] + ss(arr, i, j - 1));
    }

    public int ss(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.max(arr[i] + f(arr, i + 1, j), arr[j] + f(arr, i, j - 1));
    }

    public int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];
        for (int j=0;j<n;j++) {
            f[j][j] = arr[j];
            for (int i=j-1;i>=0;i--) {
                f[i][j] = Math.max(arr[i] + s[i+1][j], arr[j] + s[i][j-1]);
                s[i][j] = Math.max(arr[i] + f[i+1][j], arr[j] + f[i][j-1]);
            }
        }
        return Math.max(f[0][n-1], s[0][n-1]);
    }
}
