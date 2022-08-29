package com.dp;

public class MinPathForMatrix {
    public int minPath1(int[][] m) {
        if (m == null || m.length < 1 || m[0] == null || m[0].length < 1) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] p = new int[row][col];
        p[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            p[i][0] = p[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            p[0][j] = p[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                p[i][j] = Math.min(p[i - 1][j], p[i][j - 1]) + m[i][j];
            }
        }
        return m[row - 1][col - 1];
    }

    public int minPath2(int[][] m) {
        if (m == null || m.length < 1 || m[0] == null || m[0].length < 1) {
            return 0;
        }
        int less = Math.min(m.length, m[0].length);
        int more = Math.max(m.length, m[0].length);
        boolean isRowMore = m.length > m[0].length;
        int[] p = new int[less];
        p[0] = m[0][0];
        for (int i=1;i<less;i++) {
            p[i] = p[i-1] + (isRowMore ? m[0][i] : m[i][0]);
        }
        for (int i=1;i<more;i++) {
            p[0] = p[0] + (isRowMore ? m[i][0] : m[0][i]);
            for (int j=1;j<less;j++) {
                p[j] =  Math.min(p[j-1], p[j]) + (isRowMore ? m[i][j] : m[j][i]);
            }
        }
        return p[less-1];
    }
}
