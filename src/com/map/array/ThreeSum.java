package com.map.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.getOrDefault(nums[j], 0) > 0) {
                    continue;
                }
                int tmp = -nums[i] - nums[j];
                if (map.containsKey(tmp)) {
                    res.add(Arrays.asList(nums[i], tmp, nums[j]));
                    map.put(nums[j], 1);
                    continue;
                }
                map.put(nums[j], 0);
            }
        }
        return res;
    }

    // 双指针
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) right--;
                else if (sum < 0) left++;
                else {
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return res;
    }
}
