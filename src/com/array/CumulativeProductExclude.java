package com.array;

/**
 * 不包含本位制的累乘数组 pg 381
 */
public class CumulativeProductExclude {

    public int[] product2(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = arr[i] * res[i - 1];
        }
        int tmp = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            res[i] = res[i - 1] * tmp;
            tmp *= arr[i];
        }
        res[0] = tmp;
        return res;
    }
}
