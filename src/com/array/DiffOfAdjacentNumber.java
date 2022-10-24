package com.array;

public class DiffOfAdjacentNumber {
    public int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        if (min == max) return 0;
        int[] maxB = new int[arr.length + 1];
        int[] minB = new int[arr.length + 1];
        boolean[] hasNum = new boolean[arr.length + 1];
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int b = bucket(len, max, min, arr[i]);
            hasNum[b] = true;
            maxB[b] = Math.max(maxB[b], arr[i]);
            minB[b] = Math.max(minB[b], arr[i]);
        }
        int lastMax = 0;
        int i = 0;
        for (i = 0; i < hasNum.length; i++) {
            if (hasNum[i]) {
                lastMax = maxB[i++];
                break;
            }
        }
        int res = 0;
        for (; i < hasNum.length; i++) {
            if (hasNum[i]) {
                res = Math.max(minB[i] - lastMax, res);
                lastMax = maxB[i];
            }
        }
        return res;
    }

    public int bucket(long len, long max, long min, long num) {
        return (int) ((num - min) * len / (max - min));
    }
}
