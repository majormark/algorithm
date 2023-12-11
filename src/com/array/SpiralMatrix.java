package com.array;

import java.util.Arrays;

//59. Spiral Matrix II  https://leetcode.cn/problems/spiral-matrix-ii/description/
public class SpiralMatrix {
    public int[][] generateMatrix(int n) {
        int lR = 0;
        int lC = 0;
        int dR = n - 1;
        int dC = n - 1;
        int[][] res = new int[n][n];
        int num = 1;
        while (lR <= dR) {
            num = generate(res, lR++, lC++, dR--, dC--, num);
        }
        return res;
    }
    public int generate(int[][] res, int lR, int lC, int dR, int dC, int num) {
        if (lR > dR) {
            return num;
        }
        if (lR == dR && lC == dC) {
            res[lR][lC] = num++;
            return num;
        }
        for (int j = lC; j < dC; j++) {
            res[lR][j] = num++;
        }
        for (int i = lR; i < dR; i++) {
            res[i][dC] = num++;
        }
        for (int j = dC; j > lC; j--) {
            res[dR][j] = num++;
        }
        for (int i = dR; i > lR; i--) {
            res[i][lC] = num++;
        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SpiralMatrix().generateMatrix(3)));
    }
}
