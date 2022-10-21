package com.array;

/**
 * 行列都排好序的矩阵，找数 pg 348
 */
public class OrderedMatrixContains {
    public boolean isContain(int[][] m, int k) {
        int row = m.length - 1;
        int col = m[0].length - 1;
        int r = 0;
        int c = col;
        while (r <= row && c >= 0) {
            if (m[r][c] == k) {
                return true;
            } else if (m[r][c] > k) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
