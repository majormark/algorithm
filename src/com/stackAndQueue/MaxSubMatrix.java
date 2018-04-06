package com.stackAndQueue;

import java.util.Stack;

/**
 * Created by major on 2017/12/16.
 */
public class MaxSubMatrix {
    public int maxRecSize(int[][] map) {
        if(map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[map[0].length];
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, maxRecFromBottom(height));
        }
        return maxArea;
    }

    public int maxRecFromBottom(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<height.length;i++) {
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int heightIdx = stack.pop();
                int leftIdx = -1;
                if(!stack.isEmpty())
                    leftIdx = stack.peek();
                maxArea = Math.max(maxArea, height[heightIdx] * (i - leftIdx - 1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int heightIdx = stack.pop();
            int leftIdx = -1;
            if(!stack.isEmpty())
                leftIdx = stack.peek();
            maxArea = Math.max(maxArea, height[heightIdx] * (heightIdx - leftIdx));
        }

        return maxArea;
    }


    public static void main(String[] args) {
        int[][] map = {
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}
        };
        MaxSubMatrix m = new MaxSubMatrix();
        System.out.println(m.maxRecSize(map));
    }
}
