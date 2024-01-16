package com.stackAndQueue.monotonic;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    int idx = stack.pop();
                    int l = stack.isEmpty() ? -1 : stack.peek();
                    res = Math.max(res, (i - l - 1) * heights[idx]);
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int r = heights.length;
            int idx = stack.pop();
            int l = stack.isEmpty() ? -1 : stack.peek();
            res = Math.max(res, (r - l - 1) * heights[idx]);
        }
        return res;
    }
}
