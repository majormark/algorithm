package com.greedy;

public class JumpGame {
    //55. Jump Game
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int maxIdx = nums[0];
        for (int i = 0; i <= maxIdx; i++) {
            maxIdx = Math.max(nums[i] + i, maxIdx);
            if (maxIdx >= nums.length - 1) return true;
        }
        return false;
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int cur = 0;
        int next = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            next = Math.max(nums[i] + i, next);
            if (i == cur) {
                cur = next;
                next = 0;
                count++;
                if (cur >= nums.length - 1) break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new JumpGame().jump(new int[]{2,3,1,1,4});
    }
}
