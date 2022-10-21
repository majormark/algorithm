package com.array;

public class InOrderArrayMaxLengthOfLEK {
    public int getMaxLength(int[] arr, int k) {
        int[] h = new int[arr.length + 1];
        int sum = 0;
        h[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += h[i];
            h[i] = Math.max(h[i-1], sum);
        }
        int len = 0;
        sum = 0;
        int pre = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            pre = getLessIndex(h, sum - k);
            len = pre == -1 ? 0 : i - pre + 1;
            res = Math.max(len, res);
        }
        return res;

    }

    public int getLessIndex(int[] h, int num) {
        int l = 0;
        int r = h.length - 1;
        int mid = (l + r) / 2;
        int res = -1;
        while (l <= r) {
            if (h[mid] >= num) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
