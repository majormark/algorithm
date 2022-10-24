package com.array;

/**
 * 数组中子数组的最大累乘积
 */
public class CumulativeMultiply {
    public double getMaxMultiply(double[] arr) {
        double max = arr[0];
        double min = arr[0];
        double maxTmp = 0;
        double minTmp = 0;
        double res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxTmp = max * arr[i];
            minTmp = min * arr[i];
            max = Math.max(Math.max(maxTmp, minTmp), arr[i]);
            min = Math.min(Math.min(maxTmp, minTmp), arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
