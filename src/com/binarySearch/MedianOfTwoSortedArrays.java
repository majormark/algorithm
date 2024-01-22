package com.binarySearch;

/**
 * 寻找两个有序数组的中位数 lc 4
 */
public class MedianOfTwoSortedArrays {

    public double findKthElement2(int[] nums1, int[] nums2, int k) {
        int s1 = 0;
        int s2 = 0;
        int k1 = 0;
        int k2 = 0;

        while (k > 1) {
            if (s1 == nums1.length) return nums2[s2 + k - 1];
            if (s2 == nums2.length) return nums1[s1 + k - 1];

            int d = k / 2 - 1;
            k1 = s1 + d;
            k2 = s2 + d;
            k1 = k1 >= nums1.length ? nums1.length - 1 : k1;
            k2 = k2 >= nums2.length ? nums2.length - 1 : k2;
            if (nums1[k1] > nums2[k2]) {
                k = k - (k2 - s2 + 1);
                s2 = k2 + 1;
            } else {
                k = k - (k1 - s1 + 1);
                s1 = k1 + 1;
            }
        }
        if (s1 == nums1.length) return nums2[s2];
        if (s2 == nums2.length) return nums1[s1];
        return Math.min(nums1[s1], nums2[s2]);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            return findKthElement2(nums1, nums2, total / 2 + 1);
        } else {
            return (findKthElement2(nums1, nums2, total / 2) + findKthElement2(nums1, nums2, total / 2 + 1)) * 0.5;
        }
    }

    public static void main(String[] args) {
        System.out.println(-9 % 5);
    }
}
