package com.dp.base;

//746. Min Cost Climbing Stairs
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0;
        int b = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int res = Math.min(b + cost[i - 1], a + cost[i - 2]);
            a = b;
            b = res;
        }
        return b;
    }
}
