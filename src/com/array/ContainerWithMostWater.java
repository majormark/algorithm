package com.array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max((r - l) * Math.min(height[l], height[r]), res);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
