package com.binarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) return res;
        int n = nums.length;
        if (nums[0] == target) {
            res[0] = 0;
        } else {
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] > target) r = mid - 1;
                else if (nums[mid] < target) l = mid + 1;
                else {
                    if (nums[mid] == nums[mid - 1]) r = mid - 1;
                    else {
                        res[0] = mid;
                        break;
                    }
                }
            }
        }
        if (nums[n - 1] == target) {
            res[1] = n - 1;
        } else {
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] > target) r = mid - 1;
                else if (nums[mid] < target) l = mid + 1;
                else {
                    if (nums[mid] == nums[mid + 1]) l = mid + 1;
                    else {
                        res[1] = mid;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
