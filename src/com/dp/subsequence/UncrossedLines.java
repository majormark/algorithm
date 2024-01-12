package com.dp.subsequence;

public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < m + 1; i++) {
            int pre = dp[0];
            for (int j = 1; j < n + 1; j++) {
                int cur = dp[j];
                if (nums1[i-1] == nums2[j-1]) dp[j] = pre + 1;
                else dp[j] = Math.max(dp[j - 1], dp[j]);
                pre = cur;
            }
        }
        return dp[n];
    }
}
