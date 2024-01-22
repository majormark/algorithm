package com.math;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = - divisor;
        int a = dividend;
        int res = 0;
        while (a <= divisor) {
            int b = divisor;
            int k = 1;
            // 0xc0000000 是十进制 -2^30 的十六进制的表示
            // 判断 value >= 0xc0000000 的原因：保证 value + value 不会溢出
            // 可以这样判断的原因是：0xc0000000 是最小值 -2^31 的一半，
            // 而 a 的值不可能比 -2^31 还要小，所以 value 不可能比 0xc0000000 小
            // -2^31 / 2 = -2^30

            while (b >= 0xc0000000 && b + b >= a) {
                b = b + b;
                if (k > Integer.MAX_VALUE / 2) {
                    return Integer.MIN_VALUE;
                }
                k = k + k;
            }
            res += k;
            a -= b;
        }
        return sign == 1 ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
    public int divide2(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            if (divisor == 1) return Integer.MIN_VALUE;
        }
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((a >>> i) - b >= 0) {
                a -= (b << i);
                res += (1 << i);
            }
        }
        return sign == 1 ? res : -res;
    }
}
