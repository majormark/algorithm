package com.string;

/**
 * 0左边必有1的二进制字符串数量
 */
public class LeftOfZeroMustBeOne {
    public int getNum1(int n) {
        if (n <= 0) {
            return 0;
        }
        return process(0, n);
    }

    public int process(int i, int n) {
        if (i == n) {
            return 1;
        }
        if (i == n - 1) {
            return 2;
        }
        return process(i+1, n) + process(i+2, n);
    }

    public int getNum2(int n) {
        if (n < 1) {
            return 0;
        }
        int pre = 1;
        int cur = 2;
        int tmp = 0;
        for (int i = n-2; i >= 0; i--) {
            tmp = cur + pre;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}
