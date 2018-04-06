package com.dp;

import java.util.Arrays;

public class LongestIncreasingSequence {

    public static int sequence(int[] a, int n) {
        int len = 1;
        int[] d = new int[n];
        for (int i=0;i<n;i++) {

            d[i] = 1;
            for (int j=0;j<i;j++) {
                if (a[j] <= a[i] && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
            if (d[i] > len)
                len = d[i];
        }
        System.out.println("d[]: " + Arrays.toString(d));
        return len;
    }
    public static void main(String[] args) {

        int a[] = {
                5, 3, 4, 8, 6, 7
        };

        sequence(a, a.length);


    }
}

