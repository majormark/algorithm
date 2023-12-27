package com.stackAndQueue;

import java.util.Stack;

//739. Daily Temperatures
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] answer = new int[n];
        stack.push(0);
        for (int i = 1; i < n; i++) {
            int tmp = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < tmp) {
                int idx = stack.pop();
                answer[idx] = i-idx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = 0;
        }
        return answer;
    }
}
