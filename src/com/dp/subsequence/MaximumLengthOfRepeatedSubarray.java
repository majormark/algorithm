package com.dp.subsequence;

//718. Maximum Length of Repeated Subarray
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        int i = 0, j = nums2.length - 1;
        int len = 0;
        int res = 0;
        while (i < nums1.length) {
            int ii = i;
            int jj = j;
            while (ii < nums1.length && jj < nums2.length) {
                if (nums1[ii] == nums2[jj]) {
                    len++;
                    res = Math.max(len, res);
                } else {
                    len = 0;
                }
                ii++;
                jj++;
            }
            len = 0;
            if (j > 0) j--;
            else i++;
        }

        return res;
    }
}
