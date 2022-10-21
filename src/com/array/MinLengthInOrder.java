package com.array;

public class MinLengthInOrder {
    public int getMinLength(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int noMinIdx = -1;
        int min = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] <= min) {
                min = arr[i];
            } else {
                noMinIdx = i;
            }
        }
        if (noMinIdx == -1) {
            return 0;
        }
        int noMaxIdx = -1;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            } else {
                noMaxIdx = i;
            }
        }
        return noMaxIdx - noMinIdx + 1;
    }
}
