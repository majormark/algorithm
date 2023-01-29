package com.math;

/**
 * 整数反转 lc 7
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        boolean pos = x > 0;
        x = pos ? -x : x;
        int res = 0;
        int num1 = Integer.MIN_VALUE / 10;
        int num2 = Integer.MIN_VALUE- num1 * 10;
        while (x != 0) {
            int m = x % 10;
            x /= 10;
            if (res < num1) {
                return 0;
            }
            if (res * 10 == num1 && m < num2) {
                return 0;
            }
            res = res * 10 + m;
        }
        if (pos && res == Integer.MIN_VALUE) {
            return 0;
        }
        return pos ? - res : res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new ReverseInteger().reverse(463847412));
    }
}
