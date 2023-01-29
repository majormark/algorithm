package com.array;

/**
 * 寻找两个有序数组的中位数 lc 4
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length, l2 = nums2.length;
        int totalLength = l1 + l2;
        if (totalLength % 2 == 1) {
            return findKthElement(nums1, nums2, (l1 + l2) / 2 + 1);
        } else {
            return (findKthElement(nums1, nums2, (l1 + l2) / 2) + findKthElement(nums1, nums2, (l1 + l2) / 2 + 1)) / 2.0;
        }
    }

    public double findKthElement(int[] nums1, int[] nums2, int k) {
        int offset1 = 0;
        int offset2 = 0;
        int k1 = 0;
        int k2 = 0;

        while (k > 1) {
            if (offset1 == nums1.length) {
                return nums2[offset2 + k - 1];
            }
            if (offset2 == nums2.length) {
                return nums1[offset1 + k - 1];
            }
            int d = (k / 2) - 1;
            k1 = offset1 + d;
            k2 = offset2 + d;
            k1 = k1 >= nums1.length ? nums1.length - 1 : k1;
            k2 = k2 >= nums2.length ? nums2.length - 1 : k2;
            if (nums1[k1] <= nums2[k2]) {
                k = k - (k1 - offset1 + 1);
                offset1 = k1 + 1;
            } else {
                k = k - (k2 - offset2 + 1);
                offset2 += k2 + 1;
            }
        }
        if (offset1 == nums1.length) {
            return nums2[offset2 + k - 1];
        }
        if (offset2 == nums2.length) {
            return nums1[offset1 + k - 1];
        }
        return Math.min(nums1[offset1], nums2[offset2]);
    }
}
