package com.dp;

import java.util.Arrays;

/**
 * 最长递增子序列
 */
public class LongestIncreasingSequence {

    public static int sequence(int[] a, int n) {
        int len = 1;
        int[] d = new int[n];
        for (int i=0;i<n;i++) {

            d[i] = 1;
            for (int j=0;j<i;j++) {
                if (a[j] <= a[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
            if (d[i] > len)
                len = d[i];
        }
        System.out.println("d[]: " + Arrays.toString(d));
        return len;
    }

    public int[] lis1(int[] arr) {
        int[] dp = getDp1(arr);
        return generateLIS(arr, dp);
    }
    public int[] generateLIS(int[] arr, int[] dp) {
        int maxPos = 0;
        for (int i=0;i<arr.length;i++) {
            if (dp[i] > dp[maxPos]) {
                maxPos = i;
            }
        }
        int sn = dp[maxPos];
        int[] seq = new int[sn];
        int idx = sn - 1;
        seq[idx--] = arr[maxPos];
        for (int i=maxPos;i>=0;i--) {
            if (arr[i] < arr[maxPos] && dp[i] == dp[maxPos] - 1) {
                seq[idx--] = arr[i];
                maxPos = i;
            }
        }
        return seq;
    }
    public int[] getDp1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int n = arr.length;
        int[] dp = new int[n];
        for (int i=0;i<n;i++) {
            dp[i] = 1;
            for (int j=i-1;j>=0;j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public int[] getDp2(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] ends = new int[n];
        int l;
        int r;
        int m;
        int right = 0;
        dp[0] = 1;
        for (int i=1;i<n;i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (ends[m] < arr[i]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            ends[l] = arr[i];
            right = Math.max(l, right);
            dp[i] = l + 1;
        }
        return dp;
    }
    public static void main(String[] args) {

        int a[] = {
                5, 3, 4, 8, 6, 7
        };

        sequence(a, a.length);


    }
}

