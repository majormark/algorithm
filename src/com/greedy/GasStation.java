package com.greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff = 0;
        for (int i = 0; i < gas.length; i++) {
            diff += gas[i] - cost[i];
        }
        if (diff < 0) return -1;
        int start = -1;
        diff = 0;
        for (int i = 0; i < gas.length; i++) {
            int tmp = gas[i] - cost[i];
            if (tmp >= 0 && start == -1) {
                start = i;
            }
            diff += tmp;
            if (diff < 0) {
                start = -1;
                diff = 0;
            }
        }
        return start;
    }
}
