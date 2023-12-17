package com.map.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    // 454. 4Sum II
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int res = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int key = nums1[i] + nums2[j];
                m.put(key, m.getOrDefault(key, 0) + 1);
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int key = -(nums3[i] + nums4[j]);
                res += m.getOrDefault(key, 0);
            }
        }
        return res;
    }

    //18. 4Sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int subTarget = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (subTarget >= 0 && nums[j] > subTarget) {
                    break;
                }
                if (subTarget < 0 && nums[j] > 0) break;
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int subSum = nums[j] + nums[left] + nums[right];
                    if (subSum > subTarget) right--;
                    else if (subSum < subTarget) left++;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                        while (left < right && nums[left - 1] == nums[left]) left++;
                        while (left < right && nums[right + 1] == nums[right]) right--;
                    }
                }
            }
        }
        return res;
    }
}
