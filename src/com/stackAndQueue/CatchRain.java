package com.stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * leetcode 42
 */
public class CatchRain {
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[left], height[i]) - height[top];
                ans += curWidth * curHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
